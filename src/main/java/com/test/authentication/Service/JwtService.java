package com.test.authentication.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET = "xQJoyLy+KupuwDVwepACJsyp+YcXVpLaX8tSwc/5NVlWeuL/Lgi+hNrGCpEgKa1c";

    public String extractUsername(String token) {
        return extractClaims(token , Claims::getSubject);
    }
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public String generateToken(UserDetails userDetails) {

       return generateToken(new HashMap<>(), userDetails);

    }

    public String generateToken(
            Map<String , Object> extraClaims,
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .claims()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .and()
                .signWith(getKey())
                .compact();

    }
    public boolean validateToken(String jwtToken, UserDetails userDetails) {

        final String username = extractUsername(jwtToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
    }

    private boolean isTokenExpired(String jwtToken) {

        return extractExpiration(jwtToken).before(new Date());
    }
    private Date extractExpiration(String jwtToken) {
        return extractClaims(jwtToken, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }
    private SecretKey getKey() {

        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);

    }
}
