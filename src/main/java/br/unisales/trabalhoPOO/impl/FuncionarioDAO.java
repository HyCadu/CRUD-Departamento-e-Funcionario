package br.unisales.trabalhoPOO.impl;

import javax.persistence.EntityManager;

import br.unisales.trabalhoPOO.models.Funcionario;
import br.unisales.trabalhoPOO.persistence.ConnectionFactory;
import br.unisales.trabalhoPOO.spec.IDAO;

import java.util.List;

// Classe DAO para gerenciar a persistência da entidade Funcionario
public class FuncionarioDAO implements IDAO<Funcionario> {

    // Recupera o EntityManager da fábrica de conexões
    private final EntityManager em = ConnectionFactory.em;

    // Método para persistir um novo Funcionario no banco de dados
    @Override
    public void persist(Funcionario f) {
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }

    // Método para excluir um Funcionario
    @Override
    public void delete(Funcionario f) {
        em.getTransaction().begin();
        em.remove(em.contains(f) ? f : em.merge(f));
        em.getTransaction().commit();
    }

    // Método para atualizar um Funcionario existente
    @Override
    public void update(Funcionario f) {
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }

    // Busca um Funcionario pelo ID
    @Override
    public Funcionario get(Object id) {
        return em.find(Funcionario.class, id);
    }

    // Recupera todos os Funcionarios
    @Override
    public List<Funcionario> getAll() {
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
    }
}
