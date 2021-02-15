package bstorm.akim.correctionExoEntity;

import bstorm.akim.correctionExoEntity.entites.Supermarche;
import bstorm.akim.correctionExoEntity.repository.SupermarcheRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;

@Service
public class SupermarcheService {

    private SupermarcheRepository repo;

    public SupermarcheService(SupermarcheRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void test(){
        Supermarche sm = Supermarche.builder()
                .adresse("rue du supermarche")
                .nom("supermrkt")
                .heureOuverture(LocalTime.of(8, 30))
                .heureFermeture(LocalTime.of(19, 0))
                .build();

        repo.save(sm);
        // ---
        sm.setAdresse("changer adresse");
    }

    @Transactional
    public void getById(int id){
        System.out.println(repo.getOne(id));
    }
}
