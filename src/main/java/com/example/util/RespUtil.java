package com.example.util;

import com.example.enums.HttpStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息封装
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespUtil {
    private Integer code;
    private String message;
    private Object data;

    public RespUtil(HttpStatusEnum statusEnum, Object data) {
        super();
        this.code = statusEnum.getCode();
        this.message = statusEnum.getMessage();
        this.data = data;
    }
}
