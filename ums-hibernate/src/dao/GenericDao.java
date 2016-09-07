package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E extends Serializable,PK extends Serializable> {
	public void insert(E e);
	public void delete(E e);
	public void deleteById(PK id);
	public void update(E e);
	public E selectById(PK id);
	public List<E> selectAll();
}
