package indi.ltz.ei_management01.domain.entityVo;

import indi.ltz.ei_management01.domain.entity.Graduate;

public class GraduateVo {
    private final Long studentId;
    private final String name;
    private final String gender;
    private final String department;
    private final String major;
    private final String grade;
    private final String username;
    public GraduateVo(Graduate graduate){
        this.studentId = graduate.getStudentId();
        this.name = graduate.getName();
        this.gender = graduate.getGender();
        this.department = graduate.getDepartment();
        this.major = graduate.getMajor();
        this.grade = graduate.getGrade();
        this.username = graduate.getUsername();
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public String getMajor() {
        return major;
    }

    public String getGrade() {
        return grade;
    }

    public String getUsername() {
        return username;
    }
}
