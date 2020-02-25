package com.api.electricitymanager.base.service;

import com.api.electricitymanager.base.dao.MeasurementDAO;
import com.api.electricitymanager.base.entity.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeasurementService {

    private MeasurementDAO measurementDAO;

    @Autowired
    public MeasurementService(MeasurementDAO measurementDAO) {
        this.measurementDAO = measurementDAO;
    }

    @Transactional
    public Measurement findById(int id) {
        return measurementDAO.findById(id);
    }

    @Transactional
    public List<Measurement> findById(List<Integer> ids) {
        return measurementDAO.findById(ids);
    }

    @Transactional
    public List<Measurement> findAll() {
        return measurementDAO.findAll();
    }

    @Transactional
    public void save(Measurement measurement) {
        measurementDAO.save(measurement);
    }

    @Transactional
    public void deleteById(int id) {
        measurementDAO.deleteById(id);
    }
}
