package org.springmvc.controller;

import java.util.List;


import country.wsdl.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchService {

    @Autowired
    private WebServiceClient client;

    public List<Country> fetchCountry(String countryCode, int count) {
        return client.retrieveCountries(countryCode, count);
    }

}
