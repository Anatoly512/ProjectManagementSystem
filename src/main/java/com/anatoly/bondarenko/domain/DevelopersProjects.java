package com.anatoly.bondarenko.domain;

import lombok.Data;

@Data
public class DevelopersProjects {

    private String name;
    private Integer amountOfDevelopers;

    public DevelopersProjects(String name, Integer amountOfDevelopers) {
        this.name = name;
        this.amountOfDevelopers = amountOfDevelopers;
    }

    DevelopersProjects() {
    }

}
