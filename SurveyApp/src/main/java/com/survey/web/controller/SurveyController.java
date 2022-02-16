package com.survey.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.survey.web.model.Question;
import com.survey.web.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	SurveyService surveyService;

	@GetMapping("/surveys/{surveyId}/questions")
	private List<Question> getAllQuestionsById(@PathVariable String surveyId) {
		return surveyService.retrieveQuestions(surveyId);
	}

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	private Question retrieveDetailsForAQuestions(@PathVariable String surveyId, @PathVariable String questionId) {
		return surveyService.retrieveQuestion(surveyId, questionId);
	}
}
