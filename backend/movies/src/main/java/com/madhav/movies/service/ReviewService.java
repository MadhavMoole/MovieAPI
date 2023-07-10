package com.madhav.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.madhav.movies.entities.Movie;
import com.madhav.movies.entities.Review;
import com.madhav.movies.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MongoTemplate template;
	
	public Review createReview(String reviewBody, String imdbId) {
		Review review = repository.insert(new Review(reviewBody));
		template.update(Movie.class)
						.matching(Criteria.where("imdbId").is(imdbId))
						.apply(new Update().push("reviewIds").value(review));
		return review;
	}
}
