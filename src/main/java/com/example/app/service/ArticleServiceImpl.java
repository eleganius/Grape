package com.example.app.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dao.ArticleDao;
import com.example.app.domain.Article;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleDao articleDao;

	@Override
	public List<Article> getArticleListByPage(int page,
			int numPerPage, Integer loginStatusId) throws Exception {
		int offset = numPerPage * (page - 1);
		return articleDao.selectLimited(offset, numPerPage, loginStatusId);
	}

	@Override
	public List<Article> getArticleListByPageAndShowUserId(int page,
			int numPerPage, Integer loginStatusId, Integer id) throws Exception {
		int offset = numPerPage * (page - 1);
		return articleDao.selectLimitedByShowUserId(offset, numPerPage, loginStatusId, id);
	}

	@Override
	public List<Article> getArticleListByPageAndUserIdAndPrivate(int page, int numPerPage, Integer loginStatusId)
			throws Exception {
		int offset = numPerPage * (page - 1);
		return articleDao.selectLimitedByUserIdAndPrivate(offset, numPerPage, loginStatusId);
	}

	@Override
	public List<Article> getArticleListByPageAndUserIdAndLiked(int page, int numPerPage, Integer loginStatusId)
			throws Exception {
		int offset = numPerPage * (page - 1);
		return articleDao.selectLimitedByUserIdAndLiked(offset, numPerPage, loginStatusId);
	}

	@Override
	public int getTotalPages(int numPerPage) throws Exception {
		long count = articleDao.countPublic();
		return (int) Math.ceil((double) count / numPerPage);
	}

	@Override
	public int getTotalPagesByUserId(int numPerPage, Integer id) throws Exception {
		long count = articleDao.countPublicByUserId(id);
		return (int) Math.ceil((double) count / numPerPage);
	}

	@Override
	public int getTotalPrivatePagesByUserId(int numPerPage, Integer id) throws Exception {
		long count = articleDao.countPrivateByUserId(id);
		return (int) Math.ceil((double) count / numPerPage);
	}

	@Override
	public int getTotalLikedPagesByUserId(int numPerPage, Integer id) throws Exception {
		long count = articleDao.countLikedByUserId(id);
		return (int) Math.ceil((double) count / numPerPage);
	}

	@Override
	public Article getArticleById(Integer id) throws Exception {
		return articleDao.selectById(id);
	}

	@Override
	public void addArticle(Article article, MultipartFile upfile) throws Exception {
		// 画像が選択されている場合の処理
		if (!upfile.isEmpty()) {
			String image = upfile.getOriginalFilename();
			// articles テーブルへ格納するための画像名をセット
			article.setImage(image);
			// 画像ファイルの保存
			Path path = Paths.get("uploads/" + image);
			upfile.transferTo(path);
		}

		articleDao.insert(article);
	}

	@Override
	public void editArticle(Article article) throws Exception {
		articleDao.update(article);
	}

	@Override
	public void deleteArticleById(Integer id) throws Exception {
		articleDao.setDeleteById(id);
	}

}
