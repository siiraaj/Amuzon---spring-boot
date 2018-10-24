package fr.amu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.amu.util.Utils;

@SpringBootApplication
public class Application {

	/*
	 * le controlleur utilise le service 
	 * le service utilise le DAO
	 * le DAO utilise la base de donnees 
	 * */
	
	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
//		 Utils.openBrowser("http://localhost:8090"); // pour ouvrir le navigateur par
//		 défaut. Utile lorsque la vue sera disponible.
		
		
	}

}