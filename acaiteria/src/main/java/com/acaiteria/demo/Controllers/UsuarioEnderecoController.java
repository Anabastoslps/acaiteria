package com.acaiteria.demo.Controllers;


import com.acaiteria.demo.Models.Usuario;
import com.acaiteria.demo.Models.UsuarioEndereco;
import com.acaiteria.demo.repositories.UsuarioEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario-endereco")
public class UsuarioEnderecoController {

    @Autowired
    private UsuarioEnderecoRepository usuarioEnderecoRepository;

    @GetMapping
    public List<UsuarioEndereco> getAllUsuarioEndereco() {
        return usuarioEnderecoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEndereco> getUsuarioEnderecoId(@PathVariable Long id) {
        Optional<UsuarioEndereco> optionalusuarioEndereco = usuarioEnderecoRepository.findById(id);
        return optionalusuarioEndereco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<?> createUsuarioEndereco(@RequestBody UsuarioEndereco usuarioEndereco) {
        if (usuarioEndereco.getUsuario() == null || usuarioEndereco.getUsuario().getId() == null) {
            return ResponseEntity.badRequest().body("Usuario must not be null");
        }

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioEndereco.getUsuario().getId());
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Invalid Usuario ID");
        }

        usuarioEndereco.setUsuario(usuarioOptional.get());
        UsuarioEndereco createdUsuarioEndereco = usuarioEnderecoRepository.save(usuarioEndereco);
        return ResponseEntity.ok(createdUsuarioEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEndereco> updateUsuarioEndereco(@PathVariable Long id, @RequestBody UsuarioEndereco usuarioEnderecoDetails) {
        Optional<UsuarioEndereco> optionalUsuarioEndereco = usuarioEnderecoRepository.findById(id);
        if (optionalUsuarioEndereco.isPresent()){
            UsuarioEndereco usuarioEndereco = optionalUsuarioEndereco.get();
            usuarioEndereco.setEndereco(usuarioEnderecoDetails.getEndereco());
            usuarioEndereco.setNumero(usuarioEnderecoDetails.getNumero());
            usuarioEndereco.setBairro(usuarioEnderecoDetails.getBairro());
            usuarioEndereco.setCidade(usuarioEnderecoDetails.getCidade());
            UsuarioEndereco updateusuarioEndereco = usuarioEnderecoRepository.save(usuarioEndereco);
            return ResponseEntity.ok(updateusuarioEndereco);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioEndereco(@PathVariable Long id){
        if (usuarioEnderecoRepository.findById(id).isPresent()) {
            usuarioEnderecoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
