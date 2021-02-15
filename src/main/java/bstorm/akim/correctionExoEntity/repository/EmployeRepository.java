package bstorm.akim.correctionExoEntity.repository;

import bstorm.akim.correctionExoEntity.entites.Employe;
import bstorm.akim.correctionExoEntity.entites.Supermarche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    Optional<Employe> findByEmailEmploye(String email);
}
