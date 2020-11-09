package com.anatoly.bondarenko.domain;

import lombok.Data;

@Data
public class Companies {

    private Long id;
    private String companyName;

    public Companies(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public Companies() {     //  Этот конструктор нужен для корректной работы класса CompaniesDAO,
                             //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }


// getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public String getCompanyName() {
        return this.companyName;
    }

    public Long getId() {
        return this.id;
    }


//  setters

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setId(Long id) {
        this.id = id;
    }


}


