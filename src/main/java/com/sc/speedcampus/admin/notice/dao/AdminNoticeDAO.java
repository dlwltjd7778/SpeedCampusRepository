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
	
	//admin -->> ���� �߰�
	public void insertNotice(AdminNoticeVO vo) {
		sqlSession.insert("AdminNoticeDAO.insertNotice", vo);
	}
	
	//Admin ==> �������� ����
	public void updateNotice(AdminNoticeVO vo) {
		sqlSession.update("AdminNoticeDAO.updateNotice", vo);
	}
	
	//Admin ==> �������� ����
	public void deleteNotice(AdminNoticeVO vo) {
		sqlSession.delete("AdminNoticeDAO.deleteNotice", vo);
	}
	
	//Admin ==> �������� �б�
	public AdminNoticeVO getAdminNotice(int num) {
		return (AdminNoticeVO) sqlSession.selectOne("AdminNoticeDAO.getAdminNotice", num);
	}
	
	//Admin ==> �������� ����Ʈ �б�
	public List<AdminNoticeVO> getAdminNoticeList(PagingVO vo){
		return sqlSession.selectList("AdminNoticeDAO.getAdminNoticeList", vo);
	}
	
	//Admin ==> �������� ��ȸ�� Up, �ʿ����� ������ �𸣰���.
	public void hitUpdate(int num) {
		sqlSession.update("AdminNoticeDAO.hitUpdate", num);
	}
	
	//Admin ==> �ѰԽù����� , �ʿ��ұ�?
	public int countAdminNotice() {
		return sqlSession.selectOne("AdminNoticeDAO.countAdminNotice");
	}
}
