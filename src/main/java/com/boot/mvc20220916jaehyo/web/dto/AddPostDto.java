package com.boot.mvc20220916jaehyo.web.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
public class AddPostDto {
    private String title;
    private String writer;
    private String content;
    private MultipartFile file;
    private List<MultipartFile> files;

}
