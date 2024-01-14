package com.liuhf.service.impl;

import com.liuhf.model.UserDO;
import com.liuhf.mapper.UserMapper;
import com.liuhf.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuhf
 * @since 2024-01-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}
