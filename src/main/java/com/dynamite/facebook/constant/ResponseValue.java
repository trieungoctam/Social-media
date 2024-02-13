package com.dynamite.facebook.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseValue {

    // 200x OK
    SUCCESS(HttpStatus.OK, "Thanh cong"),
    // 400x Bad request
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request"),
    // 401 Unauthorized
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized"),
    // 403 Forbidden
    FORBIDDEN(HttpStatus.FORBIDDEN, "Khong co quyen truy cap"),
    // 404 Not found
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not found"),
    // 409 Conflict
    CONFLICT(HttpStatus.CONFLICT, "Da ton tai"),
    // 500 Internal server error
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    // 503 Service unavailable
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "Service unavailable"),

    // Upload file error
    UPLOAD_FILE_ERROR(HttpStatus.BAD_REQUEST, "Upload file error");

    private HttpStatus status;
    private String message;
    ResponseValue(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

    ResponseValue(HttpStatus status) {
        this(status, status.getReasonPhrase());
    }

}
