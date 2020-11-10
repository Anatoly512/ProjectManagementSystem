package com.anatoly.bondarenko.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Developers {

    private Long id;
    private String name;
    private Gender gender;
    private Integer age;
    private BigDecimal salary;

    public Developers(Long id, String name, Gender gender, Integer age, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

   public Developers() {     //  Этот конструктор нужен для корректной работы класса DevelopersDAO,
                             //  пустые поля потом (после создания объекта) заполняются через сеттеры
   }


// getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public String getName() {
       return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Integer getAge() {
        return this.age;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public Long getId() {
        return this.id;
    }


//  setters

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
