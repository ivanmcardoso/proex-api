package com.gear.proex.security.jwt;

import com.gear.proex.exception.InvalidAuthenticationExeption;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtTokenProvider {

    @Value("${security.jwt.token.secret-key:secret}")
    public String secretKey = "secret";

    @Value("${security.jwt.token.expire-lenght:360000}")
    private long validyMillisenconds = 360000;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostConstruct
    public void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String userName, List<String> roles){
        Claims claims = Jwts.claims().setSubject(userName);
        claims.put("roles",roles);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validyMillisenconds);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUserName(token));
        return  new UsernamePasswordAuthenticationToken(userDetails,"", userDetails.getAuthorities());
    }

    private String getUserName(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req){
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public boolean validateToken(String token){
        try {
            Jwt<Header, Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token);
            if(claims.getBody().getExpiration().before(new Date())){
                return false;
            }
            return true;
        } catch ( Exception e) {
            throw new InvalidAuthenticationExeption("Expired or invalid token");
        }
    }
}
