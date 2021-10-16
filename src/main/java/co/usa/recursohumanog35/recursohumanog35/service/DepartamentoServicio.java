package co.usa.recursohumanog35.recursohumanog35.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursohumanog35.recursohumanog35.repository.DepartamentoRepositorio;

import java.util.List;
import java.util.Optional;



import co.usa.recursohumanog35.recursohumanog35.model.Departamento;

@Service
public class DepartamentoServicio {

    @Autowired
    DepartamentoRepositorio departamentoRepositorio;

    public List<Departamento> getAll(){
        return departamentoRepositorio.getAll();
    }
    public Optional<Departamento> getDepartamento(int id){

    return departamentoRepositorio.getDepartamento(id);       
    }

    public Departamento save(Departamento dpto){
        //verifico si id es nulo
        if(dpto.getNumId()==null){
            return departamentoRepositorio.save(dpto);

        }else{//verifico si existe el id o no en la base de datos
            Optional<Departamento> consulta=departamentoRepositorio.getDepartamento(dpto.getNumId());
            if(consulta.isEmpty()){
                return departamentoRepositorio.save(dpto);
            }else{
                return dpto;
            }
        }

    }


    
}
