package com.awbd.proiect.services;

import com.awbd.proiect.domain.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findByMovie(long id);
    Review findById(long id);
    Review save(Review review);
    void deleteById(long id);
}
