package ro.fasttrackit.curs18.countries.countriesspring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final List<Country> countries = new ReadingCountries().readingCountry("C:\\Users\\raulp\\Desktop\\Java\\javaText\\countries2.txt");

    public CountryService() {
        setID();
    }

    private void setID() {
        for (Country country : countries) {
            country.setId(countries.indexOf(country));
        }
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<String> getCountryNames() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    public String getCapitalOfCountry(int id) {
        return countries.stream()
                .filter(country -> country.getId() == id)
                .findFirst()
                .get()
                .getCapital();
    }

    public long getPopulationOfCountry(int id) {
        return countries.stream()
                .filter(country -> country.getId() == id)
                .findFirst()
                .get()
                .getPopulation();
    }

    public List<Country> getCountriesInContintent(String continent) {
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continent))
                .collect(Collectors.toList());
    }

    public List<String> getCountryNeighbours(int id) {
        return countries.stream()
                .filter(country1 -> country1.getId() == id)
                .findAny()
                .get()
                .getNeighbours();

    }

    public List<Country> getCountriesWithLargerPopulation(String continent, long population) {
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continent))
                .filter(country -> country.getPopulation() >= population)
                .collect(Collectors.toList());
    }

    public List<Country> getCountryWithSelectedNeighbours(String n1, String n2) {
        return countries.stream()
                .filter(country -> country.getNeighbours().contains(n1))
                .filter(country -> !country.getNeighbours().contains(n2))
                .collect(Collectors.toList());
    }

    public Map<String, Long> mapContryToPopulation() {
        return countries.stream()
                .collect(Collectors.toMap(Country::getName, Country::getPopulation));

    }

    public Map<String, List<Country>> mapContinentToCountries() {
        Map<String, List<Country>> result = new HashMap<>();
        for (Country country : countries) {
            List<Country> countriesContinent = result.get(country.getContinent());
            if (countriesContinent == null) {
                countriesContinent = new ArrayList<>();
                result.put(country.getContinent(), countriesContinent);
            }
            countriesContinent.add(country);
        }
        return result;
    }

    private List<String> union(List<String> l1, List<String> l2) {
        List<String> result = new ArrayList<>(l1);
        result.addAll(l2);
        return result;
    }
}

