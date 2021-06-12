
package cl.talento.inventario.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) 
            throws Exception{
        //voy a crear usuarios en memoria para probar 
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123456")
                //noop - dice que no es necesario
                //encriptar la contraseña.
                .roles("ADMIN","USER","GUESS")
                .and()
                .withUser("usuario")
                .password("{noop}123456")
                .roles("USER")
                .and()
                .withUser("invitado")
                .password("{noop}123456")
                .roles("GUESS")
                ;
    }*/
    
    @Autowired
    private UserDetailsService userDetailsService;
	
    @Bean
    public BCryptPasswordEncoder encriptarClave() {
        return new BCryptPasswordEncoder();
    }
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).
        passwordEncoder(encriptarClave());
    }
    
    @Override
    protected void configure(HttpSecurity http) 
            throws Exception{
        http.authorizeRequests()
                /**
                 * cualquier cosa que sea igual en terminos
                 * de nombre, lo reconocerá como
                 * ruta de la app.
                 */
                .antMatchers("/actualizar/**","/guardar/**","/eliminar")
                /**
                 * cuando ponemos doble asterisco
                 * dice que cualquier cosa
                 * que esté dentro de ese path
                 * no permitirá que ingrese a esa ruta
                 */
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER","ADMIN","GUESS")
                .and()
                .formLogin()
                        .loginPage("/login")
                .and()
                //.exceptionHandling().accessDeniedPage("/errores/403")
                .exceptionHandling().accessDeniedPage("/login")
                ;
    }
}
