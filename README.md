# Felvételi feladat (FICS)
## Alkalmazott karbantartó alkalmazás fejlesztése
Ez a felvételi feladat kiindulási pontja.

## Kialakítandó fejlesztői Környezet
* Idea EAP (opcionális)
* Java 11 sdk
* Maven
* Npm
* Git
* Relációs adatbázis példány (opcionális)

## Kezdeti lépések
```shell script
  git clone https://github.com/SzaszGK/interview.git
  cd interview
  mvn clean spring-boot:run
``` 

## Feladatok
Angular 8 front-end fejlesztése
* entitás felvétele    
  ```shell script
    curl -X POST \
      http://localhost:8888/springboot-crud-rest/employee \
      -H 'Cache-Control: no-cache' \
      -H 'Content-Type: application/json' \
      -d '{
    	"firstName": "Elek",
    	"lastName": "Teszt"
    }'
  ```
* lista funkció
  ```shell script
  curl -X GET \
    http://localhost:8888/springboot-crud-rest/employee \
    -H 'Cache-Control: no-cache' 
  ```
* módosító funkció
  ```shell script
  curl -X PUT \
    http://localhost:8888/springboot-crud-rest/employee/1 \
    -H 'Cache-Control: no-cache' \
    -H 'Content-Type: application/json' \
    -d '{
  	"firstName": "Elek",
  	"lastName": "Teszt2"
  }'
  ```

## Plusz feladat
* biztonság: Spring Security használata In-Memory auth
    A listázás maradjon engedélyezett bárki számára... (permitAll())
* git remote repo használata
* Telepített adatbázis példány használatának lehetősége spring profile használatával
