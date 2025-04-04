package com.musinsa.homework.controller;

import com.musinsa.homework.enums.DefaultErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.service.AnswerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AnswerController implements BaseApiController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answer1")
    public Map<String, Object> getAnswer1() {
        return answerService.answer1();
    }

    @GetMapping("/answer2")
    public Map<String, Object> getAnswer2() {
        return answerService.answer2();
    }

    @GetMapping("/answer3/{categoryTitle}")
    public Map<String, Object> getAnswer3(@PathVariable String categoryTitle) {
        if (StringUtils.isBlank(categoryTitle)) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }

        return answerService.answer3(categoryTitle);
    }
}