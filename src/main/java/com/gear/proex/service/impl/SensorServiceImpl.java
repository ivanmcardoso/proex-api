package com.gear.proex.service.impl;

import com.gear.proex.model.Sensor;
import com.gear.proex.repository.SensorRepository;
import com.gear.proex.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public List<Sensor> getAll() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public void delete(Long id) {
        sensorRepository.deleteById(id);
    }
}
