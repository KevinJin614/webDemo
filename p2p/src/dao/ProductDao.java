package dao;

import java.util.List;

import entity.Product;

/**
 * 产品的数据访问对象
 * @author 靳雅楠
 *
 */
public interface ProductDao extends GenericDao<Product, Integer> {
	
	
	/**
	 * 根据产品类型id查询所有的产品
	 * @param productTypeId 产品类型id
	 * @return 封装了所有产品的集合，如果未查询到返回一个空的集合
	 */
	public List<Product> selectProductByType(Integer productTypeId);
	
	/**
	 * 根据产品贷款周期查询所有的产品信息
	 * @param lendingPeriodId 贷款周期id
	 * @return 封装了所有产品的集合，如果未查询到返回一个空的集合
	 */
	public List<Product> selectProductByLendingPeriod(Integer lendingPeriodId);
	
	/**
	 * 根据产品贷款利率范围查询所有的产品信息
	 * @param primeLendingRateFrom 贷款利率的最低值
	 * @param primeLendingRateTo 贷款利率的最高值
	 * @return 封装了所有产品的集合，如果未查询到返回一个空的集合
	 */
	public List<Product> selectProductByPrimeLendingRate(Double primeLendingRateFrom,Double primeLendingRateTo);
	
	/**
	 * 根据产品贷款规模范围查询所有的产品信息
	 * @param financingAmountFrom 贷款规模的最低值
	 * @param financingAmountTo 贷款规模的最高值
	 * @return 封装了所有产品的集合，如果未查询到返回一个空的集合
	 */
	public List<Product> selectProductByFinancingAmount(Integer financingAmountFrom,Integer financingAmountTo);

	/**
	 * 根据银行id查询该银行下的所有产品信息
	 * @param companyId 银行id
	 * @return 封装了产品信息的对象，如果未查询到返回空的集合
	 */
	public List<Product> selectProductByCompanyId(Integer companyId);
	
	/**
	 * 根据productId修改该产品的状态
	 * @param productId 产品id
	 * @param status 要修改成的状态
	 */
	public void updateProductStatus(Integer productId,String status);
	
	/**
	 * 根据productId修改产品
	 * @param product 产品id
	 */
	public void updateProduct(Product product);
	
	/**
	 * 查询所有的产品，按Date排序
	 * @return 封装了产品信息的对象，如果未查询到返回空的集合
	 */
	public List<Product> selectAllByDate();
	
	/**
	 * 根据管理员的useName查询他所属的产品
	 * @param userName 管理员的userName
	 * @return 封装了产品信息的对象，如果未查询到返回空的集合
	 */
	public List<Product> selectProductBySysuserUserName(String userName);
	
}
























