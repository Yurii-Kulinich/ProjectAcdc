package com.javarush.kulinich.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quest implements AbstractEntity {

  private Long id;
  private String name;
  private String description;
  private List<String> congrats;
  private List <Question> questions;


}
