## ReadMe.MD
The project in this case was created using the java(SpringBoot) and DB (MySql).
- Import the sql script(preffereably use [Xampp](https://www.apachefriends.org/download.html))

- [optional] Import the maven project in your favourite IDE.
   > Note: `Java 8 , MySql and [Maven](https://maven.apache.org/) ` are required. Download **[Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)** and  **[Maven](https://maven.apache.org/)** 

- If using windows install - **[Git](https://git-scm.com/).**
- Create usernames in Africas Talking or any SMS API handler -**[Africastalking](https://africastalking.com)**
- Create usernames in Sendgrid  or any Email API handler - **[Sendgrid](https://sendgrid.com/)**
- Replace the above usernames and API keys extracted in the above steps[3 & 4] in the Apllication.properties file located in   **`./middleware/src/main/resources"`**
- Proceed to the location **`./middleware/`**
- Run the following commmand usig your CMD/Terminal:  

```
mvn spring-boot:run
```



- After a successful build and run head to http://localhost:8089/swagger-ui.html

>NOTE: If the naming of the apis are wrong all the smses and emails wont send.

Linux Installation of requirements and running the program(manual installation of your sqll client is required)

```
sudo apt-get update 
sudo apt-get upgrade -y
sudo apt-get install openjdk-8-jre maven -y
mvn spring-boot:run
```

FrontEnd Coming Soon