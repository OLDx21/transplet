package com.mdemydovych.transplet.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CreateUserRequest(@NotNull @JsonProperty(value = "user_id") Integer userId,
                                @NotBlank @JsonProperty(value = "user_name") String name,
                                @NotNull @JsonProperty(value = "user_age") Integer age) {

}
