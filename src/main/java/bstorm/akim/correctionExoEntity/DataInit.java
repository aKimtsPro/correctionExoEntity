package bstorm.akim.correctionExoEntity;

import bstorm.akim.correctionExoEntity.entites.Employe;
import bstorm.akim.correctionExoEntity.entites.Supermarche;
import bstorm.akim.correctionExoEntity.repository.EmployeRepository;
import bstorm.akim.correctionExoEntity.repository.SupermarcheRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//@Component
public class DataInit implements InitializingBean {

    private EmployeRepository employeRepository;
    private SupermarcheRepository supermarcheRepository;

    public DataInit(EmployeRepository employeRepository, SupermarcheRepository supermarcheRepository) {
        this.employeRepository = employeRepository;
        this.supermarcheRepository = supermarcheRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        // initEmploye();
        // initSupermarche();
    }

    private void initEmploye(){
        List<Employe> toSave = new ArrayList<>();

        Employe employe = Employe.builder()
                .nom("luc")
                .emailEmploye("luc@luc.luc")
                .numTel("0")
                .build();
        toSave.add(employe);

        employe = Employe.builder()
                .nom("marie")
                .emailEmploye("marie@marie.marie")
                .numTel("1")
                .build();
        toSave.add(employe);

        employe = Employe.builder()
                .nom("dominique")
                .emailEmploye("dominique@dominique.dom")
                .numTel("2")
                .build();
        toSave.add(employe);

        employeRepository.saveAll(toSave);
    }

    private void initSupermarche(){

        Employe employe = employeRepository.getOne(1);

        Supermarche sm = Supermarche.builder()
                .nom("supermarche1")
                .adresse("rue de supermarche")
                .directeur(employe)
                .heureOuverture(LocalTime.of(8, 30))
                .heureFermeture(LocalTime.of(19, 0))
                .build();

        supermarcheRepository.save(sm);
    }
}
