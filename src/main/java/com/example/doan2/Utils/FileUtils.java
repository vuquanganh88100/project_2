package com.example.doan2.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static final String FOLDER_MEDIA="D:\\DOAN2\\imageW\\";

    public static String saveFileFromMultiPartFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile==null) return null;
        String nameFile=System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename();
        // neu cùng tên file thì sẽ tự động xóa đi 1 file ,vì thế cần thêm currentime
        File file=new File(FOLDER_MEDIA+nameFile);
        if(!file.exists())file.createNewFile();
        multipartFile.transferTo(file);

        return  nameFile;
    }
}
