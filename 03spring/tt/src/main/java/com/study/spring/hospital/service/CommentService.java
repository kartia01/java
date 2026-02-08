package com.study.spring.hospital.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.spring.hospital.entity.H_review;
import com.study.spring.hospital.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository cmRepository;

    public H_review findReviewWithComments(int reviewId) {
        return cmRepository.findcommentwithComments(reviewId); // 혹은 findcommentwithComments(reviewId)
    }
}