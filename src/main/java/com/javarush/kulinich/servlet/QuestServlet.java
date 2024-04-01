package com.javarush.kulinich.servlet;

import com.javarush.kulinich.entity.Quest;
import com.javarush.kulinich.entity.Question;
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

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {

  private final QuestionService questionService = QuestionService.getInstance();
  private final QuestService questService = QuestService.getInstance();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {


    Integer stageId = Integer.valueOf(req.getParameter("stageId"));
    HttpSession currentSession = req.getSession();
    if (stageId == 0) {
      Long questId = Long.valueOf(req.getParameter("questId"));
      Quest quest = questService.get(questId);
      List<Question> questions = questionService.findByQuestId(questId);

      currentSession.setAttribute("quest", quest);
      currentSession.setAttribute("questions", questions);

      req.setAttribute("description", quest.getDescription());
      req.getRequestDispatcher("quest.jsp").forward(req, resp);
    }

    Question currentQuestion = ((List<Question>) currentSession.getAttribute("questions")).get(stageId - 1);
    req.setAttribute("question", currentQuestion);
    req.getRequestDispatcher("quest.jsp").forward(req, resp);




  }
}
