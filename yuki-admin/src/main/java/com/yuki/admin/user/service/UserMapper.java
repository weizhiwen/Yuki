package com.yuki.admin.user.service;

import com.yuki.admin.user.dao.User;
import com.yuki.admin.user.web.UserVO;
import com.yuki.common.core.mapper.BusinessMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BusinessMapper<User, CreateUserParam, UpdateUserParam, UserVO> {
}
