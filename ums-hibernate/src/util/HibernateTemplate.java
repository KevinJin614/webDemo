package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import exception.DataAccessException;

public class HibernateTemplate {
	public void save(Object entity){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}
	}
	
	public void delete(Object entity){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}
	}
	
	public void update(Object entity){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.update(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}
	}
	
	public Object get(Class entityClass,Serializable id){
		Session session=null;
		Object entity=null;
		try {
			session=HibernateUtil.getSession();
			entity=session.get(entityClass, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}
		return entity;
	}
	
	public List find(String hql,Object... params){
		Session session=null;
		List list=new ArrayList();
		try {
			session=HibernateUtil.getSession();
			
			Query query=session.createQuery(hql);
			for (int i = 0; i < params.length; i++) {
				setParam(i, params[i], query);
			}
			list=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}
		return list;
	}
	
	public List find(String hql,String[] paramNames,Object... params){
		Session session=null;
		List list=new ArrayList();
		try {
			session=HibernateUtil.getSession();
			
			Query query=session.createQuery(hql);
			for (int i = 0; i < params.length; i++) {
				setParam(paramNames[i], params[i], query);
			}
			list=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}
		return list;
	}
	
	
	
	
	
	public void setParam(int index,Object param,Query query){
		if(param instanceof String){
			query.setString(index, (String)param);
		}else if(param instanceof Date){
			query.setDate(index, (Date)param);
		}else{
			query.setParameter(index, param);
		}
		
	}
	
	public void setParam(String paramName,Object param,Query query){
		if(param instanceof String){
			query.setString(paramName, (String)param);
		}else if(param instanceof Date){
			query.setDate(paramName, (Date)param);
		}else{
			query.setParameter(paramName, param);
		}
		
	}
	
	
	
}
