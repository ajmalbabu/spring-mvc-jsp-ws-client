# spring-mvc-jsp-ws-client
When the service is build first time, uncomment the maven plugin to generat the
web service client artifacts. Before doing that make sure 

1) The WSDL is available at the link http://localhost:8090/ws/countries.wsdl
2) The service project is up and running
3) The pom.xml section for WSDL generation is un-commented
4) perform a mvn clean:package this would generate the web service client artifacts under
src/main/resources/country/wsdl copy these resources into src/main/java 
5) remove the generated folder from src/main/resources/country/wsdl  and un-comment
web service client generation plugin from maven pom.xml

Run the server by deploying into tomcat and pass the below -D argument to tomcat before
starting, also make sure the service layer project us running before deploying this

-Dws.host=localhost -Dws.port=8090

application can be accessed at http://localhost:9080/LegacyWebApp/

This web service client example is taken from https://spring.io/guides/gs/consuming-web-service/
