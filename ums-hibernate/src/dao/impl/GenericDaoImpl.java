package dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import util.HibernateTemplate;

import dao.GenericDao;

public class GenericDaoImpl<E extends Serializable,PK extends Serializable> implements GenericDao<E, PK> {
	protected HibernateTemplate template;
	protected Class<E> entityClass;
	
	public HibernateTemplate getHibernateTemplate(){
		return template;
	}
	
	public GenericDaoImpl() {
		template=new HibernateTemplate();
		entityClass=(Class<E>) ((ParameterizedType)this.getClass()
													   .getGenericSuperclass())
										.getActualTypeArguments()[0];
	}
	
	public void delete(E e) {
		template.delete(e);
	}

	public void deleteById(PK id) {
		template.delete(template.get(entityClass, id));
	}

	public void insert(E e) {
		template.save(e);
	}

	public List<E> selectAll() {
		String hql=new StringBuffer()
			.append("from ").append(entityClass.getSimpleName())
			.toString();
		return template.find(hql);
	}

	public E selectById(PK id) {
		return (E) template.get(entityClass, id);
	}

	public void update(E e) {
		template.update(e);
	}

}
