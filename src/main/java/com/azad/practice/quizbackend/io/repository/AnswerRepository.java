package com.azad.practice.quizbackend.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.quizbackend.io.entity.AnswerEntity;
import com.azad.practice.quizbackend.io.entity.QuestionEntity;

@Repository
public interface AnswerRepository extends PagingAndSortingRepository<AnswerEntity, Long> {

	AnswerEntity findByAnswerId(String answerId);

}
