package com.omejia.config;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.omejia.filter.JWTTokenGeneratorFilter;
import com.omejia.filter.JWTTokenValidatorFilter;
import com.omejia.filter.AuthoritiesLoggingAfterFilter;
import com.omejia.filter.AuthoritiesLoggingAtFilter;


@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
		cors().configurationSource(new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setExposedHeaders(Arrays.asList("Authorization"));
				config.setMaxAge(3600L);
				return config;
			}
		}).and().csrf().disable()
				//.addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
				.addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
				.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
				.addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers("/myAccount").hasRole("USER")
				.antMatchers("/myBalance").hasAnyRole("USER","ADMIN")
				.antMatchers("/myLoans").hasAnyRole("USER","ADMIN")
				.antMatchers("/myCards").hasAnyRole("USER","ADMIN")
				.antMatchers("/user").authenticated()
				.antMatchers("/createUser").hasAnyRole("ADMIN")
				.antMatchers("/product/*").permitAll()//.hasAnyRole("ADMIN")
				.antMatchers("/notices").permitAll()
				.antMatchers("/contact").permitAll().and().httpBasic();
	
		/**
		 * Default configurations which will secure all the requests
		 */

		/*
		 * http .authorizeRequests() .anyRequest().authenticated() .and()
		 * .formLogin().and() .httpBasic();
		 */

		/**
		 * Custom configurations as per our requirement
		 */

		/*
		 * http.authorizeRequests().antMatchers("/myAccount").authenticated().
		 * antMatchers("/myBalance").authenticated()
		 * .antMatchers("/myLoans").authenticated().antMatchers("/myCards").
		 * authenticated().antMatchers("/notices")
		 * .permitAll().antMatchers("/contact").permitAll().antMatchers("/welcome").
		 * permitAll().and().formLogin() .and().httpBasic();
		 *
		 *//**
			 * Configuration to deny all the requests
			 */

		/*
		 * http .authorizeRequests() .anyRequest().denyAll() .and() .formLogin().and()
		 * .httpBasic();
		 */

		/**
		 * Configuration to permit all the requests
		 */

		/*
		 * http .authorizeRequests() .anyRequest().permitAll().and().formLogin().and()
		 * .httpBasic();
		 */
	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 *
	 * auth.inMemoryAuthentication().withUser("admin").password("12345").authorities
	 * ("admin").and(). withUser("user").password("12345").authorities("read").and()
	 * .passwordEncoder(NoOpPasswordEncoder.getInstance());
	 *
	 *
	 *
	 * InMemoryUserDetailsManager userDetailsService = new
	 * InMemoryUserDetailsManager(); UserDetails user =
	 * User.withUsername("admin").password("12345").authorities("admin").build();
	 * UserDetails user1
	 * =User.withUsername("user").password("12345").authorities("read").build();
	 *
	 * userDetailsService.createUser(user); userDetailsService.createUser(user1);
	 * auth.userDetailsService(userDetailsService);
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 * }
	 */

	/*
	 * @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
	 * return new JdbcUserDetailsManager(dataSource); }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
