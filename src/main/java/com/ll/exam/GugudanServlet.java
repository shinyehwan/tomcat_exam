package com.ll.exam;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Rq rq = new Rq(req, resp);


		// int dan = Integer.parseInt(req.getParameter("dan"));
		// int limit = Integer.parseInt(req.getParameter("limit"));
		int dan = rq.getIntParam("dan", 9);
		int limit = rq.getIntParam("limit", 9);

		// resp.getWriter().append("<h1>%d단</h1>\n".formatted(dan));
		rq.appendBody("<h1>%d단</h1>\n".formatted(dan));
		for (int i = 1; i <= limit; i++) {
			// resp.getWriter().append("<div>%d * %d = %d</div>\n".formatted(dan, i, dan * i));
			rq.appendBody("<div>%d * %d = %d</div>\n".formatted(dan, i, dan * i));
		}
	}
}
