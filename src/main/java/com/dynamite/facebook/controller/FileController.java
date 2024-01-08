package com.dynamite.facebook.controller;

import com.dynamite.facebook.model.dto.file.RequestUploadFile;
import com.dynamite.facebook.model.dto.file.ResponseUploadFile;
import com.dynamite.facebook.service.IMinioStorageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class FileController {
    private final IMinioStorageService minioStorageService;
    @PostMapping("/upload")
    @Transactional
    public ResponseUploadFile uploadImg(@RequestParam("file") MultipartFile file) {
        return minioStorageService.uploadFile(file);
    }
}
