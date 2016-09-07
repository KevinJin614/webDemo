package entity;

import java.util.Date;

/**
 * Apply entity. @author MyEclipse Persistence Tools
 */

public class Apply implements java.io.Serializable {
	/**
	 * passed
	 */
	public static final String STATUS_PASS = "P";
	/**
	 * refused
	 */
	public static final String STATUS_REFUSE = "R";
	/**
	 * wait to pass ; Default
	 */
	public static final String STATUS_WAIT = "W";
	/**
	 * Deleted
	 */
	public static final String STATUS_DELETED = "D";
	// Fields
	/**
	 * 申请id
	 */
	private Integer applyId;
	/**
	 * 该申请所属产品
	 */
	private Product product;
	/**
	 * 申请人的姓名
	 */
	private String applyPerson;
	/**
	 * 申请人的身份证号
	 */
	private String applyPersonIdcard;
	/**
	 * 申请数量
	 */
	private Integer applyNum;
	/**
	 * 申请时间
	 */
	private Date applyDate;
	/**
	 * 申请所属产品名
	 */
	private String applyProductName;
	/**
	 * 申请的状态
	 */
	private String status;

	// Constructors

	/** default constructor */
	public Apply() {
	}

	/** full constructor */
	public Apply(Product product, String applyPerson, String applyPersonIdcard,
			Integer applyNum, Date applyDate, String applyProductName,String status) {
		this.product = product;
		this.applyPerson = applyPerson;
		this.applyPersonIdcard = applyPersonIdcard;
		this.applyNum = applyNum;
		this.applyDate = applyDate;
		this.applyProductName = applyProductName;
		this.status = status;
	}

	// Property accessors

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getApplyId() {
		return this.applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getApplyPerson() {
		return this.applyPerson;
	}

	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}

	public String getApplyPersonIdcard() {
		return this.applyPersonIdcard;
	}

	public void setApplyPersonIdcard(String applyPersonIdcard) {
		this.applyPersonIdcard = applyPersonIdcard;
	}

	public Integer getApplyNum() {
		return this.applyNum;
	}

	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}

	public Date getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getApplyProductName() {
		return this.applyProductName;
	}

	public void setApplyProductName(String applyProductName) {
		this.applyProductName = applyProductName;
	}

}