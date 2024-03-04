package indi.ltz.ei_management01.service;

import indi.ltz.ei_management01.domain.entity.Graduate;

import java.util.List;

public interface GraduateService {
    List<Graduate> getAllGraduates();
    Graduate getGraduateById(String studentId);
    Graduate addGraduate(Graduate graduate);
    Graduate updateGraduate(Graduate graduate);
    void deleteGraduate(String studentId);
}
