package com.boot.mvc20220916jaehyo.web.controller.api;

import com.boot.mvc20220916jaehyo.web.dto.ResponseDataDto;
import com.boot.mvc20220916jaehyo.web.dto.StudentRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResponseTestController {

//    @ResponseBody 그냥 데이터를 response
    @GetMapping("/api/v1/data1")
    public Map<String,Object> getData() {
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("이름", "서재효");
        data.put("연락처", "010-8803-2829");

        return data;
    }


    @GetMapping("/api/v1/data2")
    public ResponseDataDto getData2() {

        return ResponseDataDto.builder()
                .value1("그냥 문자열")
                .value2(1000)
                .value3(true)
                .build();
    }


    @GetMapping("/api/v1/data3")
    public Object getData3() {

        return ResponseDataDto.builder()
                .value1("그냥 문자열2")
                .value2(2000)
                .value3(false)
                .build();
    }

    @GetMapping("/api/v1/students")
    public Map<String, List<StudentRespDto>> getStudents() {
        Map<String, List<StudentRespDto>> data = new HashMap<String, List<StudentRespDto>>();
        List<StudentRespDto> list = new ArrayList<StudentRespDto>();
        list.add(StudentRespDto.builder()
                .studentCode(1)
                .studentName("서재효")
                .studentYear(4)
                .studentAddress("부산 동래구")
                .studentPhone("010-8803-2829")
                .build());
        list.add(StudentRespDto.builder()
                .studentCode(2)
                .studentName("서재희")
                .studentYear(3)
                .studentAddress("부산 금정구")
                .studentPhone("010-8803-2828")
                .build());
        data.put("students", list);

        return data;
    }
}
