package com.javarush.kulinich.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Answer implements AbstractEntity {

  private Long id;
  private Long questionId;
  private Long questId;
  private Integer score;
  private String text;



}
