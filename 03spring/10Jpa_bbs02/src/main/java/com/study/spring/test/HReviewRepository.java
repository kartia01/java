package com.study.spring.test;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HReviewRepository extends JpaRepository<HReview, Long> {
	@Query("""
            SELECT new com.study.spring.hospital.dto.ReviewListDto(
                h.hCode,
                r.rTitle,
                r.rContent,
                r.rEvalPt
            )
            FROM HReview r
            JOIN Hospital h ON r.hCode = h.hCode
            WHERE h.hCode = :hCode
            """)
    List<ReviewListDto> findReviewsByHospitalCode(@Param("hCode") String hCode);
}
}
