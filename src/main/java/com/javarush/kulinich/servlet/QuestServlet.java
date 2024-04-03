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

    int questLength = 0;

    Integer stageId = Integer.valueOf(req.getParameter("stageId"));
    HttpSession currentSession = req.getSession();

    //Getting the quest number from users choice
    //And setting Quest qnd questions to the Session Attributes
    if (stageId == 0) {
      Long questId = Long.valueOf(req.getParameter("questId"));
      Quest quest = questService.get(questId);
      List<Question> questions = questionService.findByQuestId(questId);
      questLength = questions.size();

      currentSession.setAttribute("quest", quest);
      currentSession.setAttribute("questions", questions);
      currentSession.setAttribute("score", Integer.valueOf(0));

      req.setAttribute("description", quest.getDescription());
      req.getRequestDispatcher("quest.jsp").forward(req, resp);
    } else {

      Integer stageScore = Integer.valueOf(req.getParameter("score"));
      Integer currentScore = (Integer) currentSession.getAttribute("score");
      currentSession.setAttribute("score", stageScore + currentScore);

      List<Question> questions = (List<Question>)currentSession.getAttribute("questions");

      if (stageId > questions.size()) {
        List<String> congrats = ((Quest) currentSession.getAttribute("quest")).getCongrats();
        Integer finalScore = stageScore + currentScore;
        req.setAttribute("congrats", getCongratsByScore(finalScore, congrats));
        req.getRequestDispatcher("quest.jsp").forward(req, resp);
      }

      Question currentQuestion = questions.get(
          stageId - 1);
      req.setAttribute("question", currentQuestion);
      req.setAttribute("stageId", stageId + 1);
      req.getRequestDispatcher("quest.jsp").forward(req, resp);
    }


  }

  private String getCongratsByScore(int score, List<String> congrats){
    String result = congrats.get(2);
    if (score > 10 && score < 14) {
      result = congrats.get(1);
    } else if (score > 13) {
      result = congrats.get(0);
    }
    return result;
  }
}
