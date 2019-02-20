package com.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * swagger测试类
 */
@Controller
@RequestMapping("/say")
@Api(value = "SayController| 一个用来测试swagger注解的控制器")
public class SayController {

    @RequestMapping(value = "/getUserName",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户编号返回姓名",notes = "test: 仅1和2有正确返回")
    @ApiImplicitParam(paramType = "query",name = "userNumber",value = "用户编号",required = true,dataType = "Integer")
    public String getUserName(Integer userNumber) {
        if(userNumber == 1) {
            return "huang";
        }else if(userNumber ==2) {
            return "rui";
        }else {
            return "nobody";
        }
    }

    @RequestMapping(value = "/updatePassword",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "修改用户密码",notes = "根据用户id修改密码")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "Integer"),
        @ApiImplicitParam(paramType = "query",name = "password",value = "旧密码",required = true,dataType = "String"),
        @ApiImplicitParam(paramType = "query",name = "newPassword",value = "新密码",required = true,dataType = "String")
    })
    public String updatePassword(Integer userId,String password,String newPassword) {
        if(userId <= 0 || userId >2) {
            return "nobody";
        }
        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)) {
            return "no password";
        }
        if(password.equals(newPassword)) {
            return "same password";
        }
        return "success";
    }
}
