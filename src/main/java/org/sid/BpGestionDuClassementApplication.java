package org.sid;

import java.util.Arrays;

import org.sid.dao.ArmoireRepository;
import org.sid.dao.BoiteRepository;
import org.sid.dao.BrancheRepository;
import org.sid.dao.MotifRepository;
import org.sid.dao.RolesRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Armoire;
import org.sid.entities.Boite;
import org.sid.entities.Branche;
import org.sid.entities.Motif;
import org.sid.entities.Roles;
import org.sid.entities.Users;
import org.sid.metier.Imetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
@ComponentScan({"org.sid.*"})
@EnableJpaRepositories("org.sid.*")

public class BpGestionDuClassementApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RolesRepository rolesRepository;
	
	@Autowired
	ArmoireRepository  armoireRepository;
	
	@Autowired
	BoiteRepository boiteRepository;
	
	@Autowired
	BrancheRepository brancheRepository;
	
	@Autowired
	MotifRepository motifRepository;
	
	@Autowired
	Imetier imetier;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(BpGestionDuClassementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Users user1=userRepository.save(new Users("bj440057", bCryptPasswordEncoder.encode("123"), 1, "yassine","yassine", "hay", "homme", "bj440057"));
		Users user2=userRepository.save(new Users("bj330057", bCryptPasswordEncoder.encode("123"), 1, "anas","anas", "hay", "homme", "bj330057"));
		Users user3=userRepository.save(new Users("bj550057", bCryptPasswordEncoder.encode("123"), 1, "hamza","hamza", "hay", "homme", "bj550057"));
		
		Roles role1= rolesRepository.save(new Roles("ADMIN"));
		Roles role2=rolesRepository.save(new Roles("RESPONSABLE"));
		Roles role3=rolesRepository.save(new Roles("AGENT"));
		Roles role4=rolesRepository.save(new Roles("AGENTLIB"));
		
		armoireRepository.save(new Armoire("aa1"));
		armoireRepository.save(new Armoire("aa2"));
		
		boiteRepository.save(new Boite("Code Boite 1"));
		boiteRepository.save(new Boite("Code Boite 2"));
		
		brancheRepository.save(new Branche("code1", "nbre1"));
		brancheRepository.save(new Branche("code2", "nbre2"));
		brancheRepository.save(new Branche("code3", "nbre3"));
		
		motifRepository.save(new Motif("motif1"));
		motifRepository.save(new Motif("motif2"));
		motifRepository.save(new Motif("motif3"));*/
		
		
		for (Users u : userRepository.findAll()) {
			System.out.println("name : "+u.getMatricule());
		}
		
		for (Roles r : rolesRepository.findAll()) {
			System.out.println("Role : "+r.getRole());
		}
		
	}
	
	
	
}
