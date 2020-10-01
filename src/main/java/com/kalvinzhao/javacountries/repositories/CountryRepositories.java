package com.kalvinzhao.javacountries.repositories;

//repositories connects apps with database

import com.kalvinzhao.javacountries.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepositories extends CrudRepository<Country, Long> { //<our model, type of the primary key>
}
