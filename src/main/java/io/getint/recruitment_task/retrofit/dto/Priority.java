package io.getint.recruitment_task.retrofit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Priority {
    @JsonProperty
    private String name;
}
