package com.yuki.admin.auth.service;

import com.yuki.common.core.reader.BaseReader;
import com.yuki.admin.auth.controller.SystemUserInfoVO;
import com.yuki.admin.auth.dao.SystemUser;
import org.springframework.stereotype.Component;

@Component
public class UserInfoReader extends BaseReader<SystemUser, SystemUserInfoVO> {
}
