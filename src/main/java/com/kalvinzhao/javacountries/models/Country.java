package com.kalvinzhao.javacountries.models;

import javax.persistence.*;

@Entity //entity is a table
@Table(name = "countries")  //we change the name of our table
public class Country {
//    countryid, name, population, landmasskm2, medianage

    @Id //make the next id the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //let the database generate the ID
    private long countryid;
    private String name;
    private long population;
    private long landmasskm2;
    private int medianage;

    public Country(String name, int population, int landmasskm2, int medianage) {
        this.name = name;
        this.population = population;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandmasskm2() {
        return landmasskm2;
    }

    public void setLandmasskm2(int landmasskm2) {
        this.landmasskm2 = landmasskm2;
    }

    public int getMedianage() {
        return medianage;
    }

    public void setMedianage(int medianage) {
        this.medianage = medianage;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryid=" + countryid +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", landmasskm2=" + landmasskm2 +
                ", medianage=" + medianage +
                '}';
    }
}
