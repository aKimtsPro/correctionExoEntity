package bstorm.akim.correctionExoEntity;

import bstorm.akim.correctionExoEntity.entites.Employe;
import bstorm.akim.correctionExoEntity.entites.Supermarche;
import bstorm.akim.correctionExoEntity.repository.ArticleRepository;
import bstorm.akim.correctionExoEntity.repository.EmployeRepository;
import bstorm.akim.correctionExoEntity.repository.SupermarcheRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

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
		ArticleRepository articleRepository = context.getBean(ArticleRepository.class);

//		Supermarche supermarche = smRepository.getOne(6);

//		List<String> emails = new ArrayList<>();
//		emails.add("lUc@luc.Luc"); //
//		emails.add("marIe@marie.Marie"); //
//		emails.add("raNdom");

//		List<Employe> employes = employeRepository.findByEmailEmployeIgnoreCaseNotInAndNom(emails,"LUC");
//		System.out.println(employes.size());

//		List<String> noms = employeRepository.findEmailByNom("luc");
//		noms.forEach(System.out::println);

		articleRepository.insert("AAAAAAAA", "pomme", "markPom", 2D);
		articleRepository.insert("AAAAAAAB", "banane", "markBnn", 1.5);
		articleRepository.insert("AAAAAAAC", "ananas", "markAna", 2.5);



	}

}
