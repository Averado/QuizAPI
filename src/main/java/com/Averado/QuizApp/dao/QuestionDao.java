package com.Averado.QuizApp.dao;

import com.Averado.QuizApp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository <Question, Integer> {
    List<Question> findById(int Id);
    List<Question> addQuestion(Question question);

    List<Question> getQuestionsById(Question question);
}
