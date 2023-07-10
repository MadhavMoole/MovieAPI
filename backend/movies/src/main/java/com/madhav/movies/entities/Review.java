package com.madhav.movies.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	@Id
	private ObjectId id;
	private String body;
	
	public Review(String body) {
		super();
		this.body = body;
	}
	
	
}
