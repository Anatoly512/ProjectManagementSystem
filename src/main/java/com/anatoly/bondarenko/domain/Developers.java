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
    private Integer age;
    private Integer salary;

    public Developers(String name, Gender gender, Integer age, Integer salary) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }


}
