package com.Averado.QuizApp.controller;

import com.Averado.QuizApp.Question;
import com.Averado.QuizApp.service.QuestionService;
import jakarta.persistence.PostUpdate;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


@GetMapping("AllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
    return questionService.getAllQuestions();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<List<Question>> getQuestionsById(@PathVariable int id){
    return questionService.getQuestionsById(id);

    }

    @PostMapping("add")
    public ResponseEntity<Object> addQuestion(@RequestBody Question question){
    return new ResponseEntity<>((HttpStatusCode) questionService.addQuestion(question));

    }

}
