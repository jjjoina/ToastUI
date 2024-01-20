package com.example.toastUITest.controller;

import com.example.toastUITest.dto.request.ReviewRequestDto;
import com.example.toastUITest.dto.response.ReviewResponseDto;
import com.example.toastUITest.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 게시글 저장
    @PostMapping
    public Long saveReview(@RequestBody ReviewRequestDto requestDto) {
        return reviewService.saveReview(requestDto);
    }

    // 후기 상세 정보 조회
    @GetMapping("/{reviewId}")
    public ReviewResponseDto findReviewById(@PathVariable Long reviewId) {
        ReviewResponseDto responseDto = reviewService.findReviewById(reviewId);
        System.out.println("responseDto = " + responseDto);
        return responseDto;
    }

    // 후기 목록 조회
    @GetMapping
    public List<ReviewResponseDto> findAllReview() {
        return reviewService.findAllReview();
    }
}
