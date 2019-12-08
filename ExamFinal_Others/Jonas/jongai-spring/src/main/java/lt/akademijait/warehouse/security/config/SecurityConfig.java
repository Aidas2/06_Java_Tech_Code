package lt.akademijait.warehouse.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lt.akademijait.warehouse.security.security.CustomUserDetailsService;
import lt.akademijait.warehouse.security.security.JwtAuthenticationEntryPoint;
import lt.akademijait.warehouse.security.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .csrf()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
				.antMatchers(
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js")
                        .permitAll()
				.antMatchers("/api/auth/signin") // Reiškia, kad tik prie logino gali visi prieiti
                        .permitAll()
				// .antMatchers("/users")
				// .permitAll()
				// .antMatchers("/console")
				// .permitAll()
				// .antMatchers("/holidays")
				// .permitAll()
				// .antMatchers("/holidays/**/addedCountries")
				// .permitAll()
				// .antMatchers("/holidays/**/addingCountries")
				// .permitAll()
				// .antMatchers("/holidays/**")
				// .permitAll()
				// .antMatchers("/countries")
				// .permitAll()
				// .antMatchers("/countries/**")
				// .permitAll()
				// .antMatchers("/api/user/checkUsernameAvailability",
				// "/api/user/checkEmailAvailability")
				// .permitAll()
				// .antMatchers(HttpMethod.GET, "/holidays/**", "/api/users/**")
				// .permitAll()
				// .anyRequest()
                        //.authenticated(); //originale buvo taip, o as pridejau kita eilute 
				// .permitAll()
                    .and()
                    	.headers().frameOptions().disable();
        
        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}