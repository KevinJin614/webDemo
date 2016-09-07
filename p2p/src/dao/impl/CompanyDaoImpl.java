package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import dao.CompanyDao;
import entity.Company;
import entity.Product;
import entity.Report;
import entity.ReportDetail;

/**
 * 银行数据访问对象的实现
 * @author 靳雅楠
 *
 */
public class CompanyDaoImpl extends GenericDaoImpl<Company, Integer> implements CompanyDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Report> selectCompanyReportAll() {
		
		 List<Report> reports = (List<Report>) getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String sql = new StringBuffer()
						.append("select c.*, ")
						.append(" sum(1), ")
						.append(" sum(p.primeLendingRateTo), ")
						.append(" sum(p.primeLendingRateTo), ")
						.append(" sum(a.applyNum), ")
						.append(" sum(a.applyNum*c.financingInReturn) ")
						.append(" 	from company c,product p,apply a ")
						.append(" 	where c.companyId=p.company ")
						.append(" 	and a.applyProductId=p.productId; ")
						.toString();
				List<Report> reports = session.createSQLQuery(sql)
											  .addEntity("c",Company.class)
											  .addEntity(Report.class)
											  .list();
				return reports;
			}
		});
		 
		return reports.size()==0 ? new ArrayList():reports;
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Report> selectCompanyReportByYear(final Integer year) {
		List<Report> reports = (List<Report>) getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String sql = new StringBuffer()
						.append("select c.*, ")
						.append(" sum(1), ")
						.append(" sum(p.primeLendingRateTo), ")
						.append(" sum(p.primeLendingRateTo), ")
						.append(" sum(a.applyNum), ")
						.append(" sum(a.applyNum*c.financingInReturn) ")
						.append(" 	from company c,product p,apply a ")
						.append(" 	where c.companyId=p.company ")
						.append(" 	and a.applyProductId=p.productId ")
						.append(" 	and YEAR(p.createTime)=?;  ") 
						.toString();
				List<Report> reports = session.createSQLQuery(sql)
											  .addEntity("c",Company.class)
											  .addEntity(Report.class)
											  .setInteger(1, year)
											  .list();
				return reports;
			}
		});
		return reports.size()==0 ? new ArrayList():reports;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportDetail> selectCompanyReportDetailByCompanyId(
			final Integer companyId) {
		List<ReportDetail> reportDetails = (List<ReportDetail>) getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String sql = new StringBuffer()
						.append(" select c.companyName, ")
						.append(" p.*, ")
						.append(" YEAR(p.createTime) ")
						.append(" sum(a.applyNum), ")
						.append(" sum(a.applyNum*c.financingInReturn) ")
						.append(" 	from company c,product p,apply a ")
						.append(" 	where c.companyId=p.company  ") 
						.append(" 	where c.companyId=p.company  ") 
						.append(" 	and a.applyProductId=p.productId ")
						.append(" 	and c.companyId=? ") 
						.append("	order by p.productId; ") 
						.toString();
						
				List<ReportDetail> reportDetails = session.createSQLQuery(sql)
														  .addEntity("p",Product.class)
														  .addEntity(ReportDetail.class)
														  .setInteger(1, companyId)
														  .list();
				
		 		
				return reportDetails;
			}
		});
		return reportDetails.size()==0?new ArrayList<ReportDetail>():reportDetails;
	}


	@Override
	public void updateCompanyStatus(Integer companyId, String status) {
		String hql = new StringBuffer()
				.append(" update Company c ") 
				.append(" 	set c.status = ? ") 
				.append("	where c.companyId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{status,companyId});
	}
	

	
	public static void main(String[] args) {
		List<Report> reports = new CompanyDaoImpl().selectCompanyReportAll();
		System.out.println(reports);
	}
	
	
	
	
	
	
	
	
	
	
	
}
