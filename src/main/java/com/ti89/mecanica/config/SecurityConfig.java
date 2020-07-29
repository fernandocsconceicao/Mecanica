//package com.ti89.mecanica.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	private static final String[] PUBLIC_MATCHERS= {
//			"/autenticacao",
//			"/h2-console",
//			"/cliente/**"
//	};
//	
//	@Override
//	protected void configure (HttpSecurity http) throws Exception{
//		http.cors();
//		http.authorizeRequests()
//		.antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();
//	}
////	@Bean
////	CorsConfigurantionSource corsConfigurationSource() {
////		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
////		return source;
////	}
//}
