
package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private String firstName="test";
    private String lastName="test";


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL )
    List<Blog> writtenBlogs = new ArrayList<>();

    public User() {
    }

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public List<Blog> getWrittenBlogs() {
        return writtenBlogs;
    }

    public void setWrittenBlogs(List<Blog> writtenBlogs) {
        this.writtenBlogs = writtenBlogs;
    }
}