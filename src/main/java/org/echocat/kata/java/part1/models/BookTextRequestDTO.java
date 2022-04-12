package org.echocat.kata.java.part1.models;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BookTextRequestDTO {
    MultipartFile file;
    int chapter;
    int volume;
}
