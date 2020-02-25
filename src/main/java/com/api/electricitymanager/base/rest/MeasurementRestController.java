package com.api.electricitymanager.base.rest;

import com.api.electricitymanager.base.entity.Measurement;
import com.api.electricitymanager.base.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementRestController {

    private MeasurementService measurementService;

    @Autowired
    public MeasurementRestController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("")
    public List<Measurement> findAll() {
        return measurementService.findAll();
    }

    @GetMapping("/{id}")
    public Measurement findById(@PathVariable int id) {
        return measurementService.findById(id);
    }

    @GetMapping("/list/{ids}")
    public List<Measurement> findById(@PathVariable List<Integer> ids) {
        return measurementService.findById(ids);
    }

    @PostMapping("")
    public Measurement addMeasurement(@RequestBody Measurement measurement) {
        measurementService.save(measurement);
        return measurement;
    }

    @PutMapping("")
    public Measurement updateMeasurement(@RequestBody Measurement measurement) {
        measurementService.save(measurement);
        return measurement;
    }

    @DeleteMapping("/{id}")
    public Measurement deleteMeasurement(@PathVariable int id) {
        Measurement oldMeasurement = measurementService.findById(id);
        measurementService.deleteById(id);
        return oldMeasurement;
    }
}
