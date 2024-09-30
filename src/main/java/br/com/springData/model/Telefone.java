package br.com.springData.model;

import jakarta.persistence.*;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false) //torna obrigatório
    private String numero;

    private String tipo;

    @ManyToOne(optional = false)
    private UsuarioSpringData usuario;

    public UsuarioSpringData getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSpringData usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
