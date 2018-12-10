package org.sid.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.sid.dao.RolesRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.Roles;
import org.sid.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MetierImpl implements Imetier{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RolesRepository rolesRepository;
	 @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;




	@Override
	public Users findByMatricule(String matricule) {

		return userRepository.findByMatricule(matricule);
	}




	@Override
	public void saveUser(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        /*Roles userRole = rolesRepository.findByRole(user.getRoles());
        user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));*/
        userRepository.save(user);
	}








	
/*	public Map<String, Object> getLogedUser(HttpSession httpSession) {
		SecurityContext securityContext= (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContext.getAuthentication().getName();
		List<String> roles =new ArrayList<>();
		for (GrantedAuthority ga: securityContext.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());	
		}
		Map<String, Object> params= new HashMap<>();
		params.put("matricule", username);
		params.put("roles", roles);
		return params;
	}*/

}
