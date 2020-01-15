package com.gear.proex.service;

import com.gear.proex.model.Sensor;

import java.util.List;

public interface SensorService {

    List<Sensor> getAll();

    Sensor save(Sensor sensor);

    void delete(Long id);
}
