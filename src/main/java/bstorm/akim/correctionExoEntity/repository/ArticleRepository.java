package bstorm.akim.correctionExoEntity.repository;

import bstorm.akim.correctionExoEntity.entites.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, String> {


    List<Article> findByMarqueAndPrixLessThanEqual(String marque, Double prix);

    @Query("select a from Article a where a.marque = :marque and a.prix <= :prix")
    List<Article> customQuery(
            @Param("prix") Double prix,
            @Param("marque") String marque);

    @Modifying
    @Transactional
    @Query(value = "insert into Article (code_barre, nom, marque, prix) values (:c,:n,:m,:p)",
            nativeQuery = true)
    void insert(
            @Param("c") String codeBarre,
            @Param("n") String nom,
            @Param("m") String marque,
            @Param("p") Double prix
    );



}
