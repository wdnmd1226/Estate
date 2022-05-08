package com.example.estate.controller;

import com.example.estate.common.MessageConstant;
import com.example.estate.common.PageResult;
import com.example.estate.common.Result;
import com.example.estate.common.StatusCode;
import com.example.estate.entity.House;
import com.example.estate.service.HouseService;
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
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        Page<House> page = houseService.search(searchMap);
        return new PageResult(true, 2000, "查询宠物列表成功", page.getResult(), page.getTotal());
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = houseService.del(ids);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody House house) {
        Boolean add = houseService.add(house);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_ADD_SUCCESS);
    }

    @RequestMapping("/find")
    public Result find() {
        List<House> all = houseService.findAll();
        return new Result(false, 200, "请求成功", all);
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        House house = houseService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS, house);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody House house) {
        Boolean update = houseService.update(house);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }


}
