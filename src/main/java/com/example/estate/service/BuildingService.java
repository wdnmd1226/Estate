package com.example.estate.service;

import com.example.estate.entity.Building;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    public List<Building> findAll();

    public Page<Building> search(Map searchMap);

    public Boolean add(Building building);

    public Building findById(Integer id);

    Boolean update(Building building);

    Boolean del(List<Integer> ids);
}
