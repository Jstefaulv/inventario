
package cl.talento.inventario.dominio;

//import java.util.Set;
import javax.persistence.*;
import lombok.Data;


/**
 *
 * @author Johana
 */

@Data
@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String nombre;
    
}
