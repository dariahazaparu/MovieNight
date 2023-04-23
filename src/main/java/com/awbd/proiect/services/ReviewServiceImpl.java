package com.awbd.proiect.services;

import com.awbd.proiect.domain.Review;
import com.awbd.proiect.exceptions.ResourceNotFoundException;
import com.awbd.proiect.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findByMovie(long id) {
        List<Review> reviews = new LinkedList<>();
        reviews = reviewRepository.findByMovie(id);
        return reviews;
    }

    @Override
    public Review findById(long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty())
            throw new ResourceNotFoundException("Review not found");
        return review.get();
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(long id) {
        reviewRepository.deleteById(id);
    }
}
