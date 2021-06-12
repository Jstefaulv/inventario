
package cl.talento.inventario.dao;

import cl.talento.inventario.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDAO extends JpaRepository<Persona,Integer> {
    Persona findByUsername(String username);
}
