package org.example.service.impl;

import org.example.exception.CustomException;
import org.example.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Override
    public String saveFile(MultipartFile multipartFile) {
        String fileName = "";
        try {
            fileName = convertMultiPartToFileAndSave(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @Value("${UPLOADED_FOLDER}")
    private   String UPLOADED_FOLDER ;

    private String convertMultiPartToFileAndSave(MultipartFile multipartFile) throws IOException {
        String name = multipartFile.getOriginalFilename();
        FileOutputStream fos = new FileOutputStream(UPLOADED_FOLDER + name);
        fos.write(multipartFile.getBytes());
        fos.close();
        return name;
    }


    @Override
    public boolean deleteFile(String fileName) {
        try {
            Path file = Paths.get(UPLOADED_FOLDER).resolve(fileName);
            return Files.deleteIfExists(file);
        } catch (Exception e) {
            throw new CustomException("Error: " + e.getMessage());
        }
    }

}
