# Volunteer application API

Для большей информации следуйте
[WORD FILE](https://github.com/IldarGreat/volunteerAPI/files/10248228/6131_Suslikova_Grushenkov_Volontery_11_10.2.docx)
### 1.Адрес
#### Сервер находится по адресу 
### 2.Установка/сборка[Варианты]

#### 2.1 Сборка через Dockerfile (НУЖЕН MAVEN для генерации мапперных классов) [Не рекомендуется]
	git clone https://github.com/IldarGreat/volunteerAPI.git
    mvn clean & install & package
	docker build . -t ildarthegreat/volunteerAPI
Этим вы соберете образ, но без PostgreSQL оно работать не будет, все переменные и порты находятся в файле application.yaml
#### 2.2 Запуск через docker-compose [Рекомендуется]
    git clone https://github.com/IldarGreat/volunteerAPI.git
    docker-compose up
#### 2.3 Сборка вручную [Не рекомендуется]
	
### 3.Документация
#### Вся документация находиться по адресу http://  /swagger-ui/index.html

### 4.Связь
#### Для обратной связи писать ildarthegreat@gmail.com
