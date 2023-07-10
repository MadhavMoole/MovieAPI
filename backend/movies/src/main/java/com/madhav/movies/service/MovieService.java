package com.madhav.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.madhav.movies.entities.Movie;
import com.madhav.movies.repository.MoviesRepository;

@Service
public class MovieService {
	
	@Autowired
	private MoviesRepository repository;
	
	public ResponseEntity<List<Movie>> allMovies() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	public Optional<Movie> getMovieById(String imdbId) {
		return repository.findMovieByImdbId(imdbId);
	}
}
