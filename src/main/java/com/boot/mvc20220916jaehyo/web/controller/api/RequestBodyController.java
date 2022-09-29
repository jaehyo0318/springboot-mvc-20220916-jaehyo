package com.boot.mvc20220916jaehyo.web.controller.api;

import com.boot.mvc20220916jaehyo.web.dto.CMRespDto;
import com.boot.mvc20220916jaehyo.web.dto.AddPostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class RequestBodyController {

    @PostMapping("/api/v1/rp/post")
    public ResponseEntity<?> post(@RequestParam String title,
                                  @RequestParam String writer,
                                  @RequestParam String content) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", title);
        map.put("writer", writer);
        map.put("content", content);

        return ResponseEntity.ok(new CMRespDto<>(1,"새로운 글 추가", map));
    }

    @PostMapping("/api/v1/dto/post")
    public ResponseEntity<?> addPost(AddPostDto addPostDto) {
        log.info("{}", addPostDto);

        return ResponseEntity.ok(new CMRespDto<>(1,"새로운 글 추가", addPostDto));
    }

    @PostMapping("/api/v1/file/post")
    public ResponseEntity<?> addPost2(AddPostDto addPostDto) {

        log.info("{}", addPostDto);
        List<String> fileNames = new ArrayList<String>();

        String fileName1 = addPostDto.getFile().getOriginalFilename();
        fileNames.add(fileName1);

        if(addPostDto.getFiles() != null) {
            String fileName2 = addPostDto.getFiles().get(0).getOriginalFilename();
            String fileName3 = addPostDto.getFiles().get(1).getOriginalFilename();

            fileNames.add(fileName2);
            fileNames.add(fileName3);
        }

        return ResponseEntity.ok(new CMRespDto<>(1,"새로운 글 추가", fileNames));
    }

    @PostMapping("/api/v1/json/post") // @RequestBody가 없으면 json으로 받을 수 없음
    public ResponseEntity<?> addPost3(@RequestBody AddPostDto addPostDto) {
        log.info("{}", addPostDto);

        return ResponseEntity.ok(new CMRespDto<>(1,"새로운 글 추가", addPostDto));
    }

    @DeleteMapping("/api/v1/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable int id) {
        log.info("삭제할 게시글 번호: ({})", id);

        return ResponseEntity.ok(new CMRespDto<>(1, "삭제 성공", id));
    }
}
