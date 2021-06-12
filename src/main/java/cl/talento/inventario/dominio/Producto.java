package cl.talento.inventario.dominio;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Johana
 */
@Data
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String nombre;
    
    @Column
    private double precio;
    
    @Column
    private String codigoProducto;
    
    @ManyToOne
    @JoinColumn(name="id_categorias")
    private Categoria categoria;    
}
