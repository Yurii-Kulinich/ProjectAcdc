package com.javarush.kulinich.entity;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question implements AbstractEntity{

  private Long id;
  private Long questId;
  private String text;
  private Integer stage;
  private List<Answer> answers = new ArrayList<>();

}
