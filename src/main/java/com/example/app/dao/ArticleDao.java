package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Article;

@Mapper
public interface ArticleDao {

	//list-aritcle.html用
	List<Article> selectLimited(
			@Param("offset") int offset,
			@Param("num") int num,
			@Param("loginStatusId") Integer loginStatusId) throws Exception;

	Long countPublic() throws Exception;

	//show-user(PUB)用
	//他のユーザー詳細を閲覧することもあるため"id"追加
	List<Article> selectLimitedByShowUserId(
			@Param("offset") int offset,
			@Param("num") int num,
			@Param("loginStatusId") Integer loginStatusId,
			@Param("id") Integer id) throws Exception;

	Long countPublicByUserId(Integer id) throws Exception;

	//show-user(PRI)用
	List<Article> selectLimitedByUserIdAndPrivate(
			@Param("offset") int offset,
			@Param("num") int num,
			@Param("loginStatusId") Integer loginStatusId) throws Exception;

	Long countPrivateByUserId(Integer id) throws Exception;

	//show-user(LIKED)用
	List<Article> selectLimitedByUserIdAndLiked(
			@Param("offset") int offset,
			@Param("num") int num,
			@Param("loginStatusId") Integer loginStatusId) throws Exception;

	Long countLikedByUserId(Integer id) throws Exception;

	Article selectById(Integer id) throws Exception;

	void insert(Article article) throws Exception;

	void update(Article article) throws Exception;

	void setDeleteById(Integer id) throws Exception;

}
