package com.dynamite.facebook;

import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.repository.UserRepository;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.UploadObjectArgs;
import io.minio.http.Method;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FacebookApplicationTests {

	@Test
	void contextLoads() {
	}

}
