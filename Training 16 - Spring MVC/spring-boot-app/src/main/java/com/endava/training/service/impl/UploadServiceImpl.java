package com.endava.training.service.impl;

import com.endava.training.dao.UploadRepository;
import com.endava.training.model.Upload;
import com.endava.training.service.UploadService;
import com.endava.training.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by iciuta on 8/1/2016.
 */
@Service
public class UploadServiceImpl implements UploadService{
    @Autowired
    private UploadRepository uploadDAO;

    @Autowired
    private ViewService viewService;

    @Override
    public List<Upload> getAllUploads() {
        return uploadDAO.findAll();
    }

    @Transactional
    @Override
    public Upload registerUpload(Upload upload) {
        return uploadDAO.save(upload);
    }
}
