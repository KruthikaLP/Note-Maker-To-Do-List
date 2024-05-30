package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SaveNoteServlet() {
		super();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
           //title,content fetch
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Note note = new Note(title,content,new Date());
			
//			System.out.println(note.getId()+":"+note.getTitle());
			
//			hibernate:save()
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
		    Object  i = s.save(note);
			tx.commit();
			s.close();
			
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<h2 style='text-align:center;'>Note added Successfully</h2>");
			out.println("<h2 style='text-align:center;'><a href='all_notes.jsp'>view all notes</a></h2>");
			
		}catch(Exception e)
		{
			e.printStackTrace();	
		}
	}
    @Override
    public void destroy() {
    	System.out.println("destroy() method called");
	}

}
