package br.unisales.trabalhoPOO.models;

import javax.persistence.*;

// Entidade que representa um Funcionário
@Entity
@Table(name = "tbfuncionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    @Column(length = 200, nullable = false) // Nome do funcionário
    private String nome;

    @ManyToOne(optional = false) // Relacionamento com Departamento
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
}
