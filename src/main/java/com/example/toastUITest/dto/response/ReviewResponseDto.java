package com.example.toastUITest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ReviewResponseDto {

    private Long id;
    private String title;
    private String context;

}
