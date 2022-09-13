package selfstudy.cafe.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import selfstudy.cafe.guestbook.utils.ConnectionManager;
import selfstudy.cafe.guestbook.vo.GuestbookVO;

public class GuestbookDAO {
	Connection con = null;
	
	// 로그인 체크
	public int loginCheck(String pw) throws SQLException {
		con = ConnectionManager.getConnection();
		String sql = "select * from login where pw=?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, pw);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			if(rs.getString(1).equals(pw)) {
				return 1;
			} else {
				return 2;
			}
		}
		return 2;
	}
	
	// 전체 조회
	public ArrayList<GuestbookVO> selectAll() throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from guestbook;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<GuestbookVO> list = new ArrayList<GuestbookVO>();
		GuestbookVO book = null;
		while(rs.next()) {
			book = new GuestbookVO(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getString(4),rs.getTimestamp(5),rs.getInt(6));
			list.add(book);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return list;
	}
	
	// 개별 조회
	public boolean selectOne(int seq) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from guestbook where seq=?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<GuestbookVO> list = new ArrayList<GuestbookVO>();
		GuestbookVO book = null;
		while(rs.next()) {
			book = new GuestbookVO(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getString(4),rs.getTimestamp(5),rs.getInt(6));
			list.add(book);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		
		return flag;
	}
	
	// 게시글 작성
	public GuestbookVO createOne() {
		GuestbookVO book = null;
		
		
		return book;
	}
}
