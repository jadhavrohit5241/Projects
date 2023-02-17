package com.te.postgresdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.postgresdemo.exception.ResourceNotFoundException;
import com.te.postgresdemo.model.Question;
import com.te.postgresdemo.repository.QuestionRepository;
import com.te.postgresdemo.respose.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/questions")
@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/getAllQuestions")
    public Page<Question> getQuestions(Pageable pageable) {
    	log.info("get all called");
        return questionRepository.findAll(pageable);
    }


    @PostMapping("/addQuestion")
    public Question createQuestion(@Valid @RequestBody Question question) {
    	log.info("add question method");
    	return questionRepository.save(question);
    }

    @PutMapping("/updateQuestion/{questionId}")
    public Question updateQuestion(@PathVariable Long questionId,
                                   @Valid @RequestBody Question questionRequest) {
    	log.info("update question method");
    	return questionRepository.findById(questionId)
                .map(question -> {
                    question.setTitle(questionRequest.getTitle());
                    question.setDescription(questionRequest.getDescription());
                    return questionRepository.save(question);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }


    @DeleteMapping("/deleteQuestion/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
    	log.info("delete questions method");
    	return questionRepository.findById(questionId)
                .map(question -> {
                    questionRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id "));
    }
    
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(RuntimeException runtimeException) {
		log.error("Custom exception "+ runtimeException.getMessage() + runtimeException.getCause()) ;
		return new ResponseEntity<>(ErrorResponse.builder().error(true).errorMessage(runtimeException.getMessage())
				.status(400).build(), HttpStatus.BAD_REQUEST);
	}
}
