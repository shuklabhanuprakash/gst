/**
 * 
 */
package com.gst;

/**
 * @author miles20
 *
 */
//@Configuration
//@EnableWebSecurity
/*public class SecurityConfig extends WebSecurityConfigurerAdapter {
	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("user").password("password").roles("USER");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .authorizeRequests()
	                    .antMatchers("/api/auth").permitAll()
	                    .anyRequest().authenticated()
	                .and()
	                .requestCache()
	                    .requestCache(new NullRequestCache())
	                .and()
	                .csrf()
	                    .ignoringAntMatchers("/api/*")
	        ;
	    }
}*/
