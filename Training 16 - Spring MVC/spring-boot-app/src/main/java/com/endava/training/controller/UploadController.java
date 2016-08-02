package com.endava.training.controller;

import com.endava.training.dto.UploadDTO;
import com.endava.training.model.Upload;
import com.endava.training.service.UploadService;
import com.endava.training.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iciuta on 8/1/2016.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    private final String ROOT = "D:\\Trainings\\Training 16 - Spring MVC\\spring-boot-app\\uploads";

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ViewService viewService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UploadDTO> getAllUploads() {
        List<Upload> uploads = uploadService.getAllUploads();
        List<UploadDTO> uploadDTOs = new ArrayList<>();

        for(Upload upload : uploads) {
            uploadDTOs.add(viewService.convertUpload(upload));
        }

        return uploadDTOs;
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public UploadDTO upload(@RequestParam(name = "file") MultipartFile file) {
        UploadDTO uploadDTO = new UploadDTO();

        if(!file.isEmpty()) {
            try {
                String filename =  file.getOriginalFilename();
                String path = ROOT + "/" + filename;

                Files.copy(file.getInputStream(), Paths.get(path));

                Upload upload = new Upload();
                upload.setFilename(filename);
                upload.setPath(path);

                uploadDTO = viewService.convertUpload(uploadService.registerUpload(upload));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return uploadDTO;
    }
}
