package ro.sda.javaro35.finalProject.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import ro.sda.javaro35.finalProject.service.user.appuser.AppUser;
import ro.sda.javaro35.finalProject.service.user.appuser.AppUserRepository;
import ro.sda.javaro35.finalProject.service.user.appuser.AppUserService;
import ro.sda.javaro35.finalProject.service.user.appuser.registration.token.ConfirmationToken;
import ro.sda.javaro35.finalProject.service.user.appuser.registration.token.ConfirmationTokenRepository;
import ro.sda.javaro35.finalProject.service.user.appuser.registration.token.ConfirmationTokenService;


@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public AppUserService beanAppUserService() {
        AppUserRepository appUserRepository = new AppUserRepository() {
            @Override
            public Optional<AppUser> findByEmail(String email) {
                return Optional.empty();
            }

            @Override
            public int enableAppUser(String email) {
                return 0;
            }

            @Override
            public AppUser authenticate(String email) {
                return null;
            }

            @Override
            public List<AppUser> findAll() {
                return null;
            }

            @Override
            public List<AppUser> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<AppUser> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends AppUser> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends AppUser> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends AppUser> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<AppUser> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public AppUser getOne(Long aLong) {
                return null;
            }

            @Override
            public AppUser getById(Long aLong) {
                return null;
            }

            @Override
            public AppUser getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends AppUser> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends AppUser> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<AppUser> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends AppUser> S save(S entity) {
                return null;
            }

            @Override
            public Optional<AppUser> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(AppUser entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends AppUser> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends AppUser> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends AppUser> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends AppUser> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends AppUser> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends AppUser, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        return new AppUserService(appUserRepository, bCryptPasswordEncoder, new ConfirmationTokenService(new ConfirmationTokenRepository() {
            @Override
            public Optional<ConfirmationToken> findByToken(String token) {
                return Optional.empty();
            }

            @Override
            public int updateConfirmedAt(String token, LocalDateTime confirmedAt) {
                return 0;
            }

            @Override
            public List<ConfirmationToken> findAll() {
                return null;
            }

            @Override
            public List<ConfirmationToken> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<ConfirmationToken> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends ConfirmationToken> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends ConfirmationToken> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends ConfirmationToken> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<ConfirmationToken> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public ConfirmationToken getOne(Long aLong) {
                return null;
            }

            @Override
            public ConfirmationToken getById(Long aLong) {
                return null;
            }

            @Override
            public ConfirmationToken getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends ConfirmationToken> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends ConfirmationToken> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<ConfirmationToken> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends ConfirmationToken> S save(S entity) {
                return null;
            }

            @Override
            public Optional<ConfirmationToken> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(ConfirmationToken entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends ConfirmationToken> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends ConfirmationToken> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends ConfirmationToken> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends ConfirmationToken> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends ConfirmationToken> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends ConfirmationToken, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        }));
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v*/register/**").permitAll()
                .antMatchers("/api/v*/login/**").permitAll()
                .antMatchers("/api/v*/login").permitAll()

                .antMatchers("/addresses/*").permitAll()
                .antMatchers("/addresses/**").permitAll()

                .antMatchers("/airports/*").permitAll()
                .antMatchers("/airports/**").permitAll()

                .antMatchers("/aircrafts/*").permitAll()
                .antMatchers("/aircrafts/**").permitAll()

                .antMatchers("/flights/*").permitAll()
                .antMatchers("/flights/**").permitAll()


                .antMatchers("/tickets/*").permitAll()
                .antMatchers("/tickets/**").permitAll()

                .antMatchers("/users/*").permitAll()
                .antMatchers("/users/**").permitAll()

                .anyRequest()
                .authenticated().and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }




    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSender() {
            @Override
            public void send(SimpleMailMessage simpleMessage) throws MailException {

            }

            @Override
            public void send(SimpleMailMessage... simpleMessages) throws MailException {

            }

            @Override
            public MimeMessage createMimeMessage() {
                return null;
            }

            @Override
            public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
                return null;
            }

            @Override
            public void send(MimeMessage mimeMessage) throws MailException {

            }

            @Override
            public void send(MimeMessage... mimeMessages) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

            }
        };
    }


}


//    @Bean
//    public org.springframework.web.filter.CorsFilter corsFilter() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
//                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
//        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
//                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }
