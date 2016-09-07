package dao.impl;

import java.util.List;


import dao.ApplyDao;
import entity.Apply;

/**
 * 申请访问对象的实现
 * @author 靳雅楠
 *
 */
public class ApplyDaoImpl extends GenericDaoImpl<Apply, Integer> implements ApplyDao  {


	@SuppressWarnings("unchecked")
	@Override
	public Apply selectByApply(Apply apply) {
		String hql = new StringBuffer()
				.append(" from Apply a ")
				.append("	where a.applyPerson = ? and ") 
				.append("	a.applyPersonIDCard = ? and ") 
				.append("	a.applyNum = ? and ") 
				.append("	a.applyProductName = ? and ") 
				.append("	a.applyProductId = ? ") 
				.toString();
		Object[] objs = new Object[]{apply.getApplyPerson(),apply.getApplyPersonIdcard(),apply.getApplyNum(),
									 apply.getProduct().getProductName(),apply.getProduct().getProductId()};
		List<Apply> applies = getHibernateTemplate().find(hql, objs);
		return applies.size() != 0 ? applies.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Apply> selectApplyByProductId(Integer productId) {
		String hql = new StringBuffer()
				.append(" from Apply a ")
				.append(" 	where a.product.productId = ? ") 
				.toString();
		return getHibernateTemplate().find(hql,productId);
	}

	@Override
	public void updateApplyStatus(Integer applyId, String status) {
		String hql = new StringBuffer()
				.append(" update Apply a  ")
				.append(" 	where a.applyId = ? ") 
				.append(" 	set a.status = ? ")
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{applyId,status});
	}

}
