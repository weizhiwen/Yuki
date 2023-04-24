package com.yuki.admin.position.service;

import com.yuki.admin.position.dao.Position;
import com.yuki.admin.position.web.PositionVO;
import com.yuki.common.core.reader.BaseReader;
import org.springframework.stereotype.Service;

@Service
public class PositionReader extends BaseReader<Position, PositionVO> {
}
