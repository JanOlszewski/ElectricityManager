package com.api.electricitymanager.base.rowmapper;

import com.api.electricitymanager.base.entity.Measurement;
import com.api.electricitymanager.base.entity.Project;
import com.api.electricitymanager.base.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MeasurementRowMapper implements RowMapper<List<Measurement>> {
    private MeasurementService service;

    @Autowired
    public MeasurementRowMapper(MeasurementService service) {
        this.service = service;
    }

    @Override
    public List<Measurement> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<Measurement> resultList = new ArrayList<>();

        if(!resultSet.isFirst()) {
            return resultList;
        }

        do {
            resultList.add(service.findById(resultSet.getInt("id")));
        } while (resultSet.next());

        return resultList;
    }
}
