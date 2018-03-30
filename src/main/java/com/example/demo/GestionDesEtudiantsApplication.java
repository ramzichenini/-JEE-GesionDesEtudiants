package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.entities.Etudiant;

@SpringBootApplication
public class GestionDesEtudiantsApplication { 

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx=SpringApplication.run(GestionDesEtudiantsApplication.class, args);
		EtudiantRepository etudiantRepository=
				ctx.getBean(EtudiantRepository.class);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		/*etudiantRepository.save(new Etudiant("Ramzi", df.parse("1988-11-10"), "ramzi@gmail.com", "photo.jpg"));
		etudiantRepository.save(new Etudiant("Riadh", df.parse("1977-10-11"), "riadh@gmail.com", "photo2.jpg"));
		etudiantRepository.save(new Etudiant("ahmed", df.parse("1992-05-05"), "ahmed@gmail.com", "photo3.jpg"));
		etudiantRepository.save(new Etudiant("Ramzi", df.parse("1988-11-10"), "ramzi@gmail.com", "photo.jpg"));
		etudiantRepository.save(new Etudiant("Riadh", df.parse("1977-10-11"), "riadh@gmail.com", "photo2.jpg"));
		etudiantRepository.save(new Etudiant("ahmed", df.parse("1992-05-05"), "ahmed@gmail.com", "photo3.jpg"));
		etudiantRepository.save(new Etudiant("Ramzi", df.parse("1988-11-10"), "ramzi@gmail.com", "photo.jpg"));
		etudiantRepository.save(new Etudiant("Riadh", df.parse("1977-10-11"), "riadh@gmail.com", "photo2.jpg"));
		etudiantRepository.save(new Etudiant("ahmed", df.parse("1992-05-05"), "ahmed@gmail.com", "photo3.jpg"));
		etudiantRepository.save(new Etudiant("Ramzi", df.parse("1988-11-10"), "ramzi@gmail.com", "photo.jpg"));
		etudiantRepository.save(new Etudiant("Riadh", df.parse("1977-10-11"), "riadh@gmail.com", "photo2.jpg"));
		etudiantRepository.save(new Etudiant("ahmed", df.parse("1992-05-05"), "ahmed@gmail.com", "photo3.jpg"));
		
		Page<Etudiant> etds=etudiantRepository.findAll(new PageRequest(0, 5));
		etds.forEach(e->System.out.println(e.getNom()));
						*/
	}
}
