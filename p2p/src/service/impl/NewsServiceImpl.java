package service.impl;

import java.util.List;

import dao.NewsDao;

import entity.News;
import service.NewsService;
/**
 * 新闻服务对象的实现
 * @author 靳雅楠
 *
 */
public class NewsServiceImpl implements NewsService {

	private NewsDao nd;
	
	public NewsDao getNd() {
		return nd;
	}

	public void setNd(NewsDao nd) {
		this.nd = nd;
	}

	@Override
	public void addNews(News news) {
		nd.insert(news);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> allNewsExceptFirst() {
		return (List<News>) newsIndex().remove(0);
	}

	@Override
	public News firstNews() {
		return newsIndex().get(0);
	}

	@Override
	public News newsDetail(Integer newsId) {
		return nd.selectById(newsId);
	}

	@Override
	public List<News> newsIndex() {
		return nd.selectAll();
	}

	@Override
	public List<News> newsManage() {
		return nd.selectAll();
	}

	@Override
	public void newsModify(News news) {
		nd.update(news);
	}


}
