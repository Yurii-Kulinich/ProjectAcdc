package com.javarush.kulinich.servlet;

import com.javarush.kulinich.entity.Quest;
import com.javarush.kulinich.service.QuestService;
import com.javarush.kulinich.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/start")
public class HelloServlet extends HttpServlet {

  private final QuestService questService = QuestService.getInstance();
  private final QuestionService questionService = QuestionService.getInstance();



  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession currentSession = req.getSession(true);
    if (questionService.isEmpty() && questService.isEmpty()) {
      initGame();
    }

    List<Quest> quests = questService.findAll();
    req.setAttribute("quests", quests);
    req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
  }

  private void initGame(){
  questService.createDefault();
  questionService.createDefault();
  }
}
