package com.backend.cargallery.dao.criteria.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.cargallery.dao.criteria.EmployeeCriteriaRepository;
import com.backend.cargallery.model.Employee;

public class EmployeeCriteriaRepositoryImpl implements EmployeeCriteriaRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findByFirstNameAndLastNameAndPhoneNo(String firstName, String lastName, Long phoneNo) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> employee = criteriaQuery.from(Employee.class);
		List<Predicate> predicates = new ArrayList<>();
		if (firstName != null) {
			predicates.add(criteriaBuilder.equal(employee.get("firstName"), firstName));
		}
		if (lastName != null) {
			predicates.add(criteriaBuilder.equal(employee.get("lastName"), lastName));
		}
		if (phoneNo != null) {
			predicates.add(criteriaBuilder.equal(employee.get("phoneNo"), phoneNo));
		}

		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		return entityManager.createQuery(criteriaQuery).getResultList();

	}

}
