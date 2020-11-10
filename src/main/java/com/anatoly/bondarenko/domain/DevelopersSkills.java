package com.anatoly.bondarenko.domain;

import lombok.Data;

@Data
public class DevelopersSkills {

    private Long id;
    private Integer developersId;
    private Integer skillsId;

    public DevelopersSkills(Long id, Integer developersId, Integer skillsId) {
        this.id = id;
        this.developersId = developersId;
        this.skillsId = skillsId;
    }

    public DevelopersSkills() {     //  Этот конструктор нужен для корректной работы класса DevelopersSkills,
                                    //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }


    // getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public Integer getDevelopersId() {
        return this.developersId;
    }

    public Integer getSkillsId() {
        return this.skillsId;
    }

    public Long getId() {
        return this.id;
    }


//  setters

    public void setDevelopersId(Integer developersId) {
        this.developersId = developersId;
    }

    public void setSkillsId(Integer skillsId) {
        this.skillsId = skillsId;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
