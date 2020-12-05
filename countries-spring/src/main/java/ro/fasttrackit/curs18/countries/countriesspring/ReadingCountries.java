package ro.fasttrackit.curs18.countries.countriesspring;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReadingCountries {
    public List<Country> readingCountry(String file) {
        List<Country> result = new ArrayList<>();
        String line = "";
        try (BufferedReader bfr = new BufferedReader(new FileReader(file))) {
            while ((line = bfr.readLine()) != null) {
                result.add(gettingCountry(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    private Country gettingCountry(String line) {
        String[] arr = line.split("\\|");
        List<String> neighbours = new ArrayList<>();
        if (arr.length > 5) {
            neighbours = splittingNeighbours(arr[5]);
        }

        return new Country(arr[0],
                arr[1],
                Long.parseLong(arr[2]),
                Long.parseLong(arr[3]),
                arr[4],
                neighbours);
    }

    private List<String> splittingNeighbours(String s) {
        String[] neighbours = s.split("~");
        List<String> list = new ArrayList<>();
        for (String st : neighbours) {
            list.add(st);
        }
        return list;

    }


}
