package com.kalvinzhao.javacountries.controllers;

import com.kalvinzhao.javacountries.models.Country;
import com.kalvinzhao.javacountries.repositories.CountryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //tells the spring framework, this is where we search for Routes
public class CountryController {

    @Autowired //give the class and the name of the object, autowire handle creating the instance of that object, providing any parameter that is needed, and calling the right constructor
    CountryRepositories countryrepo;

    private List<Country> findCountry(List<Country> myList, CheckCountry test){
        List<Country> countries = new ArrayList<>();
        for (Country c: myList) {
            if (test.test(c)){
                countries.add(c);
            }
        }
        return countries;
    }

    // http://localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCountries(){
        List<Country> myList = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(myList::add); //for each remaining element in the list, add it to the arraylist
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> findAllLetter(@PathVariable char letter){ //letter has to match {letter} from previous line
        List<Country> myList = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(myList::add); //for each remaining element in the list, add it to the arraylist
        List<Country> filteredList = findCountry(myList, e-> e.getName().charAt(0) == letter);
        filteredList.sort((item1,item2)->item1.getName().compareToIgnoreCase(item2.getName()));
        return new ResponseEntity<>(filteredList, HttpStatus.OK);
    }

    // http://localhost:2019/population/total
    @GetMapping(value = "/population/total", produces = {"application/json"})
    public ResponseEntity<?> findTotalPopulation(){
        List<Country> myList = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(myList::add);

        long population = 0;
        for (Country c : myList){
            population += c.getPopulation();
        }
        System.out.println(population);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/population/min
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> findMinPopulation(){
        List<Country> myList = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(myList::add);
        long population = 999_999_999;
        List<Country> country = new ArrayList<>();
        for (Country c : myList){
            if (population>c.getPopulation()){
                population = c.getPopulation();
                if (country.size() != 0){
                    country.remove(0);
                }
                country.add(c);
            }
        }
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    // http://localhost:2019/population/max
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> findMaxPopulation(){
        List<Country> myList = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(myList::add);
        long population = -999_999_999;
        List<Country> country = new ArrayList<>();
        for (Country c : myList){
            if (population<c.getPopulation()){
                population = c.getPopulation();
                if (country.size() != 0){
                    country.remove(0);
                }
                country.add(c);
            }
        }
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    // http://localhost:2019/population/median
    @GetMapping(value = "/population/median", produces = {"application/json"})
    public ResponseEntity<?> findMedianPopulation(){
        List<Country> myList = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((item1,item2)-> (int)(item1.getPopulation() - item2.getPopulation()));
        int index = (int)((myList.size()+1) / 2);
        return new ResponseEntity<>(myList.get(index), HttpStatus.OK);
    }
}
