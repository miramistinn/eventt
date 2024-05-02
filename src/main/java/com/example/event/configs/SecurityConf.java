//package com.example.event.configs;
//
//import com.example.event.services.CustomUserDetailService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConf {
//    private final CustomUserDetailService userDetailsService;
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception{
////        //правила для авторизации
////        http.authorizeRequests((requests) -> requests
////                        .dispatcherTypeMatchers("/registration").permitAll()
////                        .antMatchers("/about", "/home", "/catalog/**", "/productinfo", "/image/**")
////                        .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
////                        .antMatchers("/admin", "/userinfo").hasAuthority("ROLE_ADMIN")
////                        .anyRequest().authenticated()
////                )
////                .formLogin((form) -> form
////                        .loginPage("/login")
////                        .defaultSuccessUrl("/home", true)
////                        .permitAll()
////                )
////                .logout((logout) -> logout.permitAll());
////
////    }
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
////        auth.userDetailsService(userDetailsService)
////                .passwordEncoder(passwordEncoder());
////
////    }
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        return http.
//                authorizeHttpRequests(authorizeHttpRequests ->authorizeHttpRequests
//                        .requestMatchers("/reg.html").permitAll()
//                        .requestMatchers("/about.html").permitAll()
//                        .requestMatchers("/addApllicatoin.html").permitAll()
//                        .requestMatchers("/reg").permitAll()
//                        .requestMatchers("/reg.html").permitAll()
//
//                ).build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder(8);
//    }
//
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers(new String[]{"/static/**"});
////    }
//}
