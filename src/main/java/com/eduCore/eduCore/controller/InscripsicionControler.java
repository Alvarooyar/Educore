package com.eduCore.eduCore.controller;

//import de model
import com.eduCore.eduCore.model.Incripcion;

//import de service
import com.eduCore.eduCore.Service.ServiceInscripcion;

//import de clases HTTP
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import anotaciones REST
import org.springframework.web.bind.annotation.*;

//import de lista
import java.util.List;

//va a recibir las petisiones HTTP
@RestController
//ruta de la base de datos
@RequestMapping("api/eduCore")
public class InscripsicionControler {
    //variable
    private final ServiceInscripcion ServiceCon;
    //constructor
    public InscripsicionControler(ServiceInscripcion serviceCon) {
        ServiceCon = serviceCon;
    }
    //get: listar inscripciones
    @GetMapping
    public ResponseEntity<?> listarInscripcion(){
        try{
            List<Incripcion> incripcions = ServiceCon.listaDeElementos();
            return ResponseEntity.ok(incripcions);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error al incribir");
        }
    }
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?>BuscarId (@PathVariable Integer id){
        try{
            Incripcion incripcion = ServiceCon.buscarPorId(id);
            if (incripcion == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("inscripcion no encontrada");
            }
            return ResponseEntity.ok(incripcion);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error al buscar el producto");
        }
    }
    //get guardar los productos
    @PostMapping
    public ResponseEntity<?> guardarProd(@RequestBody Incripcion incripcion) {
        try {
            if (incripcion.getId() == null || incripcion.getNombreEstudiante() == null || incripcion.getCurso() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Todos los campos son obligatorios");
            }

            Incripcion existente = ServiceCon.buscarPorId(incripcion.getId());
            if (existente != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Ya existe una inscripcion con ese id");
            }

            Incripcion nuevoProducto = ServiceCon.guardarElemento(incripcion);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(nuevoProducto);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al inscribir");
        }
    }
    //borrar la inscripcion
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        try {
            if (!ServiceCon.buscarPorId(id).isEstado()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("inscripcion no encontrada");
            }

            ServiceCon.eliminarPorId(id);

            return ResponseEntity.ok("inscripcion eliminada correctamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la inscripcion");
        }
    }
}
