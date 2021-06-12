
package cl.talento.inventario.rest;


import cl.talento.inventario.dao.ProductoDAO;
import cl.talento.inventario.dominio.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("productos")
public class ProductoRest {
    
     @Autowired
    private ProductoDAO productoDAO;
    
    @PostMapping("/guardar")//para insertar datos
    public void guardar(@RequestBody Producto producto){
        productoDAO.save(producto);
    }
    
    
    @GetMapping("/listar") // para obtener datos
    public List<Producto> listar(){
        return productoDAO.findAll();
    }
    
    @DeleteMapping("/eliminar/{id}")//para eliminar
    public void eliminar(Producto producto){
        productoDAO.delete(producto);
    }
    
    public Producto buscar(Producto producto){
        listar();
        return productoDAO.findById(producto.getId()).orElse(null);
    }
    
    @PutMapping("/actualizar")//para actualizar
    public void actualizar(@RequestBody Producto producto){
        productoDAO.save(producto);
    }
}
