package com.example.Diacare.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Caretaker {
    private final UUID id;
    private final String name;
    private final String Relation;
    private final String phoneNumber;
    private final String email;
    private final String address;

    public Caretaker(@JsonProperty("id") UUID id,@JsonProperty("name") String name,@JsonProperty("relation") String relation, @JsonProperty("phoneNumber")String phoneNumber, @JsonProperty("email")String email, @JsonProperty("address")String address) {
        this.id = id;
        this.name = name;
        Relation = relation;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRelation() {
        return Relation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
