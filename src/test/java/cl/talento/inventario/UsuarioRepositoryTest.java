
package cl.talento.inventario;

import cl.talento.inventario.dao.PersonaDAO;
import cl.talento.inventario.dominio.Rol;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {
    
    @Autowired
     private PersonaDAO usuarioRepo;
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Test
    public void test(){
        
    }
   /*
   @Test
    public void testCrearRoles(){
        Rol admin = new Rol("ROLE_ADMIN");
        Rol user = new Rol("ROLE_USER");
        Rol guess = new Rol("ROLE_GUESS");
        
        entityManager.persist(admin);
        entityManager.persist(user);
        entityManager.persist(guess);  
    }
    */
    public static String encriptarClave(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
    
    /*@Test
    public void testCrearUsuarioConRol(){
        Rol admin = entityManager.find(Rol.class,1);
        String pass="123456";
        Persona p = new Persona("Administrador","","","admin",encriptarClave(pass),"111111-1","Administrador");
        p.agregarRol(admin);
        usuarioRepo.save(p);
        
    }*/
    
   /* @Test
    public void testCrearUsuarioConDosRoles(){
        Rol admin = entityManager.find(Rol.class,1);
        Rol user = entityManager.find(Rol.class, 2);
        String pass="123456";
        Persona p = new Persona("Johana","Estefo","Vargas","jestefo",encriptarClave(pass),"111111-1","Administrador");
        p.agregarRol(admin);
        p.agregarRol(user);
        usuarioRepo.save(p);   
    }*/
    
   /* @Test
    public void asignarRolAUsuarioExistente(){
        Persona p = usuarioRepo.findById(1).get();
        Rol user = entityManager.find(Rol.class, 2);
        p.agregarRol(user);
    }*/
    
    /*@Test
    public void quitarRol(){
        Persona p = usuarioRepo.findById(1).get();
        Rol rol = new Rol(2);
        p.quitarRol(rol);
    }*/
}
