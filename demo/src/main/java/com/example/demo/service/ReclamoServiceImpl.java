package com.example.demo.service;

import com.example.demo.model.dao.ReclamoDAOImpl;
import com.example.demo.model.entity.AreaComun;
import com.example.demo.model.entity.EstadoReclamo;
import com.example.demo.model.entity.Foto;
import com.example.demo.model.entity.Reclamo;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Collections;
@Service
public class ReclamoServiceImpl implements IReclamoService{
    private ReclamoDAOImpl reclamoDAO;

    @Override
    public List<Reclamo> findAll() {
        List<Reclamo> reclamos = Collections.singletonList((Reclamo) reclamoDAO.gelAll());
        return reclamos;
    }

    public Reclamo findById(Long id){
        Reclamo reclamo = (Reclamo) reclamoDAO.findById(id);
        return reclamo;
    }


    public void save(Reclamo reclamo) {
        reclamoDAO.save(reclamo);
    }

    @Override
    public void update(Long reclamoId, Reclamo reclamo) {
        Reclamo reclamoExistente = (Reclamo) reclamoDAO.findById(reclamoId);

        if (reclamoExistente != null){
            reclamoExistente.setDescripcion(reclamo.getDescripcion());
            reclamoExistente.setEstado(reclamo.getEstado());
            reclamoExistente.setUnidad(reclamo.getUnidad());
            reclamoExistente.setFoto(reclamo.getFoto());

            reclamoDAO.save(reclamoExistente);
        }
    }

    @Override
    public void deleteById(Long id)  {
        reclamoDAO.delete(id);
    }

    @Override
    public List<Reclamo> findPorEdificio(Long idEdificio) {
        return Collections.singletonList((Reclamo) reclamoDAO.findByEdificio(idEdificio));
    }

    @Override
    public List<Reclamo> findPorUsuario(String nombreUsuario) {
        return Collections.singletonList((Reclamo) reclamoDAO.findByUsuario(nombreUsuario));
    }


}
