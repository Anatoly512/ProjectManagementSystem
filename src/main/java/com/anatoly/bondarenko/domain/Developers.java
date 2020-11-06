package com.anatoly.bondarenko.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developers {

    private Long id;
    private String name;
    private Gender gender;
    private int age;
    private int salary;

    public Developers(String name, Gender gender, int age, int salary) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public Developers() {

    }


// getters

    public String getName() {
       return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public int getSalary() {
        return this.salary;
    }


//  setters

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
