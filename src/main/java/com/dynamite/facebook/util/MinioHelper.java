package com.dynamite.facebook.util;

import com.dynamite.facebook.model.dto.file.ResponseUploadFile;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class MinioHelper {
    @Autowired
    @Qualifier("minioClient")
    private MinioClient minioClient;
    @Value("${spring.minio.bucket}")
    private String bucketName;
    @Value("${spring.minio.url}")
    private String url;
    public ResponseUploadFile uploadFile(MultipartFile file) throws Exception{
        try (InputStream inputStream = file.getInputStream()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            String uploadFileName = UUID.randomUUID().toString() + "_" + sdf.format(new Date()) + "_" +
                    file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            final String urlFile = bucketName + "/" + "ngoctam" + "/" +  new String(uploadFileName.getBytes("UTF-8"), "UTF-8");
            PutObjectArgs putObjectOptions = PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(urlFile)
                    .contentType(file.getContentType())
                    .stream(inputStream, file.getSize(), -1)
                    .build();
            minioClient.putObject(putObjectOptions);
            return ResponseUploadFile.builder()
                    .fileName(uploadFileName)
                    .urlFile(getFileUrl(urlFile))
                    .build();
        }
    }

    public String getFileUrl(String fileName) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
        } catch (Exception e) {
            return null;
        }
    }

    public void removeFile(String fileName) throws ServerException, InsufficientDataException, ErrorResponseException,
            IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .build());
    }
}
