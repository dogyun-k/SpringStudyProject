package com.study.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity      // 이 어노테이션을 하면 SpringSecurityFilterChain이 자동으로 포함된다.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // 스프링 시큐리티의 기본 설정들을 재설정해줘보자
    // 예를 들면 처음 시작할 때 기본 로그인 화면 등을 끄기

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // cors, csrf는 잘 모르겠다.
        http.cors().disable()
            .csrf().disable()
            .formLogin().disable()
            .headers().frameOptions().disable();
    }
}
