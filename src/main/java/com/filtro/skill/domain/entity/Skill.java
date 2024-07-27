package com.filtro.skill.domain.entity;

public class Skill {
    // attributes
    private int id;
    private String name;
    
    // full constructor
    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // empty constructor
    public Skill() {
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
