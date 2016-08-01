package com.endava.training.service;

import com.endava.training.model.Upload;

import java.util.List;

/**
 * Created by iciuta on 8/1/2016.
 */
public interface UploadService {
    List<Upload> getAllUploads();
    Upload registerUpload(Upload upload);
}
