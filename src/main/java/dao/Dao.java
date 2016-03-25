package dao;

import java.util.List;

public interface Dao<E> {

	public E findById(String id);
	
	public List<E> findAll();
	
	public void save(E e);
	
	public boolean delete(E e);
}
