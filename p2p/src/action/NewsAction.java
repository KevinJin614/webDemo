package action;

import java.util.Date;
import java.util.List;

import entity.News;

import service.NewsService;

/**
 * 新闻的Action对象
 * @author 靳雅楠
 *
 */
public class NewsAction extends BaseAction{

	private NewsService newsService;
	private List<News> allNews;
	private News news;
	private Integer newsId;
	
	/*
	 * GET/SET方法
	 */
	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public List<News> getAllNews() {
		return allNews;
	}

	public void setAllNews(List<News> allNews) {
		this.allNews = allNews;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	/*
	 * Action业务方法
	 */
	public String newsIndex() throws Exception {
		allNews = newsService.newsIndex();
		return SUCCESS;
	}
	
	public String firstNews() throws Exception {
		news = newsService.firstNews();
		return SUCCESS;
	}
	
	public String allNewsExceptFirst() throws Exception {
		allNews = newsService.allNewsExceptFirst();
		return SUCCESS;
	}
	
	public String newsManage() throws Exception {
		allNews = newsService.newsManage();
		return SUCCESS;
	}
	
	public String newsAdd() throws Exception {
		news.setCreateAt(new Date());
		newsService.addNews(news);
		return SUCCESS;
	}
	
	public String newsDetail() throws Exception {
		news = newsService.newsDetail(newsId);
//		System.out.println("GBK解码："+new String(news.getNewsTitle().getBytes(),"GBK"));
//		System.out.println("UTF-8解码："+new String(news.getNewsTitle().getBytes(),"UTF-8"));
//		System.out.println("GB2312解码："+new String(news.getNewsTitle().getBytes(),"GB2312"));
//		System.out.println("ISO8859_1解码："+new String(news.getNewsTitle().getBytes(),"ISO8859_1"));
		return SUCCESS;
	}
	
	public String newsModify() throws Exception {
		newsService.newsModify(news);
		return SUCCESS;
	}
	
	public String toNewsModify() throws Exception {
		news = newsService.newsDetail(newsId);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
}
