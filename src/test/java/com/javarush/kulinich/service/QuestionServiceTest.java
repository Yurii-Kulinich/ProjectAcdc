package com.javarush.kulinich.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.javarush.kulinich.entity.Answer;
import com.javarush.kulinich.entity.Question;
import com.javarush.kulinich.repository.AnswerRepository;
import com.javarush.kulinich.repository.QuestionRepository;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

  @InjectMocks
  private QuestionService questionService;
  @Mock
  private QuestionRepository questionRepository;

  @Mock
  private AnswerService answerService;

  @Test
  void findByQuestId() {
    //Arrange
    Question questionExpected  = Question.builder()
        .questId(1L)
        .build();

    when(questionRepository.find(questionExpected)).thenReturn(Stream.of(questionExpected));

    //Act
    List<Question> result = questionService.findByQuestId(1L);

    //Assert
    verify(questionRepository, times(1)).find(any());
    assertTrue(result.contains(questionExpected));

  }

  @Test
  void createDefault() {
    //Arrange
    List<Answer> answers = List.of(new Answer());
    when(answerService.findByQuestAndQuestionId(any(), any())).thenReturn(answers);
    //Act
    questionService.createDefault();

    //Assert
    verify(questionRepository, times(8)).create(any());
    verify(answerService, times(8)).findByQuestAndQuestionId(any(), any());
  }

  @Test
  void isEmpty() {
    //Arrange
    when(questionRepository.isEmpty()).thenReturn(true);

    //Act
    boolean result = questionService.isEmpty();

    //Assert
    assertTrue(result);
    verify(questionRepository, times(1)).isEmpty();
  }
}