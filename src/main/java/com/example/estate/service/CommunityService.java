package com.example.estate.service;

import com.example.estate.entity.Community;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @author dyq
 */
public interface CommunityService {

    public List<Community> findAll();

    public Page<Community> search(Map searchMap);

    public Boolean add(Community community);

    public Community findById(Integer id);

    Boolean update(Community community);

    Boolean updateStatus(String status, Integer id);

    Boolean del(List<Integer> ids);
}
