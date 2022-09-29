package com.boot.mvc20220916jaehyo.web.controller.api;

/*
    CM(Commit Message)
    CMResponse
    커밋 메세지를 포함한 응답
 */

import com.boot.mvc20220916jaehyo.web.dto.CMRespDto;
import com.boot.mvc20220916jaehyo.web.dto.StudentRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CMResponseController {

    @GetMapping("/api/v1/cm/data1")
    public CMRespDto<?> getData() {

        return new CMRespDto<String>(1, "데이터 응답 성공", "테스트 데이터");
    }

    @GetMapping("/api/v1/cm/data2")
    public CMRespDto<?> getData2() {
        List<StudentRespDto> dtoList = new ArrayList<StudentRespDto>();
        dtoList.add(StudentRespDto.builder().studentCode(1).build());
        dtoList.add(StudentRespDto.builder().studentCode(2).build());
        dtoList.add(StudentRespDto.builder().studentCode(3).build());
        dtoList.add(StudentRespDto.builder().studentCode(4).build());
        dtoList.add(StudentRespDto.builder().studentCode(5).build());

        return new CMRespDto<>(-1, "학생 정보 리스트 데이터입니다.", dtoList);
    }
}
