package com.yuki.admin.user.service;

import com.yuki.common.core.reader.BaseReader;
import com.yuki.admin.user.web.UserBasicInfoVO;
import com.yuki.admin.user.dao.User;
import org.springframework.stereotype.Component;

@Component
public class UserBasicInfoReader extends BaseReader<User, UserBasicInfoVO> {
}
