package org.springmvc.controller;


import country.wsdl.Country;
import country.wsdl.GetCountryRequest;
import country.wsdl.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iky215 on 4/24/15.
 */

public class WebServiceClient extends WebServiceGatewaySupport {

    private String hostName;
    private String portNumber;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }


    public List<Country> retrieveCountries(String countryCode,int count) {

        List<Country> resultCountries = new ArrayList<Country>();

        for (int i = 0; i < count; i++) {

            GetCountryRequest request = new GetCountryRequest();
            request.setName(countryCode);
            request.setCount(1);

            GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(request,
                    new SoapActionCallback("http://" + getHostName()
                            + ":" + getPortNumber() + "/ws/countries"));

            print(response);

            Country country = response.getCountry().get(0);

            country.setName(country.getName() + "-" + i);
            country.setCapital(country.getCapital() + "-" + i);
            country.setPopulation(country.getPopulation() + i);

            resultCountries.addAll(response.getCountry());
        }

        print(resultCountries);


        return resultCountries;
    }


    private void print(GetCountryResponse response) {
        print(response.getCountry());

    }

    private void print(List<Country> countries) {
        for (Country country : countries) {
            System.out.println("Country name: " + country.getName()
                    + "; Country capital: " + country.getCapital()
                    + "; Country currency: " + country.getCurrency()
                    + "; Country info: " + country.getInfo());

        }
    }
}
