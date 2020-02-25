package com.api.electricitymanager.base.dao;

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
public class ProjectDAO {

    private EntityManager entityManager;

    @Autowired
    public ProjectDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Project> findAll() {
        Query<Project> query = getSession().createQuery("from Project", Project.class);
        return query.getResultList();
    }

    public Project findById(int id) {
        return getSession().get(Project.class, id);
    }

    public List<Project> findById(List<Integer> ids) {
        Session session = getSession();
        List<Project> resultList = new ArrayList<>();
        ids.forEach(id -> resultList.add(session.get(Project.class, id)));
        return resultList;
    }

    public void save(Project project) {
        getSession().saveOrUpdate(project);
    }

    public void deleteById(int id) {
        Query<Project> query = getSession().createQuery("delete from Project where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
