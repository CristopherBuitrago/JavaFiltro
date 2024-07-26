package com.filtro.person.domain.enitty;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private int idCity;
    private String address;
    private int age;
    private String email;
    private int idGender;
    // extra
    private String cityName;
    private String genderName;
    private String skill;

    // empty constructor
    public Person() {

    }
    
    // full constructor
    public Person(int id, String name, String lastName, int idCity, String address, int age, String email,
            int idGender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.idCity = idCity;
        this.address = address;
        this.age = age;
        this.email = email;
        this.idGender = idGender;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getSkill () {
        return skill;
    } 

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
