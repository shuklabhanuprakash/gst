/**
 * 
 */
package com.gst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;

import com.gst.service.UserService;

/**
 * @author miles20
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationEntryPoint entryPoint;
	
	@Autowired
	private UserService userService;
	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.userDetailsService(userService);
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http
	    	.csrf().disable()
            .authorizeRequests()
                .antMatchers("/**").hasRole("USER")
                .and()
            .formLogin();
	    	//http.authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(entryPoint);
	    }
}
