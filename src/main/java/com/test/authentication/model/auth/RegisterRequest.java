package com.test.authentication.model.auth;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "registerRequest")
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
