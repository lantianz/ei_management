package indi.ltz.ei_management01.service;

import indi.ltz.ei_management01.domain.entity.Graduate;
import indi.ltz.ei_management01.repository.GraduateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraduateServiceImpl implements GraduateService {

    @Autowired
    private GraduateRepository graduateRepository;

    @Override
    public List<Graduate> getAllGraduates() {
        return graduateRepository.findAll();
    }

    @Override
    public Graduate getGraduateById(String studentId) {
        return graduateRepository.findById(studentId).orElse(null);
    }

    @Override
    public Graduate addGraduate(Graduate graduate) {
        return graduateRepository.save(graduate);
    }

    @Override
    public Graduate updateGraduate(Graduate graduate) {
        return graduateRepository.save(graduate);
    }

    @Override
    public void deleteGraduate(String studentId) {
        graduateRepository.deleteById(studentId);
    }
}

