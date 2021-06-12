
package cl.talento.inventario.dao;

import cl.talento.inventario.dominio.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDAO extends JpaRepository<Rol,Integer>{
    
}
