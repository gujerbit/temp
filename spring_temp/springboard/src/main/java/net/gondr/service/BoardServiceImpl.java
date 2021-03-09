package net.gondr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.gondr.dao.BoardDAO;
import net.gondr.domain.BoardVO;
import net.gondr.domain.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public void writeArticle(BoardVO board) {
		dao.write(board);
	}
	
	@Override
	public BoardVO viewArticle(Integer id) {
		return dao.view(id);
	}
	
	@Override
	public List<BoardVO> getArticleList(Integer start, Integer cnt) {
		return dao.list(start, cnt);
	}
	
	@Override
	public List<BoardVO> getCriteriaList(Criteria c) {
		return dao.list(c);
	}
	
	@Override
	public void updateArticle(BoardVO board) {
		dao.update(board);
	}
	
	@Override
	public void deleteArticle(Integer id) {
		dao.delete(id);
	}
	
	@Override
	public Integer countArticle() {
		return dao.getCnt();
	}
	
	@Override
	public Integer countCriteria(Criteria c) {
		return dao.getCnt(c);
	}
	
	@Override
	public BoardVO getBoard(Integer id) {
		return dao.getBoard(id);
	}
	
}
