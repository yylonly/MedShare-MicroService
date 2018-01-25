### Pre-requested
* JDK 8
* Maven
* Docker CE and Docker Compose

### Git Clone Repo
* git clone https://github.com/yylonly/MedShare-MicroService
* cd MedShare-MicroService

### Build You Package
* mvn clean package

### Build Environments
* docker-compose build (build images)
* docker-compose up (run containers)

### Test MedShare
* Glassfish Management http://127.0.0.1:4848 (username:admin password:glassfish)
* MedShare will be avaible on http://127.0.0.1:8080/MicroMedShare-web/
* username: admin 
* password: 123