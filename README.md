# Car-Gallery-BackEnd
Spring Boot kullanarak geliştirdiğim Car-Gallery-BackEnd

## Veritabanı
Veritabanı olarak MySQL veritabanını kullanarak projenin UML yapısına uygun şekilde tablolar bulunmaktadır.
<br/>

![T_CUSTOMER](https://user-images.githubusercontent.com/98321848/162589507-fc62f5c6-8f84-4b18-af7e-db8a83767e69.png)
![T_EMPLOYEE](https://user-images.githubusercontent.com/98321848/162589508-305a72ab-dc87-425b-a5e0-5d23a459f3dd.png)
![t_car](https://user-images.githubusercontent.com/98321848/162589516-55fa116a-ef4f-409e-a43c-de38220bcd11.png)
![T_PAYMENT](https://user-images.githubusercontent.com/98321848/162589509-d5899d5b-0470-436a-aae9-18c974a590d9.jpg)
![T_RENTAL](https://user-images.githubusercontent.com/98321848/162589510-376b20e2-fb1c-4188-a069-1731c75684a2.png)
![T_BOOKING](https://user-images.githubusercontent.com/98321848/162589518-fbf85ff6-8d25-40d2-81db-a36f3ca28ad4.jpg)
![T_USER](https://user-images.githubusercontent.com/98321848/162589512-be0e6afc-19ba-44fc-9466-b785e33ac2b1.jpg)
![T_CAR_IMAGES](https://user-images.githubusercontent.com/98321848/162589519-db17baec-0d9d-4f1e-b699-97bea5150d99.png)
![T_CAR_STATUS](https://user-images.githubusercontent.com/98321848/162589520-d1bc0e99-c911-4e11-ac8f-555f7fdccd72.png)
![T_USER_ROLES](https://user-images.githubusercontent.com/98321848/162589513-c5d9fd91-31a0-4dca-b79b-ab0354ab8c6a.png)
![T_ROLE](https://user-images.githubusercontent.com/98321848/162589515-0903e04b-6ec5-45ae-8700-47630dc65a69.png)

<br/>

## Proje Mimarisi
![spring boot mimari](https://user-images.githubusercontent.com/98321848/162589875-999fdd87-07be-4330-803b-b34848b736ad.png)
<br/>
Spring Boot uygulama mimarisi;<br/>
Controller: Uygulamamızın REST api'leri belirlediği ve dışarıdan belirlenen apilere gelen verileri Service katmanına aktarmak için kullandığım katmandır.<br/>
Service Layer: Repository bean'leri üzerinde gerçekleştirdiğim Create, Update, Read ve Delete işlemleri ile bean'leri işleyip ve kontrollerin yapılıp, uygunluğuna göre veri tabanına kaydedildiği ve uygunluğuna göre cevap dönüldüğü katman olarak kullandım. <br/>
Repository: Veritabanı ile iletişime geçtiğimiz katman. Veritabanı bağlatısı için JPA hibernate kullanarak gerçekleştirdim.

<br/>

## Proje Test Süreci
Geliştirdiğim uygulamamda unit test yazmaya özen gösteriyorum  ve yazdığım api ve servislerin testlerini postman üzerindende test ediyorum.
<br/>
![Postman 9 04 2022 23_13_18](https://user-images.githubusercontent.com/98321848/162590176-fee18792-998f-448c-ad01-d9619abb9701.png)
![Postman 9 04 2022 23_20_10](https://user-images.githubusercontent.com/98321848/162590369-2c41df59-b048-405b-bb35-803b8cf85103.png)
![Postman 9 04 2022 23_17_51](https://user-images.githubusercontent.com/98321848/162590373-964d831c-05a0-4180-84cc-53b8eaa3a514.png)


