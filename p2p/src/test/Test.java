package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.NewsService;
import service.ProductService;

import action.NewsAction;
import action.ProductAction;

import dao.ApplyDao;
import dao.CompanyDao;
import dao.NewsDao;
import dao.ProductDao;
import entity.Apply;
import entity.Company;
import entity.News;
import entity.Product;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
		/*
		ApplyDao ad = (ApplyDao) ac.getBean("applyDao"); 
		ProductDao pd = (ProductDao) ac.getBean("productDao");
		CompanyDao cd = (CompanyDao) ac.getBean("companyDao");
		
		List<Product> products = pd.selectAll();
		List<Apply> applies = ad.selectAll();
		List<Company> companies = cd.selectAll();
		
		System.out.println(products);
		System.out.println(applies);
		System.out.println(companies);*/
		
		NewsDao nd = (NewsDao) ac.getBean("newsDao");
		News news = nd.selectById(1);
		System.out.println(news.getNewsTitle());
	}
	
	
}
