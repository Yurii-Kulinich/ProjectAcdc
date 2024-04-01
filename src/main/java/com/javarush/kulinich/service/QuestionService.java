package com.javarush.kulinich.service;

import com.javarush.kulinich.entity.Answer;
import com.javarush.kulinich.entity.Question;
import com.javarush.kulinich.repository.QuestionRepository;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionService {

  private final static QuestionService INSTANCE = new QuestionService();

  private final QuestionRepository questionRepository = QuestionRepository.getInstance();
  private final AnswerService answerService = AnswerService.getInstance();

  private QuestionService() {

  }

  public static QuestionService getInstance() {
    return INSTANCE;
  }


  public List<Question> findByQuestId(Long id) {
    Question pattern = Question.builder()
        .questId(id)
        .build();
    return questionRepository.find(pattern).collect(Collectors.toList());
  }

  public void createDefault() {
//    Question first = Question.builder()
//        .questId(1L)
//        .text("""
//            First quest
//            First question
//            """)
//        .stage(1)
//        .build();
//    Question second = Question.builder()
//        .questId(1L)
//        .text("""
//            Second quest
//            Second question
//            """)
//        .stage(2)
//        .build();
//    Question third = Question.builder()
//        .questId(1L)
//        .text("""
//            Third quest
//            Third question
//            """)
//        .stage(3)
//        .build();
//    questionRepository.create(first);
//    questionRepository.create(second);
//    questionRepository.create(third);

    // Stage 1: The Foundation
    List<Answer> firstQ = answerService.findByQuestAndQuestionId(1L, 1l);

    questionRepository.create(
        Question.builder().questId(1L).text("What is the main purpose of a constructor in Java?")
            .answers(firstQ)
            .stage(1).build());

    // Stage 2: Object-Oriented Mastery
    List<Answer> secondQ = answerService.findByQuestAndQuestionId(1L, 2l);
    questionRepository.create(
        Question.builder().questId(1L).text("What is the concept of inheritance in Java?").stage(2)
            .answers(secondQ)
            .build());

    // Stage 3: Handling the Flow
    List<Answer> thirdQ = answerService.findByQuestAndQuestionId(1L, 3l);
    questionRepository.create(Question.builder().questId(1L)
        .text("What is the purpose of the 'break' statement in a switch statement?").stage(3)
        .answers(thirdQ)
        .build());

    // Stage 4: Mastering Java Tools
    List<Answer> fourthQ = answerService.findByQuestAndQuestionId(1L, 4l);
    questionRepository.create(Question.builder().questId(1L)
        .text("What is the significance of the 'javac' command in Java development?").stage(4)
        .answers(fourthQ)
        .build());
  }

  public boolean isEmpty() {
    return questionRepository.isEmpty();
  }


}
