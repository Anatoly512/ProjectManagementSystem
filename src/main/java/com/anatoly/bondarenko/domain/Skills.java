package com.anatoly.bondarenko.domain;

import lombok.Data;

@Data
public class Skills {

    private Long id;
    private String language;
    private SkillLevel skillLevel;

    public Skills(Long id, String language, SkillLevel skillLevel) {
        this.id = id;
        this.language = language;
        this.skillLevel = skillLevel;
    }

    public Skills() {     //  Этот конструктор нужен для корректной работы класса DevelopersDAO,
                          //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }


// getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public String getLanguage() {
        return this.language;
    }

    public SkillLevel getSkillLevel() {
        return this.skillLevel;
    }

    public Long getId() {
        return this.id;
    }


//  setters

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
