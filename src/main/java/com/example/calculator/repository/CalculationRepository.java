package com.example.calculator.repository;

import com.example.calculator.entity.Calculation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CalculationRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Calculation calculation) {
        sessionFactory.getCurrentSession().save(calculation);
    }

    @Transactional(readOnly = true)
    public List<Calculation> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Calculation", Calculation.class)
                .getResultList();
    }
}
