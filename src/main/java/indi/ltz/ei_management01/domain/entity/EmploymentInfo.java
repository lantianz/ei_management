package indi.ltz.ei_management01.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class EmploymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String companyName;
    private String companyType;
    private String companyLocation;
    private Date contractDate;
    private boolean isStudyingFurther;
    private boolean isEmployedOnTime;
    private boolean isEmployedWithinTwoYears;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public boolean isStudyingFurther() {
        return isStudyingFurther;
    }

    public void setStudyingFurther(boolean studyingFurther) {
        isStudyingFurther = studyingFurther;
    }

    public boolean isEmployedOnTime() {
        return isEmployedOnTime;
    }

    public void setEmployedOnTime(boolean employedOnTime) {
        isEmployedOnTime = employedOnTime;
    }

    public boolean isEmployedWithinTwoYears() {
        return isEmployedWithinTwoYears;
    }

    public void setEmployedWithinTwoYears(boolean employedWithinTwoYears) {
        isEmployedWithinTwoYears = employedWithinTwoYears;
    }

    @Override
    public String toString() {
        return "EmploymentInfo{" +
                "studentId=" + studentId +
                ", companyName='" + companyName + '\'' +
                ", companyType='" + companyType + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", contractDate=" + contractDate +
                ", isStudyingFurther=" + isStudyingFurther +
                ", isEmployedOnTime=" + isEmployedOnTime +
                ", isEmployedWithinTwoYears=" + isEmployedWithinTwoYears +
                '}';
    }
}

