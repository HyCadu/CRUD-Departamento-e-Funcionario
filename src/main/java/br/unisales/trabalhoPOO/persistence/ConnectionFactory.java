package br.unisales.trabalhoPOO.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

 public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
 public static final EntityManager em = emf.createEntityManager();
}
