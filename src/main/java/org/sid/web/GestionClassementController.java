package org.sid.web;


import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.sid.dao.ProduitRepository;
import org.sid.dao.ArmoireRepository;
import org.sid.dao.BoiteRepository;
import org.sid.dao.BrancheRepository;
import org.sid.dao.DossierRepository;
import org.sid.dao.MotifRepository;
import org.sid.dao.MouvementRepository;
import org.sid.dao.RolesRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Armoire;
import org.sid.entities.Boite;
import org.sid.entities.Branche;
import org.sid.entities.Dossier;
import org.sid.entities.Motif;
import org.sid.entities.Mouvement;
import org.sid.entities.Roles;
import org.sid.entities.Users;
import org.sid.metier.NotificationService;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class GestionClassementController {
	
	@Autowired
	public ProduitRepository produitRepository;
	@Autowired
	public DossierRepository dossierRepository;
	
	@Autowired
	public ArmoireRepository armoireRepository;
	
	@Autowired
	public BrancheRepository brancheRepository;
	
	@Autowired
	public BoiteRepository boiteRepository;
	
	@Autowired
	public RolesRepository rolesRepository;
	
	
	@Autowired
	public MotifRepository motifRepository;
	
	@Autowired
	public MouvementRepository mouvementRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public NotificationService notificationService;
	
	
	
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	@RequestMapping(value="/")
	public String home() { 
		return "redirect:/index";
	}
	
	@RequestMapping(value="/404")
	public String accessDenied() {
		return "404";
	}
	
	@RequestMapping(value="/profil")
	public String profil(Model model,Principal p ) {
		Users user=userRepository.findByMatricule(p.getName());
		model.addAttribute("user",user);
		return "profil";
	}
	
	@RequestMapping(value="/register")
	public String register(Model model) {
		Users user=new Users();
		List<Roles>roles=rolesRepository.findAll();
		List<Branche>branches=brancheRepository.findAll();
		model.addAttribute("roles",roles);
		model.addAttribute("branches",branches);
		model.addAttribute("user",user);
		return "register";
	}
	@RequestMapping(value="/ajouterUser",method=RequestMethod.POST)
	public String ajouterUser(Model model,@Valid Users user,BindingResult bindingResult, Roles roles,String codeBranche) {
		
		try {
			List<Users>users=userRepository.findAll();
			for (Users u:users) {
				if (u.getCinUser()==user.getCinUser()) {
					List<Roles>roless=rolesRepository.findAll();
					List<Branche>branches=brancheRepository.findAll();
					model.addAttribute("roles",roless);
					model.addAttribute("branches",branches);
					model.addAttribute("user",user);
					return "register";
					}
			}
				if (bindingResult.hasErrors() ) {
					
				List<Roles>roless=rolesRepository.findAll();
				List<Branche>branches=brancheRepository.findAll();
				model.addAttribute("roles",roless);
				model.addAttribute("branches",branches);
				model.addAttribute("user",user);
				return "register"; 
				}
				Branche branche=brancheRepository.findByCodeBranche(codeBranche);
				user.setBrancheUser(branche);
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
				user.setActive(1);
				userRepository.save(user);
				model.addAttribute("roles",roles);
				model.addAttribute("user", user);
				model.addAttribute("branche", branche);
			
		}
		 catch (Exception e) {
			return "404";
		}
		
		return "confirmationUtilisateur";
	}
	@RequestMapping(value="/creation")
	public String creation( Model model) {
		Dossier dossier=new Dossier();
		List<Armoire> armoires=armoireRepository.findAll();
		List<Boite> boites=boiteRepository.findAll();
		model.addAttribute("armoires", armoires);
		model.addAttribute("boites", boites);
		model.addAttribute("dossier", dossier);
		
		
		return "creation";
	}
	@RequestMapping(value="/creer",method=RequestMethod.POST)
	public String creer(Model model,@Valid Dossier dossier,BindingResult bindingResult,String codeBoite,String codeArmoire,Principal p) {
		try {
				/*List<Dossier>dossiers=dossierRepository.findAll();
				for (Dossier d:dossiers) {
					if (d.getCodeDossier()==dossier.getCodeDossier()) {
						List<Armoire> armoires=armoireRepository.findAll();
						List<Boite> boites=boiteRepository.findAll();
						model.addAttribute("armoires", armoires);
						model.addAttribute("boites", boites);
						return "creation";
						}
					}*/
				
				if (bindingResult.hasErrors()) {
				List<Armoire> armoires=armoireRepository.findAll();
				List<Boite> boites=boiteRepository.findAll();
				model.addAttribute("armoires", armoires);
				model.addAttribute("boites", boites);
				return "creation";
				}
				Users user=userRepository.findByMatricule(p.getName());
				Armoire armoire=armoireRepository.findByCodeArmoire(codeArmoire);
				Boite boite=boiteRepository.findByCodeBoite(codeBoite);
				/*boiteRepository.save(boite);
				dossier.setBoiteDossier(boite);*/
				dossier.setUserDossier(user);
				dossier.setBoiteDossier(boite);
				dossierRepository.save(dossier);
				model.addAttribute("user", user);
				model.addAttribute("boite",boite);
				model.addAttribute("armoire",armoire);

			
		} catch (Exception e) {
			return "404";
		}
		return "confirmationCreation";
	}
	@RequestMapping(value="/mouvement")
	public String mouvement(Model model) {
		model.addAttribute("d", new Dossier());
		List<Dossier> dossiers =dossierRepository.findAll();
		List<Motif> motifs=motifRepository.findAll();
		List<Dossier>dossierstoMove=new ArrayList<>();
		
		for (Dossier dossier:dossiers) {
			if (dossier.getMvmntDossier()==null) {
				dossierstoMove.add(dossier);
				}
			}
		
		model.addAttribute("dossiers",dossierstoMove);
		model.addAttribute("motifs",motifs);
		return "mouvement";
	}
	@RequestMapping(value="/move",method=RequestMethod.POST)
	public String move(Model model, String codeDossier) {
		try {
		List<Motif> motifs=motifRepository.findAll();
		model.addAttribute("motifs",motifs);
		Dossier dossier=dossierRepository.findByCodeDossier(codeDossier);
		Boite boite=dossier.getBoiteDossier();
		Armoire armoir=boite.getArmoire();
		model.addAttribute("d", dossier);
		model.addAttribute("b", boite);
		model.addAttribute("a", armoir);
		
		} catch (Exception e) {
			return "404";
		}
		return "mouvement2";
	}
	
	@RequestMapping(value="/move2",method=RequestMethod.POST)
	public String move2(Model model, Mouvement mvmnt , String codeDossier,String nomMotif,Principal p) {
		try {
		
		Users user=userRepository.findByMatricule(p.getName());
		Motif motif=motifRepository.findByNomMotif(nomMotif);
		mvmnt.setUserMvmnt(user);
		mvmnt.setMotifMvmnt(motif);
		mouvementRepository.save(mvmnt);
		Dossier dossier=dossierRepository.findByCodeDossier(codeDossier);
		dossier.setMvmntDossier(mvmnt);
		dossierRepository.save(dossier);
		model.addAttribute("user", user);
		model.addAttribute("motif", motif);
		model.addAttribute("mvmnt", mvmnt);
		model.addAttribute("dossier", dossier);

		} catch (Exception e) {
			return "404";
		}
		return "confirmationMouvement";
	}
	
	
	@RequestMapping(value="/editique")
	public String editique(Model model) {
		List<Dossier> dossiers=dossierRepository.findAll();
		List<Dossier>dossiersMoved=new ArrayList<>();
		
		for (Dossier dossier:dossiers) {
			if (dossier.getMvmntDossier()!=null  && dossier.getMvmntDossier().getValidation() !=1 ) {
				dossiersMoved.add(dossier);
				}
			}
		
		model.addAttribute("dossiersMoved", dossiersMoved);
		
		return "editique";
	}
	@RequestMapping(value="/editer")
	public String editer(Model model,String codeDossier) {
		Dossier dossier=dossierRepository.findByCodeDossier(codeDossier);
		model.addAttribute("d", dossier);
		List<Motif> motifs=motifRepository.findAll();
		model.addAttribute("motifs",motifs);
		return "mouvementedition";
	}
	@RequestMapping(value="/move3",method=RequestMethod.POST)
	public String move3(Model model,Mouvement mvmnt, String codeDossier,String nomMotif) {
		try {
		Dossier dossier=dossierRepository.findByCodeDossier(codeDossier);
		Mouvement mvment=dossier.getMvmntDossier();
		Motif motif=motifRepository.findByNomMotif(nomMotif);
		mvment.setValidation(1);
		mvment.setMotifMvmnt(motif);
		mvment.setDateMvmnt(mvmnt.getDateMvmnt());
		mvment.setDateRest(mvmnt.getDateRest());
		mvment.setNumcont(mvmnt.getNumcont());
		mouvementRepository.save(mvment);
		dossier.setMvmntDossier(mvment);
		dossierRepository.save(dossier);
		model.addAttribute("motif", motif);
		model.addAttribute("mvmnt", mvment);
		model.addAttribute("dossier", dossier);
		notificationService.sendMail();
		
		} catch (Exception e) {
			return "404";
		}
		return "confirmationEdition";
	}
	

	@RequestMapping(value="/valider")
	public String valider(Model model,String codeDossier) {
		Dossier dossier=dossierRepository.findByCodeDossier(codeDossier);
		Mouvement mvmnt=dossier.getMvmntDossier();
		mvmnt.setValidation(2);
		mouvementRepository.save(mvmnt);
		
		List<Dossier> dossiers=dossierRepository.findAll();
		List<Dossier>dossiersMoved=new ArrayList<>();
		for (Dossier doss:dossiers) {
			if (doss.getMvmntDossier()!=null  && doss.getMvmntDossier().getValidation() !=1 ) {
				dossiersMoved.add(doss);
				}
			}
		model.addAttribute("dossiersMoved", dossiersMoved);
		
		return "editique";
	}
	
	

	
	@RequestMapping("/download")
    public String download(Model model) {
		List<Dossier> dossiers=dossierRepository.findAll();
		List<Dossier>dossiersMoved=new ArrayList<>();
		
		for (Dossier dossier:dossiers) {
			if (dossier.getMvmntDossier()!=null  && dossier.getMvmntDossier().getValidation() !=1 ) {
				dossiersMoved.add(dossier);
				}
			}
		
		model.addAttribute("dossiersMoved", dossiersMoved);
        return "404";
    }
	
	@RequestMapping("/tableUsers")
    public String tableUsers(Model model, Principal p) {
		Users user=userRepository.findByMatricule(p.getName());
		model.addAttribute("user", user);
		model.addAttribute("users",userRepository.findAll());
        return "tableUsers";
    }
	
	@RequestMapping("/tableBranches")
    public String tableBranches(Model model) {
		model.addAttribute("branches",brancheRepository.findAll());
        return "tableBranches";
    }
	
	@RequestMapping("/tableDossiers")
    public String tableDossiers(Model model) {
		List<Dossier> dossiers=dossierRepository.findAll();
		List<Dossier>dossiersNotMoved=new ArrayList<>();
		for (Dossier doss:dossiers) {
			if (doss.getMvmntDossier()==null ) {
				dossiersNotMoved.add(doss);
				}
			}
		model.addAttribute("dossiers", dossiersNotMoved);
        return "tableDossiers";
    }
	
	@RequestMapping("/tableArmoireBoites")
    public String tableArmoireBoites(Model model) {
		model.addAttribute("armoires",armoireRepository.findAll());
        return "tableArmoireBoites";
    }
	@RequestMapping("/tableProduits")
    public String tableProduits(Model model) {
		model.addAttribute("produits",produitRepository.findAll());
        return "tableProduits";
    }
	
	@RequestMapping("/tableMotifs")
    public String tableMotifs(Model model) {
		model.addAttribute("motifs",motifRepository.findAll());
        return "tableMotifs";
    }
	
	@RequestMapping("/tableMouvement")
    public String tableMouvement(Model model,Principal p) {
		Users user=userRepository.findByMatricule(p.getName());
		/*List<Mouvement> mvmnt=mouvementRepository.findAll();
		List<Mouvement>mvmnts=new ArrayList<>();
		for (Mouvement mv:mvmnt) {
			if (mv.getValidation()!=1  ) {
				mvmnts.add(mv);
				}
			}
		model.addAttribute("mvmnts",mvmnts);*/
		model.addAttribute("user", user);
		List<Dossier> dossiers=dossierRepository.findAll();
		List<Dossier>dossiersMoved=new ArrayList<>();
		
		for (Dossier dossier:dossiers) {
			if (dossier.getMvmntDossier()!=null  && dossier.getMvmntDossier().getValidation()!=1 ) {
				dossiersMoved.add(dossier);
				}
			}
		model.addAttribute("dossiersMoved", dossiersMoved);
        return "tableMouvement";
    }
	
	@RequestMapping("/tableMouvementForValidation")
    public String tableMouvementForValidation(Model model) {
		List<Dossier> dossiers=dossierRepository.findAll();
		List<Dossier>dossierstoMove=new ArrayList<>();
		
		for (Dossier dossier:dossiers) {
			if (dossier.getMvmntDossier()!=null  && dossier.getMvmntDossier().getValidation()==1 ) {
				dossierstoMove.add(dossier);
				}
			}
		model.addAttribute("dossierstoMove", dossierstoMove);
		
        return "tableMouvementForValidation";
    }
	
	
}
