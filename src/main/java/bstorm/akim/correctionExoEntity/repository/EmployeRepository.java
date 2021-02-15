package bstorm.akim.correctionExoEntity.repository;

import bstorm.akim.correctionExoEntity.entites.Employe;
import bstorm.akim.correctionExoEntity.entites.Supermarche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    // select e from Employe e where email like ?1;
    Optional<Employe> findByEmailEmploye(String email);
    // select e from Employe e JOIN interm. JOIN Supermarche s on ... where e.nom = ?2 AND s.id = ?1.id
    List<Employe> findByTravailleDansAndNom(Supermarche supermarche, String nom);
    // select e from Employe e where e.emailEmploye = ?1 OR e.nom = ?2
    List<Employe> findByEmailEmployeOrNom(String email, String nom);

    List<Employe> findByDirigeNotNull(); // Les employes qui sont directeurs
    List<Employe> findByDirigeNull();    // Les employes qui ne sont pas directeurs

    List<Employe> findByNomNotLike(String nom); // Les employes dont le nom n'est pas celui donné en param
    List<Employe> findByNomNot(String nom); // Les employes dont le nom n'est pas celui donné en param

    List<Employe> findByEmailEmployeIn(Collection<String> emails); // Employe dont l'email correspond à une des adresses de la collection
    List<Employe> findByEmailEmployeNotIn(Collection<String> emails); // L'inverse

    List<Employe> findByEmailEmployeIgnoreCaseNotInAndNom(Collection<String> emails, String nom); // combi

    // JPQL ~= SQL mais avec les noms des entités
    @Query("select e.emailEmploye from Employe e where e.nom = ?1 and e.emailEmploye like %?1")
    List<String> findEmailByNom(String nom);



}
