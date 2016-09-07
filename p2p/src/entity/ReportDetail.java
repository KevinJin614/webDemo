package entity;

import java.io.Serializable;

/**
 * 产品报表细则实体类
 * @author 靳雅楠
 *
 */
public class ReportDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 
	 select c.companyName,
			p.*,
	 		sum(a.applyNum),
	 		sum(a.applyNum*c.financingInReturn)
	 from company c,product p,apply a
	 where c.companyId=p.company 
	 and a.applyProductId=p.productId
	 and c.companyId=?
	 order by p.productId;
	 */
	private String companyName;
	private Integer year;
	private Product product;
	private Integer financingActual;
	private Integer financingInReturnNum;
	
	
	public ReportDetail() {
		super();
	}


	public ReportDetail(String companyName, Integer year, Product product,
			Integer financingActual, Integer financingInReturnNum) {
		super();
		this.companyName = companyName;
		this.year = year;
		this.product = product;
		this.financingActual = financingActual;
		this.financingInReturnNum = financingInReturnNum;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Integer getFinancingActual() {
		return financingActual;
	}


	public void setFinancingActual(Integer financingActual) {
		this.financingActual = financingActual;
	}


	public Integer getFinancingInReturnNum() {
		return financingInReturnNum;
	}


	public void setFinancingInReturnNum(Integer financingInReturnNum) {
		this.financingInReturnNum = financingInReturnNum;
	}


	


	
	
	
	

}
