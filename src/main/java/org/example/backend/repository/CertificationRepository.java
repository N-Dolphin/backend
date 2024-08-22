package org.example.backend.repository;


import jakarta.transaction.Transactional;
import org.example.backend.model.entity.CertificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<CertificationEntity, Long> {

    CertificationEntity findByEmail(String email);
    CertificationEntity findById(String id);

    //@Transactional
   // void deleteByUsername(String username);
}
