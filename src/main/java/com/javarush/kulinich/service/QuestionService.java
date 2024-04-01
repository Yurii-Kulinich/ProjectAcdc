package com.javarush.kulinich.service;

import com.javarush.kulinich.entity.Question;
import com.javarush.kulinich.repository.QuestionRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuestionService {

  private final static QuestionService INSTANCE = new QuestionService();

  private final QuestionRepository questionRepository = QuestionRepository.getInstance();

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
    questionRepository.create(Question.builder().questId(1L).text("What is the main purpose of a constructor in Java?").stage(1).build());

    // Stage 2: Object-Oriented Mastery
    questionRepository.create(Question.builder().questId(1L).text("What is the concept of inheritance in Java?").stage(2).build());

    // Stage 3: Handling the Flow
    questionRepository.create(Question.builder().questId(1L).text("What is the purpose of the 'break' statement in a switch statement?").stage(3).build());

    // Stage 4: Mastering Java Tools
    questionRepository.create(Question.builder().questId(1L).text("What is the significance of the 'javac' command in Java development?").stage(4).build());
  }

  public boolean isEmpty() {
    return questionRepository.isEmpty();
  }

}
