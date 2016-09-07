package service;

import java.util.List;

import entity.News;
/**
 * 新闻服务对象
 * @author 靳雅楠
 *
 */
public interface NewsService {
	
	/**
	 * 首页显示所有新闻（默认按Date排序）
	 * @return 封装了新闻信息的List集合，当新闻不存在时，返回一个空的List集合
	 */
	public List<News> newsIndex();
	
	/**
	 * 最新新闻，从newsIndex中获得第一条新闻
	 * @return 封装了新闻信息的对象
	 */
	public News firstNews();
	
	/**
	 * 除了最新新闻的其他所有新闻，从newsIndex中除去第一条新闻
	 * @return 封装了新闻信息的List集合，当新闻不存在时，返回一个空的List集合
	 */
	public List<News> allNewsExceptFirst();
	
	/**
	 * 新闻管理页面的显示
	 * @return 封装了新闻信息的List集合，当新闻不存在时，返回一个空的List集合
	 */
	public List<News> newsManage();
	
	/**
	 * 添加一条新闻
	 * @param news 封装了新闻信息的对象
	 */
	public void addNews(News news);
	
	/**
	 * 根据newsId查询一条信息详情
	 * @param newsId 新闻id
	 * @return 封装了新闻信息的对象
	 */
	public News newsDetail(Integer newsId);
	
	/**
	 * 根据newsId修改一条新闻
	 * @param news 封装了新闻信息的对象
	 */
	public void newsModify(News news);
	
	
	
	
	
	
	
	
	
	
	
}
