package com.yuki.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
public class ServletUtils {

    private ServletUtils() {
    }

    public static void renderJson(HttpServletResponse response, Object object) {
        try {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            String str = objectMapper.writeValueAsString(object);
            response.getWriter().print(str);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
