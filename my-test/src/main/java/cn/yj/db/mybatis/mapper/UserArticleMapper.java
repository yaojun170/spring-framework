package cn.yj.db.mybatis.mapper;

import cn.yj.db.jdbc2.po.UserArticle;

/**
 * @Description
 * @Author yaojun
 * @Date 2021-12-08
 */
public interface UserArticleMapper {
	UserArticle queryArticleByUserId(Integer userId);

	void addArticle(UserArticle userArticle);
}
