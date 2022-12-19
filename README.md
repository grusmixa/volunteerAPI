# Volunteer application API

### For more information see [WORD FILE](https://github.com/IldarGreat/volunteerAPI/files/10248228/6131_Suslikova_Grushenkov_Volontery_11_10.2.docx) <br>
### Russian README version [RUSSIAN README](https://github.com/IldarGreat/volunteerAPI/blob/main/README_rus.md)
### 1.Network address 
#### Server address is https://volunteerapi-production.up.railway.app/
### 2.Install/build[Options]

#### 2.1 Build with image from dockerhub [Not recommended]
    git clone https://github.com/IldarGreat/volunteerAPI.git
    mvn clean & install & package
    docker run ildarthegreat/volunteerAPI:(some version)
If you do this, you build image, but withour PostgreSQL it now run, all environments are in the file application.yaml
#### 2.2 Run via docker-compose [Higly recommended]
    git clone https://github.com/IldarGreat/volunteerAPI.git
    docker-compose up
#### 2.3 Build from source (MAVEN NEED TO BE INSTALLED for generating mapper classes) [Not recommended]
    git clone https://github.com/IldarGreat/volunteerAPI.git
    mvn clean & install & package
    Then run postgresql with all envoriment that placed at file application.yaml
    java jar target/volunteerAPI-0.0.1.jar
### 3.Documentation
#### Documentation placed at https://volunteerapi-production.up.railway.app/swagger-ui/index.html

### 4.Feedback 
#### My email ildarthegreat@gmail.com

