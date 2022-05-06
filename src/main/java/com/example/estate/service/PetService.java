package com.example.estate.service;

import com.example.estate.entity.Pet;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @author dyq
 */
public interface PetService {

    public List<Pet> findAll();

    public Page<Pet> search(Map searchMap);

    public Boolean add(Pet pet);

    public Pet findById(Integer id);

    Boolean update(Pet pet);

    Boolean del(List<Integer> ids);
}
