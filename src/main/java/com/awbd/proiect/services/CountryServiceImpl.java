package com.awbd.proiect.services;

import com.awbd.proiect.domain.Country;
import com.awbd.proiect.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries = new LinkedList<>();
        countries = countryRepository.findAll();
        return countries;
    }
}
