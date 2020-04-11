package com.sc.speedcampus.admin.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sc.speedcampus.admin.notice.vo.AdminNoticeVO;
import com.sc.speedcampus.util.PagingVO;
import com.sc.speedcampus.util.SqlSessionFactoryBean;

public class AdminNoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	public AdminNoticeDAO() {
		sqlSession = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	//admin -->> 공지 추가
	public void insertNotice(AdminNoticeVO vo) {
		sqlSession.insert("AdminNoticeDAO.insertNotice", vo);
	}
	
	//Admin ==> 공지사항 수정
	public void updateNotice(AdminNoticeVO vo) {
		sqlSession.update("AdminNoticeDAO.updateNotice", vo);
	}
	
	//Admin ==> 공지사항 삭제
	public void deleteNotice(AdminNoticeVO vo) {
		sqlSession.delete("AdminNoticeDAO.deleteNotice", vo);
	}
	
	//Admin ==> 공지사항 읽기
	public AdminNoticeVO getAdminNotice(int num) {
		return (AdminNoticeVO) sqlSession.selectOne("AdminNoticeDAO.getAdminNotice", num);
	}
	
	//Admin ==> 공지사항 리스트 읽기
	public List<AdminNoticeVO> getAdminNoticeList(PagingVO vo){
		return sqlSession.selectList("AdminNoticeDAO.getAdminNoticeList", vo);
	}
	
	//Admin ==> 공지사항 조회수 Up, 필요한지 안한지 모르겠음.
	public void hitUpdate(int num) {
		sqlSession.update("AdminNoticeDAO.hitUpdate", num);
	}
	
	//Admin ==> 총게시물개수 , 필요할까?
	public int countAdminNotice() {
		return sqlSession.selectOne("AdminNoticeDAO.countAdminNotice");
	}
}
