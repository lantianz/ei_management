package indi.ltz.ei_management01.service;

import indi.ltz.ei_management01.domain.entity.EmploymentInfo;
import indi.ltz.ei_management01.repository.EmploymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentInfoServiceImpl implements EmploymentInfoService {

    @Autowired
    private EmploymentInfoRepository employmentInfoRepository;

    @Override
    public List<EmploymentInfo> getAllEmploymentInfos() {
        return employmentInfoRepository.findAll();
    }

    @Override
    public EmploymentInfo getEmploymentInfoById(String studentId) {
        return employmentInfoRepository.findById(studentId).orElse(null);
    }

    @Override
    public EmploymentInfo addEmploymentInfo(EmploymentInfo employmentInfo) {
        return employmentInfoRepository.save(employmentInfo);
    }

    @Override
    public EmploymentInfo updateEmploymentInfo(EmploymentInfo employmentInfo) {
        return employmentInfoRepository.save(employmentInfo);
    }

    @Override
    public void deleteEmploymentInfo(String studentId) {
        employmentInfoRepository.deleteById(studentId);
    }
}
