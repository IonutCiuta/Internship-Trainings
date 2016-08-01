package com.endava.training.service.impl;

import com.endava.training.dto.EmployeeDTO;
import com.endava.training.dto.UploadDTO;
import com.endava.training.model.Employee;
import com.endava.training.model.Upload;
import com.endava.training.service.ViewService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by iciuta on 8/1/2016.
 */
@Service
public class ViewServiceImpl implements ViewService {
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public EmployeeDTO convertEmployee(Employee employee) {
        return dozerBeanMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public Employee convertEmployeeDTO(EmployeeDTO employeeDTO) {
        return dozerBeanMapper.map(employeeDTO, Employee.class);
    }

    @Override
    public UploadDTO convertUpload(Upload upload) {
        return dozerBeanMapper.map(upload, UploadDTO.class);
    }

    @Override
    public Upload convertUploadDTO(UploadDTO uploadDTO) {
        return dozerBeanMapper.map(uploadDTO, Upload.class);
    }
}
