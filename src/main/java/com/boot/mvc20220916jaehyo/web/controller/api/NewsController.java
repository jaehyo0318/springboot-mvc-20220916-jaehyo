package com.boot.mvc20220916jaehyo.web.controller.api;

import com.boot.mvc20220916jaehyo.web.dto.AddNewsReqDto;
import com.boot.mvc20220916jaehyo.web.dto.AddPostDto;
import com.boot.mvc20220916jaehyo.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class NewsController {

    @PostMapping("/api/v1/news")
    public ResponseEntity<?> addNews(AddNewsReqDto addNewsReqDto) {
        log.info("{}", addNewsReqDto);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", addNewsReqDto.getTitle());
        map.put("broadcastingName", addNewsReqDto.getBroadcastingName());
        map.put("content", addNewsReqDto.getContent());

        List<String> fileNameList = new ArrayList<String>();
        addNewsReqDto.getFiles().forEach((file) -> {
            fileNameList.add(file.getOriginalFilename());
        });
        map.put("fileNames", fileNameList);

        return  ResponseEntity.ok(new CMRespDto<>(1,"뉴스 등록 완료", map));
    }
}
