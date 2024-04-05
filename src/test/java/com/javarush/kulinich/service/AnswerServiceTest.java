package com.javarush.kulinich.service;

import static org.junit.jupiter.api.Assertions.*;

import com.javarush.kulinich.entity.Answer;
import com.javarush.kulinich.repository.AnswerRepository;
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
class AnswerServiceTest {

  @InjectMocks
  private AnswerService answerService;

  @Mock
  private AnswerRepository answerRepository;

  @Test
  void findByQuestAndQuestionId() {
    //Arrange
    Answer answerExpected = Answer.builder()
        .questId(1L)
        .questionId(1L)
        .build();

    Mockito.when(answerRepository.find(answerExpected)).thenReturn(Stream.of(answerExpected));

    //Act
    List<Answer> result = answerService.findByQuestAndQuestionId(1L, 1L);

    //Assert
    Mockito.verify(answerRepository, Mockito.times(1)).find(Mockito.any());
    Assertions.assertTrue(result.contains(answerExpected));
  }

  @Test
  void createDefault() {
    //Act
    answerService.createDefault();
    //Assert
    Mockito.verify(answerRepository, Mockito.times(32)).create(Mockito.any());
  }

  @Test
  void isEmpty() {
    //Arrange
    Mockito.when(answerRepository.isEmpty()).thenReturn(true);
    //Act
    boolean result = answerService.isEmpty();
    //Assert
    Assertions.assertEquals(result, true);
    Mockito.verify(answerRepository, Mockito.times(1)).isEmpty();



  }
}