package com.mdemydovych.transplet.response;

import lombok.Builder;

@Builder
public record UserResponse(Integer userId,
                           String name,
                           Integer age) {

}
