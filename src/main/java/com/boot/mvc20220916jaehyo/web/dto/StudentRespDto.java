package com.boot.mvc20220916jaehyo.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentRespDto {
    private int studentCode;
    private String studentName;
    private int studentYear;
    private String studentAddress;
    private String studentPhone;

}
