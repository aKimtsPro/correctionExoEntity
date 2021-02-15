package bstorm.akim.correctionExoEntity.entites;

import lombok.*;

import javax.persistence.*;

// JPA
@Entity
// Lombok
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id
    @Column(length = 8/*, columnDefinition="varchar(8)"*/)
    private String codeBarre;

    @Column
    private String nom;

    @Column
    private String marque;

    @Column
    private String description;

    @Column
    private Double prix;

    @ManyToOne
    @JoinColumn(
            name = "dans_rayon",
            referencedColumnName = "id",
            unique = false,
            insertable = true,
            updatable = true
            //, foreignKey = @ForeignKey()
    )
    private Rayon rayon;
}
