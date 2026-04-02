package com.eduCore.eduCore.Service;
//import de la clase modelo
import com.eduCore.eduCore.model.Incripcion;

//import de la clase repository
import com.eduCore.eduCore.repository.RepositoryInscripsion;

//import del service
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//import de listas (opcional)
import java.util.List;
import java.util.Optional;

@Service
public class ServiceInscripcion {
    //variable para usar el repository
    private final RepositoryInscripsion repositoryInscripsion;
    //constructor
    public ServiceInscripcion(RepositoryInscripsion repositoryInscripsion) {
        this.repositoryInscripsion = repositoryInscripsion;
    }
    //guardar elemento
    public Incripcion guardarElemento(Incripcion incripcion){
        return repositoryInscripsion.save(incripcion);
    }
    //buscar por id
    public Incripcion buscarPorId(Integer id) {
        Optional<Incripcion> producto = repositoryInscripsion.findById(id);

        //7  Si existe, lo devuelve; si no, devuelve null
        return producto.orElse(null);
    }
    //listar todos los elementos
    public List<Incripcion>listaDeElementos(){
        return repositoryInscripsion.findAll();
    }
    //actualizar datos del elemento
    public Incripcion actualizarElemento(Integer id, Incripcion nuevosDatos) {
        return repositoryInscripsion.findById(id).map(inscripcion -> {
                    return repositoryInscripsion.save(inscripcion);
                }).orElse(null); // O lanzar una excepción
    }
    //eliminar el elemento
    public void eliminarPorId(Integer id){
        repositoryInscripsion.deleteById(id);
    }


}
