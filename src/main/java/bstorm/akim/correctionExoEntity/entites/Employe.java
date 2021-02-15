package bstorm.akim.correctionExoEntity.entites;

import lombok.*;

import javax.persistence.*;
import java.util.List;

// JPA
@Entity
// Lombok
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100 /*, columnDefinition="varchar(100)"*/)
    private String nom;

    @Column(name = "email", length = 50, unique = true)
    private String emailEmploye;

    @Column(nullable = false)
    private String numTel;

    // EAGER - récupére l'info de base
    // LAZY  - récupère l'info lorsqu'on fait un 'get'
    @OneToOne(mappedBy = "directeur", fetch = FetchType.EAGER)
    private Supermarche dirige;

    @ManyToMany(mappedBy = "employes", fetch = FetchType.EAGER)
    private List<Supermarche> travailleDans;

}
