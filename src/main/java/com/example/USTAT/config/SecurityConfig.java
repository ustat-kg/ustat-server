package com.example.USTAT.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and()
                .authorizeRequests().anyRequest().authenticated()
                .antMatchers("/**").permitAll()
//                 .antMatchers("/ustat/login").permitAll()
//                 .antMatchers("/ustat/registration").permitAll()
//                  .antMatchers("/ustat/admin/deleteLocation/{id}").hasAuthority("ADMIN")
//                .antMatchers("/ustat/deleteStudent/{id}").hasAuthority("ADMIN")
//                 .antMatchers("/ustat/getAllStudents").hasAuthority("ADMIN")
//                .antMatchers("/ustat/getAllSubject").permitAll()
//                .antMatchers("/ustat/getStudent/{id}").permitAll()
//                .antMatchers("/ustat/getAllLocations").hasAuthority("USER")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().csrf().disable();
    }
}