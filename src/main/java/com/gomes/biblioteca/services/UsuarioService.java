package com.gomes.biblioteca.services;

import com.gomes.biblioteca.model.Usuario;
import com.gomes.biblioteca.model.enums.TipoUsuario;
import com.gomes.biblioteca.repositories.UsuarioRepository;
import com.gomes.biblioteca.services.exceptions.DatabaseException;
import com.gomes.biblioteca.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }


    public void delete(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Usuario update(Long id, Usuario obj) {
        try {
            Usuario entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setNomeUsuario(obj.getNomeUsuario());
        entity.setEmail(obj.getEmail());
    }
}
