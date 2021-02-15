package bstorm.akim.correctionExoEntity.entites;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

// JPA
@Entity
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supermarche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(nullable = false)
    private String adresse;

    @Column
    private LocalTime heureOuverture;

    @Column
    private LocalTime heureFermeture;

    @OneToMany(mappedBy = "supermarche")
    private List<Rayon> rayons;

    @OneToOne(fetch = FetchType.EAGER)
    private Employe directeur;

    @ManyToMany
    @JoinTable(
            name = "emploi",
            joinColumns = @JoinColumn(name = "supermarche_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employe_id", referencedColumnName = "id")
    )
    private List<Employe> employes;


    @Override
    public String toString() {
        return "Supermarche{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", heureOuverture=" + heureOuverture +
                ", heureFermeture=" + heureFermeture +
                ", directeur=" + directeur.getId() +
                '}';
    }


}
