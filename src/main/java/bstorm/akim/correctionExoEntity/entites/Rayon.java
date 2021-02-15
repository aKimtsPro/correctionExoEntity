package bstorm.akim.correctionExoEntity.entites;

import lombok.*;

import javax.persistence.*;
import java.util.List;

// JPA
@Entity
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rayon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String typeArticle;

    @OneToMany(mappedBy = "rayon")
    private List<Article> articles;

    @ManyToOne
    private Supermarche supermarche;

}
