package com.javarush.kulinich.service;

import com.javarush.kulinich.entity.Answer;
import com.javarush.kulinich.repository.AnswerRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AnswerService {

  private final AnswerRepository answerRepository;


  public List<Answer> findByQuestAndQuestionId(Long questId, Long questionId) {
    Answer pattern = Answer.builder()
        .questId(questId)
        .questionId(questionId)
        .build();
    return answerRepository.find(pattern).collect(Collectors.toList());
  }

  public void createDefault() {
    //First Quest:
    // Stage 1: The Foundation
    answerRepository.create(Answer.builder().questId(1L).questionId(1L).score(4)
        .text("To initialize the state of an object.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(1L).score(3)
        .text("To define the behavior of a class.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(1L).score(2)
        .text("To execute code before the program starts.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(1L).score(1)
        .text("To handle exceptions during runtime.").build());

    // Stage 2: Object-Oriented Mastery
    answerRepository.create(Answer.builder().questId(1L).questionId(2L).score(1)
        .text("It is a way to access private methods of other classes.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(2L).score(4)
        .text("It allows a class to inherit fields and methods from another class.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(2L).score(2)
        .text("It refers to the ability to create multiple instances of a class.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(2L).score(1).text(
            "It is a mechanism to prevent multiple threads from accessing the same resource simultaneously.")
        .build());

    // Stage 3: Handling the Flow
    answerRepository.create(Answer.builder().questId(1L).questionId(3L).score(1)
        .text("To terminate the loop immediately.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(3L).score(4).text(
            "To exit the switch statement and resume execution at the next statement after the switch block.")
        .build());
    answerRepository.create(Answer.builder().questId(1L).questionId(3L).score(2)
        .text("To continue to the next iteration of the loop.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(3L).score(1)
        .text("To throw an exception and halt the program.").build());

    // Stage 4: Mastering Java Tools
    answerRepository.create(Answer.builder().questId(1L).questionId(4L).score(1)
        .text("It is used to execute a Java program.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(4L).score(2)
        .text("It is used to generate Java documentation from source code.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(4L).score(4)
        .text("It is used to compile Java source code into bytecode.").build());
    answerRepository.create(Answer.builder().questId(1L).questionId(4L).score(3)
        .text("It is used to debug Java programs.").build());

    //Quest2
    // For Question 1 (questId: 2L)
    answerRepository.create(Answer.builder().questId(2L).questionId(1L).score(4)
        .text("To translate high-level programming code into machine code.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(1L).score(3)
        .text("To execute the program's instructions sequentially.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(1L).score(2)
        .text("To optimize the program's performance.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(1L).score(1)
        .text("To convert assembly language instructions into machine code directly.").build());

    // For Question 2 (questId: 2L)
    answerRepository.create(Answer.builder().questId(2L).questionId(2L).score(4)
        .text("To provide comments within the code for documentation.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(2L).score(3)
        .text("To declare variables and constants.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(2L).score(2)
        .text("To specify the location of memory addresses in the program.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(2L).score(1)
        .text("To handle exceptions and errors during runtime.").build());

    // For Question 3 (questId: 2L)
    answerRepository.create(Answer.builder().questId(2L).questionId(3L).score(4)
        .text("It provides direct access to hardware resources.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(3L).score(3)
        .text("It offers a high level of abstraction from the underlying hardware.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(3L).score(2)
        .text("It allows for fine-grained control over memory and CPU usage.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(3L).score(1)
        .text("It requires an understanding of the architecture-specific instructions.").build());

    // For Question 4 (questId: 2L)
    answerRepository.create(Answer.builder().questId(2L).questionId(4L).score(4)
        .text("To resolve references to external libraries and modules.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(4L).score(3)
        .text("To execute the assembled program on the CPU.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(4L).score(2)
        .text("To optimize the performance of the assembled program.").build());
    answerRepository.create(Answer.builder().questId(2L).questionId(4L).score(1)
        .text("To convert assembly language code into machine code.").build());

  }

  public boolean isEmpty() {
    return answerRepository.isEmpty();
  }

}
