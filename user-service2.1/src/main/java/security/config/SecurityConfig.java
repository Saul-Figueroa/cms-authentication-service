package security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import springSecurity.UserPrincipleDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private UserPrincipleDetailService userPrince;
	public SecurityConfig(UserPrincipleDetailService userPrincipleDetails) {
		this.userPrince= userPrincipleDetails;
	}
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(authenticationProvider());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.
				authorizeRequests()
				.antMatchers("/cms/view").permitAll()
				.antMatchers("/api/**").permitAll()
				.antMatchers("/api/logout").authenticated()
				.and()
				.formLogin()
				.loginProcessingUrl("localhost:4200/login").permitAll()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

	}
	
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrince);
		return daoAuthenticationProvider;
		
	}

}