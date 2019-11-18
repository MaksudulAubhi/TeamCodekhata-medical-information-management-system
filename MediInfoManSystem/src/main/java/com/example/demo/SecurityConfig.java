package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private CustomLoginSuccessHandler successHandler;

	@Autowired
	private DataSource dataSourse;

	@Value("${spring.queries.emp-query}")                    //queries for login.
	                                                         //link with application.properties
	private String empQuery;

	@Value("${spring.queries.emp-role-query}")
	private String empRoleQuery;
	
	@Value("${spring.queries.doc-query}")
	private String docQuery;

	@Value("${spring.queries.doc-role-query}")
	private String docRoleQuery;

	
	//for login 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {        
		auth.jdbcAuthentication().usersByUsernameQuery(empQuery).authoritiesByUsernameQuery(empRoleQuery)
				.dataSource(dataSourse).passwordEncoder(bCryptPasswordEncoder);
		auth.jdbcAuthentication().usersByUsernameQuery(docQuery).authoritiesByUsernameQuery(docRoleQuery)
		.dataSource(dataSourse).passwordEncoder(bCryptPasswordEncoder);
		

	}

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		//user access right
		
		.antMatchers("/").permitAll()
		.antMatchers("/logon").permitAll()
		
		.antMatchers("/**/doctorRegister").hasAnyAuthority("Admin")        
		.antMatchers("/**/employeeRegister").hasAnyAuthority("Admin")
		.antMatchers("/**/adminPage").hasAnyAuthority("Admin")          // only admin can have permission to access adminPage 
		.antMatchers("/**/doctorEdit").hasAnyAuthority("Admin")
		.antMatchers("/**/doctorList").hasAnyAuthority("Admin")
	    .antMatchers("/**/doctorProfileView").hasAnyAuthority("Admin")
		.antMatchers("/**/employeeEdit").hasAnyAuthority("Admin")
		.antMatchers("/**/employeeList").hasAnyAuthority("Admin")
		.antMatchers("/**/employeeProfileView").hasAnyAuthority("Admin")
		
		
		.antMatchers("/**/receptionistPage").hasAnyAuthority("Receptionist")
		.antMatchers("/**/patientAdmit").hasAnyAuthority("Receptionist")
	
		.antMatchers("/**/doctorPage").hasAnyAuthority("Doctor")
		
		
		.anyRequest().authenticated()
		.and()
		
		//login handler
		.csrf().disable().formLogin()
		.loginPage("/logon")
		.failureUrl("/logon?error=true")
		.successHandler(successHandler)
		.usernameParameter("email")
		.passwordParameter("password")
		.and()
		//logout handler
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logon").and()
		.exceptionHandling()                   
		.accessDeniedPage("/access-denied");         //error handling
		
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**","/static/**","/css/**","/js/**","/image/**");          //folder allowed
	}
	
}
