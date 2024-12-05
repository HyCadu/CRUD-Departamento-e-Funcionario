package br.unisales.trabalhoPOO.spec;

import java.util.List;

public interface IDAO<T> {

 public void persist(T o);

 public void delete(T id);

 public void update(T o);

 public T get(Object id);

 public List<T> getAll();
}
