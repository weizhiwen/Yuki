package com.yuki.admin.user.service;

import com.yuki.admin.user.dao.User;
import com.yuki.admin.user.web.UserVO;
import com.yuki.common.core.reader.BaseReader;
import org.springframework.stereotype.Component;

@Component
public class UserReader extends BaseReader<User, UserVO> {
}
