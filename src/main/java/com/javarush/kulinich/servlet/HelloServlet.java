package com.javarush.kulinich.servlet;

import com.javarush.kulinich.config.Winter;
import com.javarush.kulinich.entity.Quest;
import com.javarush.kulinich.service.AnswerService;
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

  private final QuestService questService = Winter.find(QuestService.class);
  private final QuestionService questionService = Winter.find(QuestionService.class);
  private final AnswerService answerService = Winter.find(AnswerService.class);


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

  private void initGame() {
    answerService.createDefault();
    questionService.createDefault();
    questService.createDefault();

  }
}
