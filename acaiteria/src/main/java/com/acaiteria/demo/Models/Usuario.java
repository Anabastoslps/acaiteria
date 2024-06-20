package com.acaiteria.demo.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="usuario_tb")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name= "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name="CELULAR", length = 15)
    private String celular;

    @Column(name="SENHA", nullable = false, length = 255)
    private String senha;

    @Column(name="flg_status", nullable = false)
    private Boolean flg_status;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<UsuarioEndereco> endereccos;
    public Usuario(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getflg_status() {
        return flg_status;
    }

    public void setflg_status(Boolean flg_status) {
        this.flg_status = flg_status;
    }


}
