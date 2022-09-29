package com.boot.mvc20220916jaehyo.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CMRespDto<T> {
    private int code;   // 1: 성공, -1: 실패
    private String msg; // commit메세지
    private T data;     // 응답데이터
}
