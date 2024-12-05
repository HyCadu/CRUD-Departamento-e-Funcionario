package br.unisales.trabalhoPOO.models;

import javax.persistence.*;
import java.util.List;

// Entidade que representa um Departamento
@Entity
@Table(name = "tbdepartamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    @Column(length = 200, nullable = false) // Nome do departamento
    private String nome;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL) // Relacionamento com funcionários
    private List<Funcionario> funcionarios;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Funcionario> getFuncionarios() { return funcionarios; }
    public void setFuncionarios(List<Funcionario> funcionarios) { this.funcionarios = funcionarios; }

    @Override
    public String toString() {
        return nome;
    }
}
