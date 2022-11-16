package com.alticci.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AlticciResponseDTO {
    private Long number;
    private Long result;
}
