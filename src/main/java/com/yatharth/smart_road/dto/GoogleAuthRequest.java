package com.yatharth.smart_road.dto;

public class GoogleAuthRequest {
    private String email;
    private String name;
    private String password;
    private String googleId;
    private String idToken;
    private String role; // "ROLE_USER" or "ROLE_ADMIN"

    public GoogleAuthRequest() {}

    public GoogleAuthRequest(String email, String name, String password, String googleId, String idToken, String role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.googleId = googleId;
        this.idToken = idToken;
        this.role = role;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getGoogleId() { return googleId; }
    public void setGoogleId(String googleId) { this.googleId = googleId; }

    public String getIdToken() { return idToken; }
    public void setIdToken(String idToken) { this.idToken = idToken; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
