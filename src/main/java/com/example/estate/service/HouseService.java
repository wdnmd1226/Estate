package com.example.estate.service;

import com.example.estate.entity.House;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface HouseService {
    public List<House> findAll();

    public Page<House> search(Map searchMap);

    public Boolean add(House house);

    public House findById(Integer id);

    Boolean update(House pet);

    Boolean del(List<Integer> ids);
}
