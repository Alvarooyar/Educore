package com.eduCore.eduCore.repository;
//import de la clase modelo *inscripcione
import com.eduCore.eduCore.model.Incripcion;
//import JPA Repository
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryInscripsion extends JpaRepository<Incripcion,Integer> {

}