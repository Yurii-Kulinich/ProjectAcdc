package com.javarush.kulinich.repository;

import com.javarush.kulinich.entity.Answer;
import java.util.stream.Stream;

public class AnswerRepository extends BaseRepository<Answer> {

  @Override
  public Stream<Answer> find(Answer pattern) {
    return map.values().stream()
        .filter(a -> nullOrEquals(pattern.getId(), a.getId()))
        .filter(a -> nullOrEquals(pattern.getQuestId(), a.getQuestId()))
        .filter(a -> nullOrEquals(pattern.getQuestionId(), a.getQuestionId()))
        .filter(a -> nullOrEquals(pattern.getScore(), a.getScore()))
        .filter(a -> nullOrEquals(pattern.getText(), a.getText()));
  }


}
