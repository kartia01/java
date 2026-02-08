package com.study.spring.hospital.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.spring.hospital.dto.CommentDto;
import com.study.spring.hospital.dto.H_ReviewCommentDto;
import com.study.spring.hospital.entity.H_review;
import com.study.spring.hospital.service.CommentService;

@RestController

public class CommentController {

	@Autowired
	CommentService cmService;

	@GetMapping("/api/comment")
	public H_ReviewCommentDto getReviewWithComments(@RequestParam("reviewId") int reviewId) {
		H_review review = cmService.findReviewWithComments(reviewId);
		return H_ReviewCommentDto.builder()
				.r_id(review.getR_id())
				.createdAt(review.getCreatedAt())
				.commentCount(review.getComments().size())
				.comments(review.getComments().stream()
						.map(comment -> new CommentDto(
								comment.getC_id(),
								comment.getC_content()))
						.toList())
				.build();
	}

}
