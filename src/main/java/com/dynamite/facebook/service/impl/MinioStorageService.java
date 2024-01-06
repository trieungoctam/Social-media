package com.dynamite.facebook.service.impl;

import com.dynamite.facebook.model.dto.file.ResponseUploadFile;
import com.dynamite.facebook.service.IMinioStorageService;
import com.dynamite.facebook.util.MinioHelper;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class MinioStorageService implements IMinioStorageService {

    @Autowired
    private MinioHelper minioHelper;

    @Override
    public ResponseUploadFile uploadFile(MultipartFile file) {
        try {
            return minioHelper.uploadFile(file);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public void downloadFile(String fileName, String filePath) {

    }

    @Override
    public void deleteFile(String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioHelper.removeFile(fileName);
    }

    @Override
    public void listObjects() {

    }
}
