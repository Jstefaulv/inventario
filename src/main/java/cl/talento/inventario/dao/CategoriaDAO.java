
package cl.talento.inventario.dao;

import cl.talento.inventario.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Johana
 */
public interface CategoriaDAO extends JpaRepository<Categoria,Integer>{
    
}
