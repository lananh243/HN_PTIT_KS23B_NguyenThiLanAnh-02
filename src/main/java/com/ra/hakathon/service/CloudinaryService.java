package com.ra.hakathon.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;
@Service
public class CloudinaryService {

    Map<String, String> config = ObjectUtils.asMap(
            "cloud_name", "dcmtkk2mw",
            "api_key", "663139661167425",
            "api_secret", "zx0Q2GMceFfdaqNkjgllJdqtTC8"
    );
    private final Cloudinary cloudinary = new Cloudinary(config);

    public String uploadImage(MultipartFile file) {
        try {
            Map<String, Object> rs = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return rs.get("imageManager").toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
