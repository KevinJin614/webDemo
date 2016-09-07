package dao.impl;

import java.util.List;

import dao.NewsDao;
import entity.News;

public class NewsDaoImpl extends GenericDaoImpl<News, Integer> implements NewsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<News> selectAllByDate() {
		String hql = new StringBuffer()
				.append(" from News n ")
				.append(" 	order by n.createAt ") 
				.toString();
		
		return getHibernateTemplate().find(hql);
	}

	@Override
	public void updateNewsStatus(Integer newsId, String status) {
		String hql = new StringBuffer()
				.append(" update News n ")
				.append(" 	set n.status = ? ") 
				.append(" 	where n.newsId = ? ")
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{status,newsId});
	}


}
