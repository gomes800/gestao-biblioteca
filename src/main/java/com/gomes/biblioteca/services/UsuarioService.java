package com.gomes.biblioteca.services;

import com.gomes.biblioteca.model.User;
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

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User registrarUsuario(User user) {
        user.setTipo(TipoUsuario.CLIENTE);
        return repository.save(user);
    }

    public User buscarPorUsuario(String nomeUsuario) {
        return repository.findByNomeUsuario(nomeUsuario).orElse(null);
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

    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setUsername(obj.getUsername());
        entity.setEmail(obj.getEmail());
    }
}
