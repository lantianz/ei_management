package indi.ltz.ei_management01.service;

import indi.ltz.ei_management01.domain.entity.EmploymentInfo;

import java.util.List;

public interface EmploymentInfoService {
    List<EmploymentInfo> getAllEmploymentInfos();
    EmploymentInfo getEmploymentInfoById(String studentId);
    EmploymentInfo addEmploymentInfo(EmploymentInfo employmentInfo);
    EmploymentInfo updateEmploymentInfo(EmploymentInfo employmentInfo);
    void deleteEmploymentInfo(String studentId);
}
