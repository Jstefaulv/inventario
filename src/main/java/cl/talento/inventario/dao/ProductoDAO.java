
package cl.talento.inventario.dao;

import cl.talento.inventario.dominio.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Johana
 */
public interface ProductoDAO extends JpaRepository<Producto,Integer>{
    
}
