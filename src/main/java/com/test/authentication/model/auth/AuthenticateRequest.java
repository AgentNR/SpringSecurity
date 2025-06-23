package com.test.authentication.model.auth;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "authRequest")
public class AuthenticateRequest {

    private String email;

    String password;
}
