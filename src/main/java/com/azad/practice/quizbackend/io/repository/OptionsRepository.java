package com.azad.practice.quizbackend.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.quizbackend.io.entity.OptionsEntity;
import com.azad.practice.quizbackend.io.entity.QuestionEntity;

@Repository
public interface OptionsRepository extends PagingAndSortingRepository<OptionsEntity, Long> {

	OptionsEntity findByOptionsId(String optionsId);

}
