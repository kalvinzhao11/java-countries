package com.kalvinzhao.javacountries.controllers;

import com.kalvinzhao.javacountries.repositories.CountryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //tells the spring framework, this is where we search for Routes
public class CountryController {

//    The following URLs should return the requested data given the parameters
//
//* [ ] /names/all - return the names of all the countries alphabetically
//* [ ] /names/start/{letter} - return the countries alphabetically that begin with the given letter
//
//* [ ] /population/total - return the total population of all countries in the console while returning Http Status OK as the response.
//* [ ] /population/min - return the country with the smallest population
//* [ ] /population/max - return the country with the largest population
//
//### Stretch Goal
//
//* [ ] /population/median - return the country with the median population

    @Autowired //give the class and the name of the object, autowire handle creating the instance of that object, providing any parameter that is needed, and calling the right constructor
    CountryRepositories countryrepo;
    // http://localhost:2019/names/all
//    @GetMapping(value = "/names/all", produces = {"application/json"})
//    public ResponseEntity
    // http://localhost:2019/population/total

    // http://localhost:2019/population/min

    // http://localhost:2019/population/max

    // http://localhost:2019/population/median
}
