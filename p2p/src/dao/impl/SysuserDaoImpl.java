package dao.impl;

import dao.SysuserDao;
import entity.Sysuser;

/**
 * 管理员数据访问对象的实现
 * @author 靳雅楠
 *
 */
public class SysuserDaoImpl extends GenericDaoImpl<Sysuser, Integer> implements SysuserDao{

	@Override
	public Sysuser selectBySysuser(Sysuser sysuser) {
		System.out.println("loginName:"+sysuser.getLoginName());
		System.out.println("loginPassword:"+sysuser.getLoginPassword());
		String hql = new StringBuffer()
				.append(" from Sysuser s ") 
				.append("	where s.loginName = ? and ") 
				.append("	s.loginPassword = ? ") 
				.toString();
		Sysuser su = (Sysuser) getHibernateTemplate()
								.find(hql, new Object[]{sysuser.getLoginName(),sysuser.getLoginPassword()}).get(0);
		return su;
	}
}
