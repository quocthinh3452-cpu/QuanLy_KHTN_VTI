package org.example.crmkhtn.repository;

import org.example.crmkhtn.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
    //springboot tự động tạo thêm,xóa, sửa ngầm
    Lead findByPhone(String phone);
}
