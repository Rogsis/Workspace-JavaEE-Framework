package fr.eni.jpa.dao;

import java.util.List;

public interface GenericDao<T> {

	void save(T entity);
	T get (Class<T> t,Object id);
	List<T> list(Class<T> t);
	void update(T entity);
	void delete(T entity);
}
