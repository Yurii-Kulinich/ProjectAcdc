package com.javarush.kulinich.repository;

import com.javarush.kulinich.entity.Question;
import java.util.stream.Stream;

public class QuestionRepository extends BaseRepository<Question>{

  private static final QuestionRepository INSTANCE = new QuestionRepository();

  private QuestionRepository() {

  }

  public static QuestionRepository getInstance() {
    return INSTANCE;
  }

  @Override
  public Stream<Question> find(Question pattern) {
    return map.values().stream().filter(value -> nullOrEquals(pattern.getId(), value.getId()))
        .filter(value -> nullOrEquals(pattern.getQuestId(), value.getQuestId()))
        .filter(value -> nullOrEquals(pattern.getStage(), value.getStage()))
        .filter(value -> nullOrEquals(pattern.getText(), value.getText()));
  }

}
