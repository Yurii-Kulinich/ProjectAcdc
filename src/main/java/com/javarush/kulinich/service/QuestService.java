package com.javarush.kulinich.service;

import com.javarush.kulinich.entity.Quest;
import com.javarush.kulinich.entity.Question;
import com.javarush.kulinich.repository.QuestRepository;
import com.javarush.kulinich.repository.QuestionRepository;
import java.util.ArrayList;
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
    List<String> congratulatoryMessages = new ArrayList<>();

    congratulatoryMessages.add("Congratulations! Your exceptional performance on the test truly stands out. Your dedication and hard work have paid off tremendously. Keep up the fantastic work!");

    congratulatoryMessages.add("Congratulations! Your impressive score on the test reflects your solid understanding of the material. Your effort and perseverance have yielded remarkable results. Keep pushing yourself to reach even greater heights!");

    congratulatoryMessages.add("Congratulations! You've passed the test, showcasing your understanding of the subject matter. Your determination and commitment have led you to this accomplishment. Keep striving for improvement and success!");
    Question questionPattern = Question.builder()
        .questId(0L)
        .build();
    Quest quest1 = Quest.builder()
        .name("Quest: Journey of the Java Developer")
        .description(
            "Welcome, brave adventurer, to the Journey of the Java Developer! Embark on this quest and prove your mettle in the world of Java programming. Throughout your journey, you will encounter challenges and questions that will test your knowledge and skills. Remember, there are no right or wrong answers, but your choices will shape your path and determine your score. Are you ready to begin?")
        .questions(questionRepository.find(questionPattern).collect(Collectors.toList()))
        .congrats(congratulatoryMessages)
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
    return questRepository.isEmpty();
  }

  public Quest get(Long questId) {
    return questRepository.get(questId);
  }
}
