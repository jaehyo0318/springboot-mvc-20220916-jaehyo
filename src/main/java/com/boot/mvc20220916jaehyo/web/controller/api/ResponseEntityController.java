package com.boot.mvc20220916jaehyo.web.controller.api;

import com.boot.mvc20220916jaehyo.web.dto.CMRespDto;
import com.boot.mvc20220916jaehyo.web.dto.StudentRespDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ResponseEntityController {

    @GetMapping("/api/v1/entity/data1")
    public ResponseEntity<?> getData() {

        return new ResponseEntity<String>("responseEntity 응답",HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data2")
    public ResponseEntity<?> getData2() {

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());

        return new ResponseEntity<String>("test", headers, HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data3")
    public ResponseEntity<?> getData3() {

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());

        return new ResponseEntity<>(
                new CMRespDto<>(1, "전송 성공", "테스트 데이터"),
                headers,
                HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data4")
    public ResponseEntity<?> getData4() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token1", "aaaa1111");

        return ResponseEntity.ok()
                .headers(headers)
                .body(new CMRespDto<>(1, "메세지", "test"));
    }

    @GetMapping("api/v1/test/students")
    public ResponseEntity<?> getStudents() {
        StudentRespDto s1 = StudentRespDto.builder()
                .studentCode(20220001)
                .studentName("서재효")
                .studentYear(2)
                .studentAddress("부산 동래구")
                .studentPhone("010-8803-1111")
                .build();
        StudentRespDto s2 = StudentRespDto.builder()
                .studentCode(20220002)
                .studentName("서재희")
                .studentYear(4)
                .studentAddress("부산 금정구")
                .studentPhone("010-8803-1111")
                .build();

        List<StudentRespDto> studentList = new ArrayList<StudentRespDto>();

        studentList.add(s1);
        studentList.add(s2);

        StringBuilder codeList = new StringBuilder();

        for(StudentRespDto studentRespDto : studentList) {
            codeList.append(studentRespDto.getStudentCode());
            codeList.append(", ");
        }
        codeList.delete(codeList.length() - 2, codeList.length());

        HttpHeaders headers = new HttpHeaders();
        headers.add("student_code_list", codeList.toString());


        return new ResponseEntity<>(new CMRespDto<>(-1, "Http 메소드를 확인해 주세요", studentList),
                headers,
                HttpStatus.METHOD_NOT_ALLOWED);
    }
}
