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
		.antMatchers("/**/doctorList").hasAnyAuthority("Admin","Head")
	    .antMatchers("/**/deleteDoctor").hasAnyAuthority("Admin")
	    
	    
		.antMatchers("/**/editEmployee").hasAnyAuthority("Admin")
		.antMatchers("/**/employeeList").hasAnyAuthority("Admin","Head")
		.antMatchers("/**/viewEmployee").hasAnyAuthority("Admin","Head")
		.antMatchers("/**/viewDoctor").hasAnyAuthority("Admin","Head")
		.antMatchers("/**/deleteEmployee").hasAnyAuthority("Admin")
		
		.antMatchers("/**/editPatient").hasAnyAuthority("Admin")
		.antMatchers("/**/viewPatient").hasAnyAuthority("Admin","Doctor","Receptionist","Head","Nurse","Officer")
		.antMatchers("/**/patientList").hasAnyAuthority("Admin","Doctor","Receptionist","Nurse","Officer","Head")
		.antMatchers("/**/deletePatient").hasAnyAuthority("Admin")
		
		.antMatchers("/**/wardInfoAdd").hasAnyAuthority("Admin")
		.antMatchers("/**/wardList").hasAnyAuthority("Admin","Receptionist","Head")
		.antMatchers("/**/wardInfoUpdate").hasAnyAuthority("Admin","Receptionist")
		.antMatchers("/**/editWard").hasAnyAuthority("Admin","Receptionist")
		
		
		.antMatchers("/**/receptionistPage").hasAnyAuthority("Receptionist")
		.antMatchers("/**/patientAdmit").hasAnyAuthority("Receptionist")
		
		.antMatchers("/**/doctorPage").hasAnyAuthority("Doctor")
		.antMatchers("/**/patientAssign").hasAnyAuthority("Doctor")
		
		.antMatchers("/**/nursePage").hasAnyAuthority("Nurse")
		.antMatchers("/**/labPage").hasAnyAuthority("Lab")
		.antMatchers("/**/officerPage").hasAnyAuthority("Officer")
		.antMatchers("/**/headPage").hasAnyAuthority("Head")
		.antMatchers("/**/pharmacyPage").hasAnyAuthority("Pharmacy")
		.antMatchers("/**/transportPage").hasAnyAuthority("Transport")
		
		.antMatchers("/**/prescriptionCreate").hasAnyAuthority("Doctor")
		.antMatchers("/**/prescriptionEdit").hasAnyAuthority("Doctor")
		.antMatchers("/**/prescriptionView").hasAnyAuthority("Doctor","Nurse","Head")
		.antMatchers("/**/assignedPatientPrescription").hasAnyAuthority("Doctor","Nurse","Head")
		.antMatchers("/**/prescriptionDelete").hasAnyAuthority("Doctor")
		
		.antMatchers("/**/diagnosisReportList").hasAnyAuthority("Doctor","Head","Nurse","Lab","Admin")
		.antMatchers("/**/diagnosisReportDelete").hasAnyAuthority("Admin")
		.antMatchers("/**/diagnosisReportAssign").hasAnyAuthority("Receptionist")
		.antMatchers("/**/patientDiagnosisReport").hasAnyAuthority("Nurse","Doctor","Head")
		.antMatchers("/**/diagnosisReportView").hasAnyAuthority("Doctor","Nurse","Head","Lab")
		.antMatchers("/**/diagnosisReportPrepare").hasAnyAuthority("Doctor")
		
		.antMatchers("/**/billingList").hasAnyAuthority("Officer","Admin","Head","Receptionist")
		.antMatchers("/**/billingDelete").hasAnyAuthority("Admin")
		.antMatchers("/**/billingView").hasAnyAuthority("Officer","Head")
		.antMatchers("/**/billingCreate").hasAnyAuthority("Officer")
		.antMatchers("/**/billingEdit").hasAnyAuthority("Officer")
		
		.antMatchers("/**/appointmentCreate").hasAnyAuthority("Receptionist")
		.antMatchers("/**/appointmentList").hasAnyAuthority("Doctor","Receptionist","Admin")
		.antMatchers("/**/appointmentDelete").hasAnyAuthority("Admin")
		.antMatchers("/**/appointmentEdit").hasAnyAuthority("Receptionist")
		.antMatchers("/**/sendRemainder").hasAnyAuthority("Receptionist")
		.antMatchers("/**/doctorAppointmentList").hasAnyAuthority("Doctor")
		
		.antMatchers("/**/financialReportList").hasAnyAuthority("Officer","Head","Admin")
		.antMatchers("/**/financialReportView").hasAnyAuthority("Officer","Head")
		.antMatchers("/**/financialReportDelete").hasAnyAuthority("Admin")
		.antMatchers("/**/financialReportCreate").hasAnyAuthority("Officer")
		.antMatchers("/**/financialReportEdit").hasAnyAuthority("Officer")
		
		.antMatchers("/**/transportList").hasAnyAuthority("Transport")
		.antMatchers("/**/transportCreate").hasAnyAuthority("Transport")
		.antMatchers("/**/transportEdit").hasAnyAuthority("Transport")
		
		.antMatchers("/**/pharmacyList").hasAnyAuthority("Pharmacy")
		.antMatchers("/**/pharmacyEdit").hasAnyAuthority("Pharmacy")
		.antMatchers("/**/pharmacyCreate").hasAnyAuthority("Pharmacy")
		
		
		
		
		
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
