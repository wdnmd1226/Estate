package com.example.estate.controller;

import com.example.estate.common.MessageConstant;
import com.example.estate.common.PageResult;
import com.example.estate.common.Result;
import com.example.estate.common.StatusCode;
import com.example.estate.entity.Community;
import com.example.estate.entity.Pet;
import com.example.estate.service.PetService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = petService.del(ids);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Pet pet) {
        Boolean add = petService.add(pet);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_ADD_SUCCESS);
    }

    @RequestMapping("/find")
    public Result find() {
        List<Pet> all = petService.findAll();
        return new Result(false, 200, "请求成功", all);
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        Pet pet = petService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS, pet);
    }


}
