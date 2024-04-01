package com.javarush.kulinich.repository;

import com.javarush.kulinich.entity.Quest;
import java.util.stream.Stream;

public class QuestRepository extends BaseRepository<Quest> {

  private static final QuestRepository INSTANCE = new QuestRepository();

  private QuestRepository() {

  }

  public static QuestRepository getInstance() {
    return INSTANCE;
  }

  @Override
  public Stream<Quest> find(Quest pattern) {
    return map.values()
        .stream()
        .filter(value -> nullOrEquals(pattern.getId(), value.getId()))
        .filter(value -> nullOrEquals(pattern.getDescription(), value.getDescription()))
        .filter(value -> nullOrEquals(pattern.getName(), value.getName()));
  }
}