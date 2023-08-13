package com.Averado.QuizApp.service;

import com.Averado.QuizApp.Question;
import com.Averado.QuizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {


    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
      return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


}

    public Object addQuestion(Question question) {
            questionDao.save(question);
            return new ResponseEntity<>("Naujas klausimas pridetas", HttpStatus.CREATED);
    }


    public ResponseEntity<List<Question>> getQuestionsById(int id) {
        return new ResponseEntity<>(questionDao.findById(id), HttpStatus.BAD_REQUEST);
    }
}


