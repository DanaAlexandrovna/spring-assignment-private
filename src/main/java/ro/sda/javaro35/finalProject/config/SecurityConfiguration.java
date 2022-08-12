package ro.sda.javaro35.finalProject.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ro.sda.javaro35.finalProject.service.user.UserService;

import javax.validation.constraints.NotNull;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    // permiti accesul la resurse, definesti form login
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/register/**")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();
    }
//        http.authorizeRequests()
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers("/", "/index", "/menu/**", "/register", "/login").permitAll()
//                .antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**").permitAll()
//                .antMatchers("/style**").permitAll()
//
//                .antMatchers("/admin/**", "/products/**", "/product-categories/**").hasAnyRole("ADMIN")
//                .antMatchers("/users/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/shoppingCart/checkout").authenticated()
//                .antMatchers("/shoppingCart/**").permitAll()
//                .anyRequest().authenticated();
//
//        http.formLogin().loginPage("/login").permitAll().and()
//                .logout().invalidateHttpSession(true).clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("//login?logout").permitAll();
//    }
//
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(bCryptPasswordEncoder);
        return auth;
    }
    // cu web.ignoring pathurile de mai jos nu mai trec prin spring security context
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/webjars/**");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
