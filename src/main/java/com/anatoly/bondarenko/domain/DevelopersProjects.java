package com.anatoly.bondarenko.domain;

import lombok.Data;

import java.util.Date;

@Data
public class DevelopersProjects {

    private String name;
    private Integer amountOfDevelopers;
    private Date date;

    public DevelopersProjects(String name, Integer amountOfDevelopers) {
        this.name = name;
        this.amountOfDevelopers = amountOfDevelopers;
    }

    public DevelopersProjects(String name, Integer amountOfDevelopers, Date date) {
        this.name = name;
        this.amountOfDevelopers = amountOfDevelopers;
        this.date = date;
    }

    DevelopersProjects() {
    }


    // getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public String getName() {
        return this.name;
    }

    public Integer getAmountOfDevelopers() {
        return this.amountOfDevelopers;
    }

    public Date getDate() {
        return this.date;
    }


//  setters

    public void setName(String name) {
        this.name = name;
    }

    public void setamountOfDevelopers(Integer amountOfDevelopers) {
        this.amountOfDevelopers = amountOfDevelopers;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
