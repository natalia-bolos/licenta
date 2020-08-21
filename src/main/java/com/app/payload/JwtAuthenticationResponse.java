package com.app.payload;

public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private int userId;
    private String name;

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public JwtAuthenticationResponse(String accessToken, int userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }

    public JwtAuthenticationResponse(String accessToken, int userId, String name) {
        this.accessToken = accessToken;
        this.userId = userId;
        this.name = name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
