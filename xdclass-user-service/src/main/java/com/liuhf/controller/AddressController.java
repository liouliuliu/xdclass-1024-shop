package com.liuhf.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuhf.model.AddressDO;
import com.liuhf.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 电商-公司收发货地址表 前端控制器
 * </p>
 *
 * @author liuhf
 * @since 2024-01-14
 */
@Api(tags = "收获地址模块")
@RestController
@RequestMapping("/api/address/v1/")
public class AddressController {

    @Resource
    private AddressService addressService;

    @GetMapping("find/{address_id}")
    public Object detail(@ApiParam(value = "地址id", required = true)
                         @PathVariable("address_id") long addressId) {
        return addressService.getOne(new QueryWrapper<AddressDO>().eq("id", addressId));
    }
}

