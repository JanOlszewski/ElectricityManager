package com.api.electricitymanager.base.rowmapper;

import com.api.electricitymanager.base.entity.Project;
import com.api.electricitymanager.base.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectRowMapper implements RowMapper<List<Project>> {
    private ProjectService service;

    @Autowired
    public ProjectRowMapper(ProjectService service) {
        this.service = service;
    }

    @Override
    public List<Project> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<Project> resultList = new ArrayList<>();

        if(!resultSet.isFirst()) {
            return resultList;
        }

        do {
            resultList.add(service.findById(resultSet.getInt("id")));
        } while (resultSet.next());

        return resultList;
    }
}
