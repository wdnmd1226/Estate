package com.example.estate.controller;

import com.example.estate.common.PageResult;
import com.example.estate.entity.Pet;
import com.example.estate.service.PetService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 22973
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        Page<Pet> page = petService.search(searchMap);
        return new PageResult(true, 2000, "查询宠物列表成功", page.getResult(), page.getTotal());
    }


}
