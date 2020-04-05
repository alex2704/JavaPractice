package com.soap;

import services.all.GetPersonDocument;
import services.all.GetPersonResponseDocument;
import services.all.GetPersonsByAgeDocument;
import services.all.GetPersonsByAgeResponseDocument;

public class SoapService implements com.soap.SoapServiceSkeletonInterface {

    public GetPersonsByAgeResponseDocument getPersonsByAge(GetPersonsByAgeDocument getPersonsByAge) {
        return null;
    }

    public GetPersonResponseDocument getPerson(GetPersonDocument getPerson) {
        return null;
    }
}
