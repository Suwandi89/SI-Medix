package tk.propensi.medix.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/signup**").permitAll()
                .antMatchers("/tenants").permitAll()
                .antMatchers("/verify**").permitAll()
                .antMatchers("/resendcode").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/jss/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/api/v1/**").permitAll()
                .antMatchers("/api-docs").permitAll()
                .antMatchers("/v3/api-docs/**").permitAll()
                .antMatchers("/pendaftar/**","/viewall","/viewall-flagged", "/viewall-hidden").hasAuthority("Admin Medix")
                .antMatchers("/rekamMedis/**").hasAuthority("Admin Khanza")
                .antMatchers("/rekamMedisHide/**").hasAuthority("Admin Medix")
                .antMatchers("/rekamMedisFlag/**").hasAuthority("Admin Medix")
                //.antMatchers("/rumahsakit/**", "/viewall-rumahsakit").permitAll()
                .antMatchers("/rumahsakit/**", "/viewall-rumahsakit").hasAnyAuthority("Admin Medix", "Admin Khanza")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll()
                .and()
                .cors()
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public BCryptPasswordEncoder encoder() { return new BCryptPasswordEncoder(); }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder())
//                .withUser("kijangSatu").password(encoder().encode("nasiGoreng"))
//                .roles("Admin Medix");
//    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Lazy
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

}
