package com.liuhf.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuhf.UserApplication;
import com.liuhf.model.AddressDO;
import com.liuhf.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lhf
 * @date: 2024/1/14 19:31
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
@Slf4j
public class AddressTest {
    
    @Autowired
    private AddressService addressService;
    
    @Test
    public void testAddressDetail(){
        Long id = 1L;
        AddressDO address = addressService.getOne(new QueryWrapper<AddressDO>().eq("id", id));
        log.info(address.toString());
        Assert.assertNotNull(address);
    }
}
