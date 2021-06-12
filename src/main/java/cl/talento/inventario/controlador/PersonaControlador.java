
package cl.talento.inventario.controlador;

import cl.talento.inventario.dominio.Persona;
import cl.talento.inventario.dominio.Rol;
import cl.talento.inventario.rest.PersonaRest;
import cl.talento.inventario.rest.RolRest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PersonaControlador {
    
    @Autowired
    private PersonaRest personaRest;
    
    @Autowired
    private RolRest rolRest;
    
    //mostrar
    @GetMapping("/registrar")
    public String agregar(Persona persona, Model modelo){
        List<Rol> roles=rolRest.listar();
        modelo.addAttribute("roles",roles);
        modelo.addAttribute("persona",persona);
        return "/registrar";
    }
    
    @PostMapping("/save")
    public String agregar(Persona persona){
        personaRest.guardar(persona);
        
        return "redirect:/";
    }
    
    
    /*
    @GetMapping("/usuarios")
    public String mostrarUsuarios(Model modelo){
    List<Persona> personas = personaRest.findAll();
    modelo.addAttribute("personas",personas);
    return "usuarios";
    */
    
   
}
