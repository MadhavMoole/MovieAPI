package com.madhav.movies.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhav.movies.entities.Movie;
import com.madhav.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping("/allMovies")
	public ResponseEntity<List<Movie>> allMovies() {
		return service.allMovies();
	}
	
	@GetMapping("/{imdbId}")
	public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable("imdbId") String imdbId) {
		return new ResponseEntity<>(service.getMovieById(imdbId), HttpStatus.OK);
	}
	
}
