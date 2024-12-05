package br.unisales.trabalhoPOO.impl;

import javax.persistence.EntityManager;

import br.unisales.trabalhoPOO.models.Departamento;
import br.unisales.trabalhoPOO.persistence.ConnectionFactory;
import br.unisales.trabalhoPOO.spec.IDAO;

import java.util.List;

// Classe DAO para gerenciar a persistência da entidade Departamento
public class DepartamentoDAO implements IDAO<Departamento> {

    // Recupera o EntityManager da fábrica de conexões
    private final EntityManager em = ConnectionFactory.em;

    // Método para persistir um novo Departamento no banco de dados
    @Override
    public void persist(Departamento d) {
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
    }

    // Método para excluir um Departamento
    @Override
    public void delete(Departamento d) {
        em.getTransaction().begin();
        em.remove(em.contains(d) ? d : em.merge(d));
        em.getTransaction().commit();
    }

    // Método para atualizar um Departamento existente
    @Override
    public void update(Departamento d) {
        em.getTransaction().begin();
        em.merge(d);
        em.getTransaction().commit();
    }

    // Busca um Departamento pelo ID
    @Override
    public Departamento get(Object id) {
        return em.find(Departamento.class, id);
    }

    // Recupera todos os Departamentos
    @Override
    public List<Departamento> getAll() {
        return em.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList();
    }
}
