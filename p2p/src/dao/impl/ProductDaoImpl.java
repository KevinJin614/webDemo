package dao.impl;

import java.util.ArrayList;
import java.util.List;



import dao.ProductDao;
import entity.Product;

/**
 * 产品数据数据访问对象的实现
 * @author 靳雅楠
 *
 */
public class ProductDaoImpl extends GenericDaoImpl<Product, Integer> implements ProductDao{
	
	
	@SuppressWarnings("unchecked")
	public List<Product> selectProduct(
			Integer financingAmountFrom, Integer financingAmountTo,
			Double primeLendingRateFrom, Double primeLendingRateTo,
			Integer productTypeId,Integer lendingPeriodId){
		
		StringBuffer hql = new StringBuffer()
			.append(" from Product p where \t\n");
		List<Object> objs = new ArrayList<Object>();
		
		if(financingAmountFrom != null && financingAmountTo != null) {
			hql.append(" 	p.financingAmountFrom >= ? and p.financingAmountTo <= ? \t\n")
			   .append(" and \t\n");
			objs.add(financingAmountFrom);
			objs.add(financingAmountTo);
		}
		if(primeLendingRateFrom != null && primeLendingRateTo != null) {
			hql.append(" 	p.primeLendingRateFrom >= ? and p.primeLendingRateTo <= ? \t\n")
			   .append(" and \t\n");
			objs.add(primeLendingRateFrom);
			objs.add(primeLendingRateTo);
		}
		if(productTypeId != null) {
			hql.append(" 	p.productType = ( \t\n")
			   .append(" 		select productType \t\n") 
			   .append("			from productType pt \t\n")
			   .append("			where pt.productTypeId = ? \t\n") 
			   .append("		) \t\n")
			   .append(" and \t\n");
			objs.add(productTypeId);
		}
		if(lendingPeriodId != null) {
			hql.append(" 	p.lendingPeriod = ( \t\n")
			   .append("		select period \t\n") 
			   .append(" 			from lendingperiod l \t\n")
			   .append(" 			where l.lendingPeriodId = ? \t\n")
			   .append(" 		) \t\n")
			   .append(" and \t\n");
			objs.add(lendingPeriodId);
		}
		hql.append(" 1=1 \t\n");
		
		System.out.println(hql.toString());
		
		return getHibernateTemplate().find(hql.toString(), objs.toArray());
		
		
//		FROM Product p where
//			  p.financingAmountFrom >= ? and p.financingAmountTo <= ? and
//			  p.primeLendingRateFrom >= ? and p.primeLendingRateTo <= ? and 
//			  p.productType = (  
//					  select productType
//					  from productType pt
//					  where pt.productTypeId = ? 
//			 ) and
//	    where p.lendingPeriod = (
//	    			  select lendingPeriod
//	    			  from lendingPeriod lp
//	    			  wehre lp.lendingPeriodId = ?
//	    ) and 
//		1=1;
		
		
		
//		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class)
//						.add(Restrictions.le("financingAmountTo", financingAmountTo))
//						.add(Restrictions.ge("financingAmountFrom", financingAmountFrom))
//						.add(Restrictions.le("primeLendingRateFrom", primeLendingRateFrom))
//						.add(Restrictions.eq("productTypeId", productTypeId))
//						.add(Restrictions.eq("lendingPeriodId", lendingPeriodId));
//		
//		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByFinancingAmount(
			Integer financingAmountFrom, Integer financingAmountTo) {
		String hql = new StringBuffer()
				.append(" from Product p")
				.append(" 	where p.financingAmountFrom >= ? and ") 
				.append("	p.financingAmountTo <= ?") 
				.toString();
		List<Product> products = getHibernateTemplate()
									.find(hql, new Object[]{financingAmountFrom,financingAmountTo});
		
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByLendingPeriod(Integer lendingPeriodId) {
		String hql = new StringBuffer()
				.append(" from Product p")
				.append(" where p.lendingPeriod = ( ")
				.append("		select period ") 
				.append(" 		from lendingperiod l ")
				.append(" 		where l.lendingPeriodId = ? ")
				.append(" )")
				.toString();
		List<Product> products = getHibernateTemplate().find(hql, lendingPeriodId);
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByPrimeLendingRate(
			Double primeLendingRateFrom, Double primeLendingRateTo) {
		String hql = new StringBuffer()
				.append(" from Product p")
				.append("	where p.primeLendingRateFrom >= ? and ") 
				.append("	p.primeLendingRateTo <= ?")
				.toString();
		List<Product> products = getHibernateTemplate()
									.find(hql,new Object[]{primeLendingRateFrom,primeLendingRateTo});
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByType(Integer productTypeId) {
		String hql = new StringBuffer()
				.append(" from Product p ")
				.append(" where p.productType = ( ")
				.append(" 	select productType ") 
				.append("		from productType pt ")
				.append("		where pt.productTypeId = ? ") 
				.append("	) ")
				.toString();
		List<Product> products = getHibernateTemplate().find(hql, productTypeId);
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByCompanyId(Integer companyId) {
		String hql = new StringBuffer()
				.append(" from Product p ")
				.append(" 	where p.company = ? ")
				.toString();
		List<Product> products = getHibernateTemplate().find(hql, companyId);
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectAllByDate() {
		String hql = new StringBuffer()
				.append(" from Product p ")
				.append(" 	order by p.createTime") 
				.toString();
		return getHibernateTemplate().find(hql);
	}

	@Override
	public void updateProductStatus(Integer productId, String status) {
		String hql = new StringBuffer()
				.append(" update Product p ")
				.append(" 	set p.status = ? ") 
				.append(" 	where p.productId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{status,productId});
	}
	

	@Override
	public List<Product> selectProductBySysuserUserName(String userName) {
		System.out.println("userName:"+userName);
		if("superAdmin".equals(userName)) {
			return selectAllByDate();
		}
		String hql = new StringBuffer()
				.append(" from Product p ")
				.append(" 	where p.linkMan = ? ") 
				.toString();
		List<Product> products = getHibernateTemplate().find(hql, userName);
		System.out.println(products);
		return products;
	}

	@Override
	public void updateProduct(Product product) {
		String hql = new StringBuffer()
				.append(" update Product p ")
				.append(" 	set p.company=?, ") 
				.append(" 		p.productType=?, ") 
				.append("		p.lendingPeriod=?, ") 
				.append(" 		p.productName=?, ") 
				.append(" 		p.primeLendingRateFrom=?, ") 
				.append(" 		p.primeLendingRateTo=?, ") 
				.append(" 		p.financingAmountFrom=?, ") 
				.append(" 		p.financingAmountTo=?, ") 
				.append(" 		p.linkMan=?, ") 
				.append(" 		p.ownedBank=?, ") 
				.append(" 		p.productDescription=? ") 
				.append(" 	where p.productId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{product.getCompany(),
															product.getProductType(),
															product.getLendingPeriod(),
															product.getProductName(),
															product.getPrimeLendingRateFrom(),
															product.getPrimeLendingRateTo(),
															product.getFinancingAmountFrom(),
															product.getFinancingAmountTo(),
															product.getLinkMan(),
															product.getOwnedBank(),
															product.getProductDescription(),
															product.getProductId()});
	}

}




















