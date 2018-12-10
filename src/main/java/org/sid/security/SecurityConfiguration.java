package org.sid.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.jdbcAuthentication().dataSource(dataSource).
		usersByUsernameQuery("select matricule as principal ,password as credentials ,active from users where matricule=?")
		.authoritiesByUsernameQuery("select users_matricule as principal , roles_role as role from users_roles where users_matricule=?")
		.passwordEncoder(bCryptPasswordEncoder)
		.rolePrefix("ROLE_");
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	/*	http.
		authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/index").permitAll()
			.antMatchers("/adminstration").hasAuthority("ADMIN").anyRequest()
			.authenticated().and().csrf().disable().formLogin()
			.loginPage("/login").failureUrl("/login?error=true")
			.defaultSuccessUrl("/admin/home")
			.usernameParameter("email")
			.passwordParameter("password")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").and().exceptionHandling()
			.accessDeniedPage("/403");*/
		
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/403","/404","/confirmationCreation","/confirmationEdition","/confirmationMouvement","/download","/confirmationUtilisateur","/creation","/editique","/index","/mouvement","/mouvement2","/mouvementedition","/profil","/tableArmoireBoites","/tableBranches","/tableDossiers","/tableMotifs","/tableMouvement","/tableProduits","/tableUsers").hasAnyRole("ADMIN","RESPONSABLE","AGENT","AGENTLIB");
		http.authorizeRequests().antMatchers("/register","/tableMouvementForValidation").hasAnyRole("ADMIN","RESPONSABLE");
		http.authorizeRequests().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").and().exceptionHandling();
		
		//Personnaliser les erreurs
		http.exceptionHandling().accessDeniedPage("/404");
			
	}
	
	/*@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                .antMatchers("/webjars/**","/css/**", "/less/**","/img/**","/js/**");
    }*/
}
