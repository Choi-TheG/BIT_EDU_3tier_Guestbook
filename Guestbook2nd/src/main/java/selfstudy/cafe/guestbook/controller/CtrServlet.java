package selfstudy.cafe.guestbook.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import selfstudy.cafe.guestbook.dao.GuestbookDAO;
import selfstudy.cafe.guestbook.utils.ConnectionManager;
import selfstudy.cafe.guestbook.vo.GuestbookVO;

@WebServlet("*.do")
public class CtrServlet extends HttpServlet{
	
	public void check() {
		Connection con = ConnectionManager.getConnection();
		if(con!=null) {
			System.out.println("hola");
		} else {
			System.out.println("fail");
		}
	}
	
	public void doHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("mahala");
		// 한글 처리 작업
		req.setCharacterEncoding("UTF-8");
		// 명령어 처리 작업
		resp.setContentType("text/html; charset=UTF-8");
		GuestbookDAO dao = new GuestbookDAO();
		String uri = req.getRequestURI();
		String[] temp = uri.split("/");
		String command = temp[temp.length-1];
		
		String url = "./guestbook/Main.jsp";
		if(command==null) {
			url="./guestbook/Main.jsp";
/*		} else if(command.equals("check.do")) { // 로그인 구현 미루기
			String pw = req.getParameter("pw");
			GuestbookVO book = new GuestbookVO();
			book.setPw(pw);
			try {
				int login = dao.loginCheck(pw);
				if(login==1) {
					url = "./Main.jsp";
				} else if(login==2) {
					url = "./Login.jsp";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/			
		} else if(command.equals("list.do")) {

			try {
				ArrayList<GuestbookVO> list = dao.selectAll();
				HttpSession session = req.getSession();
				session.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(command.equals("index.do")) {
			// 게시글 조회
			
			
		} else if(command.equals("post.do")) {
			// 게시글 작성
			
			
		}
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandler(req, resp);
//		check();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandler(req, resp);
//		check();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}
}
