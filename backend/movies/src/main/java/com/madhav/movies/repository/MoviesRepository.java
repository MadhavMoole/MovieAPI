package com.madhav.movies.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.madhav.movies.entities.Movie;

@Repository
public interface MoviesRepository extends MongoRepository<Movie, ObjectId>{
	Optional<Movie> findMovieByImdbId(String imdbId);
}
