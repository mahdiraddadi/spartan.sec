package org.spartan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.spartan.dao.EtudiantRepository;
import org.spartan.entites.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx=SpringApplication.run(Application.class, args);
		
//		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		etudiantRepository.save( new Etudiant("mahdi", "raddadi", df.parse("1990-11-12")));
//		etudiantRepository.save( new Etudiant("aymen", "aymen", df.parse("1990-11-12")));
//		etudiantRepository.save( new Etudiant("walid", "walid", df.parse("1990-11-12")));
//		etudiantRepository.save( new Etudiant("youssef", "yousef", df.parse("1990-11-12")));
//		etudiantRepository.save( new Etudiant("houssem", "houssem", df.parse("1990-11-12")));
//		
//		List<Etudiant> listeEtudiants= etudiantRepository.findAll();
//		listeEtudiants.forEach(e->System.out.println(e.getNom()));
	}
}
