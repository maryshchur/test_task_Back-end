package org.example.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    boolean deleteFile(String fileName);

    String saveFile(MultipartFile multipartFile);
}
