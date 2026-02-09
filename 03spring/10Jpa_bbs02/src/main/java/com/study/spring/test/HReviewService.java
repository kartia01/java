package com.study.spring.test;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HReviewService {

	private final HReviewRepository reviewRepository;

	public HReviewService(HReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public List<ReviewListDto> getReviewsByHospitalCode(String hCode) {
		return reviewRepository.findReviewsByHospitalCode(hCode);
	}
}
