package io.github.arcanrun.soapexample.repository;

import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.Currency;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true )
public class CountryRepository {

    Map<String, Country> countryMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            Country country = new Country();
            country.setCapital("Capital_" + i);
            country.setCurrency(Currency.EUR);
            country.setName("Country_" + i);
            country.setPopulation(new Random(100).nextInt());
            countryMap.put("country_" + i, country);
        }

    }

    public Country getCountryByName(String countryName){
        log.info("countryMap = {}", countryMap);
        return countryMap.get(countryName);
    }
}
