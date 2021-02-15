package bstorm.akim.correctionExoEntity;

import bstorm.akim.correctionExoEntity.entites.Employe;
import bstorm.akim.correctionExoEntity.entites.Supermarche;
import bstorm.akim.correctionExoEntity.repository.EmployeRepository;
import bstorm.akim.correctionExoEntity.repository.SupermarcheRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class CorrectionExoEntityApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CorrectionExoEntityApplication.class, args);

		// Demo @Transactional

//		SupermarcheService service = context.getBean(SupermarcheService.class);
//
//		service.test();

		// Demo Custom query

//		EmployeRepository employeRepository = context.getBean(EmployeRepository.class);
//
//		Optional<Employe> optEmploye = employeRepository.findByEmailEmploye("luc@luc.luc");
//		optEmploye.ifPresentOrElse(
//				System.out::println,
//				() -> System.out.println("pas d'employe correspondant")
//		);

		EmployeRepository employeRepository = context.getBean(EmployeRepository.class);
		SupermarcheRepository smRepository = context.getBean(SupermarcheRepository.class);

		Employe employe = employeRepository.getOne(1);

		smRepository.findByDirecteur(employe)
				.ifPresentOrElse(
						System.out::println,
						()-> System.out.println("supermarche introuvable")
				);


	}

}
