package com.demo.dataexchangeapi.service;

import com.demo.dataexchangeapi.model.AuthData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthDataService {
    private final ObjectMapper objectMapper;

    public AuthData getAuthData() {
        try {
            return objectMapper.readValue(getDecodedTokenPayload(), AuthData.class);
        } catch (IOException e) {
            throw new RuntimeException("error while getting data from token", e);
        }
    }

    private byte[] getDecodedTokenPayload() {
        return Base64.decodeBase64(getTokenPayload());
    }

    private String getTokenPayload() {
        return getToken().split("\\.")[1];
    }

    private String getToken() {
        return ((Jwt) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal())
                .getTokenValue();
    }
}
