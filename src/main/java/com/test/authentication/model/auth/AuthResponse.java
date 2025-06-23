package com.test.authentication.model.auth;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "authResponse")
public class AuthResponse {

    private String token;


}
