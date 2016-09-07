package action;


import java.util.List;

import entity.Apply;

import service.ApplyService;

/**
 * 申请Action的对象
 * @author 靳雅楠
 *
 */
public class ApplyAction extends BaseAction {
	
	private ApplyService applyService;
	private Apply apply;
	private Integer productId;
	private List<Apply> applies;
	
	/*
	 * GET/SET 方法
	 */
	public ApplyService getApplyService() {
		return applyService;
	}

	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public List<Apply> getApplies() {
		return applies;
	}

	public void setApplies(List<Apply> applies) {
		this.applies = applies;
	}

	/*
	 * Action业务方法
	 */
	public String applyProduct() throws Exception {
		applyService.applyProduct(apply, productId);
		return SUCCESS;
	}
	
	public String qryApplyByProduct() throws Exception {
		applies = applyService.qryApplyByProduct(productId);
		return SUCCESS;
	}
	
	public String onlineApplyDetail() throws Exception {
		applies = applyService.onlineApplyDetail(productId);
		return SUCCESS;
	}
	 
}















