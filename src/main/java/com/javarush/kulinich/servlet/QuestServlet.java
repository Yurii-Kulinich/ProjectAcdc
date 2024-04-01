package com.javarush.kulinich.servlet;

import com.javarush.kulinich.entity.Question;
import com.javarush.kulinich.service.QuestService;
import com.javarush.kulinich.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {

  private final QuestionService questionService = QuestionService.getInstance();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long questId = Long.valueOf(req.getParameter("questId"));
    List<Question> questions = questionService.findByQuestId(questId);
    req.setAttribute("questions", questions);

    req.getRequestDispatcher("quest.jsp").forward(req, resp);

  }
}