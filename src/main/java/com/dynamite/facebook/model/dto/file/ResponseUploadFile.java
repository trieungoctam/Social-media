package com.dynamite.facebook.model.dto.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ResponseUploadFile {
    private String fileName;
    private String urlFile;
}
