package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.DAO.CustomersDAO;
import com.anatoly.bondarenko.domain.Customers;

import java.util.List;


public class CustomersService {

    private final CustomersDAO customersDAO;


    public CustomersService(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }


    public List<Customers> getAllCustomers() {

        return customersDAO.getAllEntities();
    }


    public void deleteCustomer(Long id) {

        customersDAO.deleteEntity(id);
    }


    public void addNewCustomer(Customers customer) {

        customersDAO.addNewEntity(customer);
    }


    public void updateCustomer(Long id, Customers customer) {

        customersDAO.updateEntity(id, customer);
    }


}
