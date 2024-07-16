# Spring Boot Todo App on Google Cloud Run
This project aims to run a simple Todo application developed using Spring Boot on Google Cloud Run.
## Prerequisites
- Java 21 installed
- Maven installed
- PostgreSQL database set up and running
- Google Cloud SDK (gcloud CLI) installed

## Setup

### 1- Initialize the Spring Boot Project\
Run the following command to initialize a Spring Boot project:

`
spring init --dependencies=web,data-jpa,postgresql --type=maven-project --javaVersion=21 google-cloud-spring-deployment
`\
if you encounter 'spring' is not recognized you need to install "Spring Boot CLI" via homebrew for macos. 


### 2- Configure PostgreSQL Database\
Add the following configuration to your application.properties file:
!!Please change the postgre credentials for your code
google-cloud-spring-deployment -> db name
postgres -> postgresql username
admin -> postgresql password

`
spring.datasource.url=jdbc:postgresql://localhost:5432/google-cloud-spring-deployment
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
`

### 3- Install and Configure Google Cloud SDK

Download and install the Google Cloud SDK from here: https://cloud.google.com/sdk/docs/install and initialize it:
`gcloud init`
Login to gcloud CLI and select your project or create a new one:

`gcloud auth login
gcloud projects create my-spring-todo-app
gcloud config set project my-spring-todo-app`

### 4. Enable Billing
Enable billing in the Google Cloud Console:
- Go to the Billing section in the Google Cloud Console.
- Create a new billing account.

### 5. Deploy the Application
Deploy your application to Google Cloud Run using the following command:

`gcloud run deploy --source . --update-env-vars SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/google-cloud-spring-deployment,SPRING_DATASOURCE_USERNAME=postgres,SPRING_DATASOURCE_PASSWORD=admin`

#### References and Acknowledgements

- Inspired by the detailed guide on deploying Spring Boot applications on Google Cloud Run: [Create and Deploy Spring Boot Todo App to Google Cloud Run](https://docs.rapidapp.io/blog/create-and-deploy-spring-boot-todo-app-to-google-cloud-run).
- For deploying Quarkus applications to Google Cloud, see [Deploying to Google Cloud - Quarkus](https://quarkus.io/guides/deploying-to-google-cloud).
