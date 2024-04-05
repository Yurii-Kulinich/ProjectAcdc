package com.javarush.kulinich.service;

import com.javarush.kulinich.entity.Quest;
import com.javarush.kulinich.entity.Question;
import com.javarush.kulinich.repository.QuestRepository;
import com.javarush.kulinich.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuestService {

  private final QuestRepository questRepository;
  private final QuestionRepository questionRepository;


  public void createDefault() {
    List<String> congratulatoryMessages = getStrings();
    Question questionPattern = Question.builder()
        .questId(0L)
        .build();
    Question questionPatternQuest2 = Question.builder()
        .questId(1L)
        .build();
    Quest quest1 = Quest.builder()
        .name("Quest: Journey of the Java Developer")
        .description(
            "Welcome, brave adventurer, to the Journey of the Java Developer! Embark on this quest and prove your mettle in the world of Java programming. Throughout your journey, you will encounter challenges and questions that will test your knowledge and skills. Remember, there are no right or wrong answers, but your choices will shape your path and determine your score. Are you ready to begin?")
        .questions(questionRepository.find(questionPattern).collect(Collectors.toList()))
        .congrats(congratulatoryMessages)
        .build();
    Quest quest2 = Quest.builder()
        .name("Quest: Assembler Language Fundamentals")
        .description("Welcome, adventurer, to the beginning of your journey in mastering assembly language! In this stage, you will learn the fundamental concepts and principles of assembly programming. Get ready to lay the groundwork for your assembler language proficiency! Remember, there are no right or wrong answers, but your choices will shape your path and determine your score. Are you ready to begin?")
        .questions(questionRepository.find(questionPatternQuest2).collect(Collectors.toList()))
        .congrats(congratulatoryMessages)
        .build();
    questRepository.create(quest1);
    questRepository.create(quest2);
  }

  private List<String> getStrings() {
    List<String> congratulatoryMessages = new ArrayList<>();

    congratulatoryMessages.add("Congratulations! Your exceptional performance on the test truly stands out. Your dedication and hard work have paid off tremendously. Keep up the fantastic work!");

    congratulatoryMessages.add("Congratulations! Your impressive score on the test reflects your solid understanding of the material. Your effort and perseverance have yielded remarkable results. Keep pushing yourself to reach even greater heights!");

    congratulatoryMessages.add("Congratulations! You've passed the test, showcasing your understanding of the subject matter. Your determination and commitment have led you to this accomplishment. Keep striving for improvement and success!");
    return congratulatoryMessages;
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
