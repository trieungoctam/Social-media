package com.dynamite.facebook.service;

import com.dynamite.facebook.model.dto.file.ResponseUploadFile;
import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface IMinioStorageService {
    public ResponseUploadFile uploadFile(MultipartFile file);
    public void downloadFile(String fileName, String filePath);
    public void deleteFile(String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;
    public void listObjects();
}
