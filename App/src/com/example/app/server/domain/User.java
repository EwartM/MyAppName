package com.example.app.server.domain;

public class User extends DomainObject {

    //No primitives allowed
    private String firstName;
    private String lastName;
    private String email = null;
    private String cleartextPassword;
    private Boolean loggedIn = false;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCleartextPassword() {
        return cleartextPassword;
    }
    public void setCleartextPassword(String cleartextPassword) {
        this.cleartextPassword = cleartextPassword;
    }
    public Boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
