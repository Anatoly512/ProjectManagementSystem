package com.anatoly.bondarenko.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Projects {

    private Long id;
    private String projectsName;
    private BigDecimal cost;
    private Date date;


    public Projects(Long id, String projectsName, BigDecimal cost, Date date) {
        this.id = id;
        this.projectsName = projectsName;
        this.cost = cost;
        this.date = date;
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

    public Date getDate() {
        return this.date;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
