package org.springmvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Created by iky215 on 4/24/15.
 */

@Configuration
public class WebServiceClientConfiguration {

    @Value("#{ systemProperties['ws.host'] }")
    private String hostName;

    @Value("#{ systemProperties['ws.port'] }")
    private String portNumber;


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("country.wsdl");
        return marshaller;
    }

    @Bean
    public WebServiceClient webserviceClient(Jaxb2Marshaller marshaller) {
        WebServiceClient client = new WebServiceClient();
        client.setHostName(hostName);
        client.setPortNumber(portNumber);
        client.setDefaultUri("http://" + hostName + ":" + portNumber + "/ws/countries");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
