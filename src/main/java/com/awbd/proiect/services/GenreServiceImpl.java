package com.awbd.proiect.services;

import com.awbd.proiect.domain.Genre;
import com.awbd.proiect.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> genres = new LinkedList<>();
        genres = (List<Genre>) genreRepository.findAll();
                //--genreRepository.findAll(Sort.by("name")).iterator().forEachRemaining(genres::add);
        return genres;
    }
}
