
package cl.talento.inventario.controlador;

import cl.talento.inventario.dominio.Categoria;
import cl.talento.inventario.dominio.Producto;
import cl.talento.inventario.rest.CategoriaRest;
import cl.talento.inventario.rest.ProductoRest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ProductoControlador {
    
    @Autowired
    private ProductoRest productoRest;
    
    @Autowired
    private CategoriaRest categoriaRest;
    
    @GetMapping("/")
    public String inicio(Model modelo, @AuthenticationPrincipal User user){
        String url="";
        String rol=user.getAuthorities().toString();
        if (rol.contains("ADMIN")) {
            url = "/index";
            var productos = productoRest.listar();
            modelo.addAttribute("productos", productos);
    }
        return url;
}
    
    @GetMapping("/agregar")
    public String agregar(Producto producto, Model modelo){
        List<Categoria> categorias=categoriaRest.listar();
        modelo.addAttribute("producto",producto);
        modelo.addAttribute("categorias",categorias);
        return "agregar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Producto producto){
        productoRest.guardar(producto);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
	public String editar(Producto producto, Model model) {
         List<Categoria> categorias=categoriaRest.listar();
	producto = productoRest.buscar(producto);
	model.addAttribute("producto",producto);
        model.addAttribute("categorias",categorias);
	return "agregar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(Producto producto){
        producto = productoRest.buscar(producto);
        productoRest.eliminar(producto);
        return "redirect:/";
    }
    
   
    
}
