package ro.fasttrackit.curs18.countries.countriesspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;

    }

    @GetMapping()
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/names")
    public List<String> getCountryNames() {
        return countryService.getCountryNames();
    }

    @GetMapping("/{id}/capital")
    public String getCapitalofCountry(@PathVariable int id) {
        return countryService.getCapitalOfCountry(id);
    }

    @GetMapping("/{id}/population")
    public long getPopulationOfCountry(@PathVariable int id) {
        return countryService.getPopulationOfCountry(id);
    }

    @GetMapping("/continents/{continentName}/countries")
    public List<Country> getCountriesInContintent(@PathVariable String continentName) {
        return countryService.getCountriesInContintent(continentName);
    }

    @GetMapping("/{id}/neighbours")
    public List<String> getCountryNeighbours(@PathVariable int id) {
        return countryService.getCountryNeighbours(id);
    }

    @GetMapping("/continents/{continentName}/countries?minpop={minPopulation}")
    public List<Country> getCountriesWithLargerPopulation(@PathVariable String continentName,
                                                          @PathVariable long minPopulation) {
        return countryService.getCountriesWithLargerPopulation(continentName, minPopulation);
    }

    @GetMapping("?includedNeighbour={includedNeighbour}&excludedNeighbour={excludedNeighbour}")
    public List<Country> getCountryWithSelectedNeighbours(@PathVariable String includedNeighbour,
                                                          String excludedNeighbour) {
        return countryService.getCountryWithSelectedNeighbours(includedNeighbour, excludedNeighbour);
    }

    @GetMapping("/population")
    public Map<String, Long> mapCountryToPopulation() {
        return countryService.mapContryToPopulation();
    }

    @GetMapping("/continents/countries")
    public Map<String, List<Country>> mapContinentToCountries() {
        return countryService.mapContinentToCountries();
    }
}
