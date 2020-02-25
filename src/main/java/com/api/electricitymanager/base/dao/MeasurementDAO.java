package com.api.electricitymanager.base.dao;

import com.api.electricitymanager.base.entity.Measurement;
import com.api.electricitymanager.base.entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MeasurementDAO {

    private EntityManager entityManager;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MeasurementDAO(EntityManager entityManager, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.entityManager = entityManager;
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Measurement> findAll() {
        Query<Measurement> query = getSession().createQuery("from Measurement", Measurement.class);
        return query.getResultList();
    }

    public List<Measurement> findById(List<Integer> ids) {
        List<Measurement> resultList = new ArrayList<>();
        Session session = getSession();
        ids.forEach(id -> resultList.add(session.get(Measurement.class, id)));
        return resultList;
    }

    public Measurement findById(int id) {
        return getSession().get(Measurement.class, id);
    }

    public void save(Measurement measurement) {
        getSession().saveOrUpdate(measurement);
    }

    public void deleteById(int id) {
        Query<Measurement> query = getSession().createQuery("delete from Measurement where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
