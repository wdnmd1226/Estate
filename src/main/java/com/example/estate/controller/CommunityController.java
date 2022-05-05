package com.example.estate.controller;

import com.example.estate.common.MessageConstant;
import com.example.estate.common.PageResult;
import com.example.estate.common.Result;
import com.example.estate.common.StatusCode;
import com.example.estate.entity.Community;
import com.example.estate.service.CommunityService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author dyq
 * @Desc: 小区管理控制层
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @RequestMapping("/find")
    public Result find() {
        List<Community> all = communityService.findAll();
        return new Result(false, 200, "请求成功", all);
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        Page<Community> page = communityService.search(searchMap);
        return new PageResult(true, 2000, "查询小区列表成功", page.getResult(), page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Community community) {
        Boolean add = communityService.add(community);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_ADD_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        Community community = communityService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS, community);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Community community) {
        Boolean update = communityService.update(community);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status, @PathVariable("id") Integer id){
        Boolean flag = communityService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_STATUS_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = communityService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }
}

