package bstorm.akim.correctionExoEntity.repository;

import bstorm.akim.correctionExoEntity.entites.Employe;
import bstorm.akim.correctionExoEntity.entites.Supermarche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupermarcheRepository extends JpaRepository<Supermarche, Integer> {

    // select s from Supermarche s where s.directeur.id = ?1.id
    Optional<Supermarche> findByDirecteur(Employe directeur);

}
