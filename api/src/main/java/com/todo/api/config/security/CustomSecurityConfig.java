//package com.todo.api.config.security;
//
//
//import com.todo.api.security.filter.JWTCheckFilter;
//import com.todo.api.security.handler.APILoginFailHandler;
//import com.todo.api.security.handler.APILoginSuccessHandler;
//import com.todo.api.security.handler.CustomAccessDeniedHandler;
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@RequiredArgsConstructor
//@EnableMethodSecurity
//@Configuration
//public class CustomSecurityConfig {
//
//    private static final Logger log = LoggerFactory.getLogger(CustomSecurityConfig.class);
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        log.info("----- security config ----");
//
//        http.cors(httpSecurityCorsConfigurer -> {
//            httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource());
//        });
//
//
//        http.sessionManagement(httpSecuritySessionManagementConfigurer -> {
//            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.NEVER);
//        });
//
//
//        http.cors(AbstractHttpConfigurer::disable);
//
//
//        http.formLogin(config -> {
//            config.loginPage("/api/member/login");
//            config.successHandler(new APILoginSuccessHandler());
//            config.failureHandler(new APILoginFailHandler());
//        });
//
//// , "/swagger", "/swagger-ui.html", "/swagger-ui/**", "/api-docs", "/api-docs/**", "/v3/api-docs/**"
////        http.authorizeHttpRequests((request) ->
////            request.requestMatchers("/api/member/register").permitAll()
////                    .anyRequest().authenticated()
////        );
//
////        http
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/api/member/register","/swagger", "/swagger-ui.html", "/swagger-ui/**", "/api-docs", "/api-docs/**", "/v3/api-docs/**").permitAll()
////                        .anyRequest().authenticated());
//
//
//
//        // UserNamePasswd 전에 JWTCjeck 부터 해줘
//        http.addFilterBefore(new JWTCheckFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        http.exceptionHandling(config -> {
//            config.accessDeniedHandler(new CustomAccessDeniedHandler());
//        });
//
//        return http.build();
//    }
//
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//
//        corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));
//        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
//        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
//        corsConfiguration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//
//        return source;
//    }
//
//}
