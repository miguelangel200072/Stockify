package com.example.stockify.entidades;

public class User {

    private int id;
    private String nom;
    private String pass;

    public User(int id, String nom, String pass) {
        this.id = id;
        this.nom = nom;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPass() {
        return pass;
    }
}
