package com.yuki.admin.auth.controller;

import com.yuki.admin.position.controller.PositionVO;
import com.yuki.admin.position.dal.Position;
import com.yuki.common.core.reader.BaseReader;
import org.springframework.stereotype.Service;

@Service
public class PositionReader extends BaseReader<Position, PositionVO> {
}
