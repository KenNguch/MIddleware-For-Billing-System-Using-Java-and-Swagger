The project in this case was created using the java and swagger loca APIs.
0.Import the sql given(it uses xampp): https://www.apachefriends.org/download.html
1.[optional] Import the maven project in the eclipse IDE uses java 8 and above.(must have installed maven and java)


2.if using windows install git.
3.Create usernames in Africas Talking or any sms API handler.(https://africastalking.com)
4.Create usernames in Sendgrid  or any Email API handler(https://sendgrid.com/)
5.Replace the above usernames and API keys extracted in the above steps[3 & 4] in the Apllication.properties file located in   "....../middleware/src/main/resources"
6.proceed to the location ".....  middleware/" and git bash(if using linux cd to that location)
7.Type this command in the Teminal:   "mvn springboot:run"
8. Proceed to opening the browser and paste this link "http://localhost:8089/swagger-ui.html"

NOTE: If the naming of the apis are wrong all the smses and emails wont send.


FrontEnd Coming Soon
