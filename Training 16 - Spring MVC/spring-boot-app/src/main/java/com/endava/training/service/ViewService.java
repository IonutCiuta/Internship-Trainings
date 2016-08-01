package com.endava.training.service;

import com.endava.training.dto.EmployeeDTO;
import com.endava.training.dto.UploadDTO;
import com.endava.training.model.Employee;
import com.endava.training.model.Upload;

/**
 * Created by iciuta on 8/1/2016.
 */
public interface ViewService {
    /* Employee conversions */
    EmployeeDTO convertEmployee(Employee employee);
    Employee convertEmployeeDTO(EmployeeDTO employeeDTO);

    /* Upload conversions */
    UploadDTO convertUpload(Upload upload);
    Upload convertUploadDTO(UploadDTO uploadDTO);
}
