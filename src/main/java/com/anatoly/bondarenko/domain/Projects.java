package com.anatoly.bondarenko.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Projects {

    private Long id;
    private String projectsName;
    private BigDecimal cost;


    public Projects(Long id, String projectsName, BigDecimal cost) {
        this.id = id;
        this.projectsName = projectsName;
        this.cost = cost;
    }

    public Projects() {     //  Этот конструктор нужен для корректной работы класса DevelopersDAO,
                            //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }


// getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public String getProjectsName() {
        return this.projectsName;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public Long getId() {
        return this.id;
    }


//  setters

    public void setProjectsName(String projectsName) {
        this.projectsName = projectsName;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
