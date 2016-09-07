package service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDao;

import entity.Product;
import service.ProductService;

/**
 * 产品的业务处理对象的实现
 * @author 靳雅楠
 *
 */
@Transactional(propagation=Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService{

	private ProductDao pd;
	
	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	@Override
	public List<Product> qryProductAll() {
		return pd.selectAll();
	}

	@Override
	public List<Product> qryProductByFinancingAmount(
			Integer financingAmountFrom, Integer financingAmountTo) {
		
		
		return pd.selectProductByFinancingAmount(financingAmountFrom, financingAmountTo);
	}

	@Override
	public Product qryProductById(Integer productId) {
		
		return pd.selectById(productId);
	}

	@Override
	public List<Product> qryProductByLendingPeriod(Integer lendingPeriodId) {
		
		
		return pd.selectProductByLendingPeriod(lendingPeriodId);
	}

	@Override
	public List<Product> qryProductByPrimeLendingRate(
			Double primeLendingRateFrom, Double primeLendingRateTo) {
		
		
		return pd.selectProductByPrimeLendingRate(primeLendingRateFrom, primeLendingRateTo);
	}

	@Override
	public List<Product> qryProductByType(Integer productTypeId) {
		
		
		return pd.selectProductByType(productTypeId);
	}

	@Override
	public void addProduct(Product product) {
		pd.insert(product);
	}

	@Override
	public List<Product> index() {
		return qryProductAll();
	}

	@Override
	public List<Product> onlineApply() {
		return qryProductAll();
	}

	@Override
	public Product productDetail(Integer productId) {
		return qryProductById(productId);
	}

	@Override
	public Product productIndex(Integer productId) {
		return qryProductById(productId);
	}

	@Override
	public List<Product> productManager(String userName) {
		return pd.selectProductBySysuserUserName(userName);
	}

	@Override
	public void productModify(Product product) {
		pd.updateProduct(product);
	}

}
