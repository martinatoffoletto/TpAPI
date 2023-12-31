package com.example.demo.service;

import com.example.demo.model.entity.Edificio;
import com.example.demo.model.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public Usuario findById(Long id);

    public Usuario findByUsuario(String nombreUser, String contra);

    public List<Usuario> findAdmins();
    public void save(Usuario usuario);

    public void update(Long usuarioId, Usuario usuario);

    public void deleteById(Long id);
}
