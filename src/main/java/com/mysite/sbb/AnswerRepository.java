package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository; // CURD 작업을 위한 리포지토리

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
