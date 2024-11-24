package com.example.finalproject.jwt;

public class AuthenticationResponse {
	private final String token;

	public AuthenticationResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
}
