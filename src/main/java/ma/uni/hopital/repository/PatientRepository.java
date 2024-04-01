package ma.uni.hopital.repository;

import ma.uni.hopital.HopitalApplication;
import ma.uni.hopital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContains(String Keyword, Pageable pageable);
    @Query("select p from Patient p where p.nom like :x")
    Page<Patient> chercher(@Param("x") String Keyword, Pageable pageable);
}

