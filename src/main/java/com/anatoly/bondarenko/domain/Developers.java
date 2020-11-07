package com.anatoly.bondarenko.domain;

import lombok.Data;

@Data
public class Developers {

    private Long id;
    private String name;
    private Gender gender;
    private int age;

    public Developers(Long id, String name, Gender gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
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

    public int getAge() {
        return this.age;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
