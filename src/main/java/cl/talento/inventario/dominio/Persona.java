package cl.talento.inventario.dominio;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String apepat;

    @Column
    private String apemat;

    @Column
    private String rut;

    @Column
    private String cargo;

    @Column
    private String username;

    @Column
    private String password;

    

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "personas_roles",
            joinColumns = {
                @JoinColumn(name = "id_persona")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_rol")}
    )
    private Set<Rol> roles = new HashSet<>();

    
    public Persona(String nombre, String apepat, String apemat,
     String username, String password, String rut, String cargo) {
        this.nombre = nombre;
        this.apepat = apepat;
        this.apemat = apemat;
        this.username = username;
        this.password = password;
        this.rut = rut;
        this.cargo = cargo;
    }
    
    public Persona(String nombre, String apepat, String apemat,
     String username, String password, String rut, String cargo, Set<Rol> roles) {
        this.nombre = nombre;
        this.apepat = apepat;
        this.apemat = apemat;
        this.username = username;
        this.password = password;
        this.rut = rut;
        this.cargo = cargo;
        this.roles = roles;
    }

    public Persona() {

    }

    public void agregarRol(Rol rol) {
        this.roles.add(rol);
    }

    public void quitarRol(Rol rol) {
        this.roles.remove(rol);
    }
  
}
