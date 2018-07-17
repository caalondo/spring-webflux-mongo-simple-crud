package com.projects.webfluxcrud.models;


import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
public class ClientModel {

    @Id
    private String id;
    private String name;
    private int age;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " - Name: " + this.name + " - Email: " + this.email;
    }

    public JSONObject asJsonObject () {
        JSONObject clientObj = new JSONObject();
        clientObj.put("id", this.id);
        clientObj.put("name", this.name);
        clientObj.put("age", this.age);
        clientObj.put("email", this.email);
        return clientObj;
    }
}
