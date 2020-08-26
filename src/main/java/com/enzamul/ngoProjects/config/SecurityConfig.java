package com.enzamul.ngoProjects.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/**
 *
 * @author MD ENZAMUL HOQ
 */

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = com.enzamul.ngoProjects.repo.UserRepo.class)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoggingAccessDeniedHandler loggingAccessDeniedHandler;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /////////////////
    @Bean
    public HttpFirewall defaultHtttpFirewall(){

        return new DefaultHttpFirewall();
    }



    ////////////////


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


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(
                        "/login", "/user/add/**","/user/list/**","/signup","/confirm/**","/static/**","/assets/**",
                        "/dist/**","/extra-libs/**","/calendar/**","/DataTables/**","/gitter/**","/multicheck/**","/sparkline/**","/webfonts/**").permitAll()

               .antMatchers("/images/**","/background/**","/big/**","/User/**","/libs/**","/bootstrap/**","/css/**",

                       "/js/**","/bootstrap-datepicker/**","/locales/**","/chart/**","/datatables/**","/media/**","/flot/**","/examples/**",

                       "/excanvas/**","/fullcalendar/**","/locale/**","/inputmask/**","/jquery/**","/jquery-asColor/**","/src/**","/jquery-asColorPicker/**",

                       "/jquery-asGradient/**","/jquery-minicolors/**","/jquery-steps/**","/jquery-validation/**","/magnific-popup/**",

                       "/moment/**","/perfect-scrollbar/**","/popper/**","/quill/**","/select2/**","/toastr/**").permitAll()
                .antMatchers("/icons/**","/font-awesome/**","/less/**","/scss/**","/material-design-iconic-font/**",
                        "/fonts/**","/themify-icons/**","/weather-icons/**","/pages/**"   ).permitAll()
                .antMatchers("/about","role/add/**","/role/list/**").permitAll()
//                .antMatchers("/").hasRole("SUPERADMIN")
//                .antMatchers("/").access("hasRole('ROLE_SUPERADMIN')")
//                .antMatchers("/").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
//                .antMatchers("/").hasAnyAuthority("user", "admin", "superadmin")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll()
                .and().exceptionHandling().accessDeniedHandler(loggingAccessDeniedHandler);
    }






}
