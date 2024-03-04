package indi.ltz.ei_management01.repository;

import indi.ltz.ei_management01.domain.entity.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduateRepository extends JpaRepository<Graduate, String> {
}