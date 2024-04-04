package com.javarush.kulinich.service;

import com.javarush.kulinich.entity.Answer;
import com.javarush.kulinich.entity.Question;
import com.javarush.kulinich.repository.QuestionRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuestionService {

  private final QuestionRepository questionRepository;
  private final AnswerService answerService;


  public List<Question> findByQuestId(Long id) {
    Question pattern = Question.builder()
        .questId(id)
        .build();
    return questionRepository.find(pattern).collect(Collectors.toList());
  }

  public void createDefault() {
    //Quest 1
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

    //Quest2
    // Stage 1: The Basics
    List<Answer> firstQuest2 = answerService.findByQuestAndQuestionId(2L, 1L);
    questionRepository.create(
        Question.builder().questId(2L).text("What is the primary function of an assembler in programming?")
            .answers(firstQuest2)
            .stage(1).build());

// Stage 2: Understanding Labels
    List<Answer> secondQuest2 = answerService.findByQuestAndQuestionId(2L, 2L);
    questionRepository.create(
        Question.builder().questId(2L).text("What is the purpose of a label in assembly language?")
            .answers(secondQuest2)
            .stage(2)
            .build());

// Stage 3: Characteristics of Assembly Language
    List<Answer> thirdQuest2 = answerService.findByQuestAndQuestionId(2L, 3L);
    questionRepository.create(Question.builder().questId(2L)
        .text("Which of the following is NOT a characteristic of assembly language programming?")
        .stage(3)
        .answers(thirdQuest2)
        .build());

// Stage 4: Linking Assembly Programs
    List<Answer> fourthQuest2 = answerService.findByQuestAndQuestionId(2L, 4L);
    questionRepository.create(Question.builder().questId(2L)
        .text("What is the role of the linker in assembling and linking assembly language programs?")
        .stage(4)
        .answers(fourthQuest2)
        .build());

  }

  public boolean isEmpty() {
    return questionRepository.isEmpty();
  }


}
