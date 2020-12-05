package ro.fasttrackit.curs18.countries.countriesspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountriesSpringApplication.class, args);
        CountryService countryService = new CountryService();
        System.out.println(countryService.getCountries());
        System.out.println(countryService.getCapitalOfCountry(187));
        System.out.println();
        System.out.println(countryService.getCountriesWithLargerPopulation("Europe", 20000000));
        System.out.println();
        System.out.println(countryService.getCountryWithSelectedNeighbours("HUN", "ROU"));

    }

}
