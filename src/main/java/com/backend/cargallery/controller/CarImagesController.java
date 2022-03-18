package com.backend.cargallery.controller;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.backend.cargallery.model.CarImages;
import com.backend.cargallery.payload.MessageResponse;

import com.backend.cargallery.service.impl.CarImagesServiceImpl;
import com.backend.cargallery.service.impl.CarServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/images")
public class CarImagesController {
	
	
	
	@Autowired
	private CarImagesServiceImpl carImagesServiceImpl;

	@PostMapping("/upload")
	public ResponseEntity<MessageResponse> uploadFile(@RequestParam("id") String id,@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			carImagesServiceImpl.store(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}
	}
	@GetMapping("/files")
	  public ResponseEntity<List<FileInfo>> getListFiles() {
	   
	      List<FileInfo> files = carImagesServiceImpl.getAllFiles().map(dbFile -> { String fileDownloadUriString = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/images/files/").path(dbFile.getId()).toUriString();
	      return new FileInfo(dbFile.getName(), fileDownloadUriString, dbFile.getType(), dbFile.getImages().length);
	      }).collect(Collectors.toList());
	      
	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		CarImages fileDB = carImagesServiceImpl.getFile(id);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getImages());
	}

}
