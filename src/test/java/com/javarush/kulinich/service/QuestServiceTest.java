package com.javarush.kulinich.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.javarush.kulinich.entity.Quest;
import com.javarush.kulinich.entity.Question;
import com.javarush.kulinich.repository.QuestRepository;
import com.javarush.kulinich.repository.QuestionRepository;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class QuestServiceTest {

  @InjectMocks
  private QuestService questService;
  @Mock
  private QuestRepository questRepository;

  @Mock
  private QuestionRepository questionRepository;

  @Test
  void createDefault() {
    //Arrange
    Question questionPattern = Question.builder()
        .questId(0L)
        .build();
    Question questionPatternQuest2 = Question.builder()
        .questId(1L)
        .build();
    Stream<Question> expectedStream = Stream.of(questionPattern);
    Stream<Question> expectedStream2 = Stream.of(questionPatternQuest2);

    when(questionRepository.find(questionPattern)).thenReturn(expectedStream);
    when(questionRepository.find(questionPatternQuest2)).thenReturn(expectedStream2);

    //Act
    questService.createDefault();


    //Assert
    verify(questionRepository, times(2)).find(any());
    verify(questRepository, times(2)).create(any());


  }

  @Test
  void findAll() {
    //Arrange
//    when(questRepository.getAll().stream())
    Quest questData1 = new Quest();
    Quest questData2 = new Quest();
    List<Quest> expected = List.of(questData1, questData2);

    when(questRepository.getAll()).thenReturn(expected);

    // Call the method to be tested
    List<Quest> result = questService.findAll();

    // Verify that questRepository.getAll() was called
    verify(questRepository, times(1)).getAll();
    assertEquals(expected.size(), result.size());
  }

  @Test
  void isEmpty() {
    //Arrange
    when(questRepository.isEmpty()).thenReturn(true);

    //Act
    boolean result = questService.isEmpty();

    //Assert
    assertTrue(result);
    verify(questRepository, times(1)).isEmpty();
  }

  @Test
  void get() {
    //Arrange
    Quest expected = Quest.builder()
        .id(1L)
        .name("expected")
        .build();
    when(questRepository.get(anyLong())).thenReturn(expected);

    //Act
    Quest result = questService.get(1L);

    //Assert
    assertEquals(expected, result);
    verify(questRepository, times(1)).get(anyLong());


  }
}