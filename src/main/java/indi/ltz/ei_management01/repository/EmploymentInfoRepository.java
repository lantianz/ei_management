package indi.ltz.ei_management01.repository;

import indi.ltz.ei_management01.domain.entity.EmploymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentInfoRepository extends JpaRepository<EmploymentInfo, String> {
}
