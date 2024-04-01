package com.javarush.kulinich.service;

import com.javarush.kulinich.entity.Quest;
import com.javarush.kulinich.entity.Question;
import com.javarush.kulinich.repository.QuestRepository;
import com.javarush.kulinich.repository.QuestionRepository;
import java.util.List;
import java.util.stream.Collectors;

public class QuestService {

  private static final QuestService INSTANCE = new QuestService();
  private final QuestRepository questRepository = QuestRepository.getInstance();
  private final QuestionRepository questionRepository = QuestionRepository.getInstance();

  private QuestService() {

  }

  public static QuestService getInstance() {

    return INSTANCE;
  }


  public void createDefault() {
    Question questionPattern = Question.builder()
        .questId(0L)
        .build();
    Quest quest1 = Quest.builder()
        .name("Test quest")
        .description("Best quest for newbies")
        .questions(questionRepository.find(questionPattern).collect(Collectors.toList()))
        .build();
    Quest quest2 = Quest.builder()
        .name("Test quest2")
        .description("To make this page look more Solid")
        .questions(questionRepository.find(questionPattern).collect(Collectors.toList()))
        .build();
    questRepository.create(quest1);
    questRepository.create(quest2);
  }

  public List<Quest> findAll() {
    List<Quest> result = questRepository.getAll().stream()
        .map(quest -> Quest.builder()
            .id(quest.getId())
            .name(quest.getName())
            .description(quest.getDescription())
            .build()
        )
        .collect(Collectors.toList());

    return result;
  }

  public boolean isEmpty() {
    return questionRepository.isEmpty();
  }
}
