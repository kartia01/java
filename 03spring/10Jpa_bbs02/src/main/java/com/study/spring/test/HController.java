package com.study.spring.test;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class HController {
	@RestController
	@RequestMapping("/api/reviews")
	public class HReviewController {

		private final HReviewService reviewService;

		public HReviewController(HReviewService reviewService) {
			this.reviewService = reviewService;
		}

		@GetMapping("/{hCode}")
		public List<ReviewListDto> getReviews(@PathVariable("hCode") String hCode) {
			return reviewService.getReviewsByHospitalCode(hCode);
		}
	}
}
