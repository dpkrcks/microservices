package com.dpkrcks.rating.service.RatingService.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){

        super("Unable to find the resource");
    }
    public ResourceNotFoundException(String message) {

        super(message);
    }
}
