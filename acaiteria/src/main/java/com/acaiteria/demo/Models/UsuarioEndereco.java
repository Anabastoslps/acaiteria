package com.acaiteria.demo.Models;


import jakarta.persistence.*;

@Entity
@Table(name="usuario_end")
public class UsuarioEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO_ENDERECO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "ENDERECO", nullable = false, length = 255)
    private String endereco;

    @Column(name = "NUMERO", nullable = false, length = 10 )
    private String numero;

    @Column(name= "BAIRRO", nullable = false, length = 100)
    private String bairro;

    @Column(name= "CIDADE", nullable = false, length = 100)
    private  String cidade;

    public UsuarioEndereco(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
