package com.example.estate.controller;

import com.example.estate.common.MessageConstant;
import com.example.estate.common.PageResult;
import com.example.estate.common.Result;
import com.example.estate.common.StatusCode;
import com.example.estate.entity.Building;
import com.example.estate.service.BuildingService;
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
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        Page<Building> page = buildingService.search(searchMap);
        return new PageResult(true, 2000, "查询宠物列表成功", page.getResult(), page.getTotal());
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = buildingService.del(ids);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Building building) {
        Boolean add = buildingService.add(building);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_ADD_SUCCESS);
    }

    @RequestMapping("/find")
    public Result find() {
        List<Building> all = buildingService.findAll();
        return new Result(false, 200, "请求成功", all);
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        Building building = buildingService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS, building);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Building building) {
        Boolean update = buildingService.update(building);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }


}
