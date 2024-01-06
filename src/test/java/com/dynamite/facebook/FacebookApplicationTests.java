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
	public static final MinioClient MINIO_CLIENT =
			MinioClient.builder()
					.endpoint("http://14.225.204.125:9000")
					.credentials("proptit", "123456a@")
					.build();

	public static final String BUCKET_NAME = "proptit";
	public static int upload() {

		try {
			ObjectWriteResponse resp = MINIO_CLIENT.uploadObject(
					UploadObjectArgs.builder()
							.bucket(BUCKET_NAME)
							.object("ducanh/368033389_731348278853342_305416335472133973_n.jpg") //  object name trên minio
							.filename("/home/lap60733-local/Desktop/368033389_731348278853342_305416335472133973_n.jpg") // File cần upload
							.build());
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}
	// Tạo ra url để dẫn đến ảnh với expired time
	public static String genUrl(String minioPath) {

		try {
			return MINIO_CLIENT.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
					.method(Method.GET)
					.bucket(BUCKET_NAME)
					.object(minioPath)
					.expiry(86400)
					.build());
		} catch (Exception e) {
			return null;
		}
	}


	@Test
	void contextLoads() {
	}

	@Test
	void testMinIO() {
		//upload();
		System.out.println(genUrl("ducanh/368033389_731348278853342_305416335472133973_n.jpg"));
	}

}
