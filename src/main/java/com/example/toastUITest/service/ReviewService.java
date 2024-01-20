package com.example.toastUITest.service;

import com.example.toastUITest.dto.request.ReviewRequestDto;
import com.example.toastUITest.dto.response.ReviewResponseDto;
import com.example.toastUITest.entity.Review;
import com.example.toastUITest.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // 후기 저장
    public Long saveReview(ReviewRequestDto requestDto) {
        Review review = Review.builder()
                .title(requestDto.getTitle())
                .context(requestDto.getContext())
                .build();

        Review savedReview = reviewRepository.save(review);
        return savedReview.getId();
    }

    // 후기 상세 정보 조회
    @Transactional(readOnly = true)
    public ReviewResponseDto findReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("review not found : " + id));

        return ReviewResponseDto.builder()
                .id(review.getId())
                .title(review.getTitle())
                .context(review.getContext())
                .build();
    }

    // 후기 목록 조회
    @Transactional(readOnly = true)
    public List<ReviewResponseDto> findAllReview() {
        List<Review> allReviews = reviewRepository.findAll();

        List<ReviewResponseDto> responseDto = allReviews.stream()
                .map(review -> ReviewResponseDto.builder()
                        .id(review.getId())
                        .title(review.getTitle())
                        .context(review.getContext())
                        .build())
                .collect(Collectors.toList());

        return responseDto;
    }
}
