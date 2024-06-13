package io.getint.recruitment_task.retrofit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProjectDto {

    @JsonProperty
    private String id;

    @JsonProperty
    private String key;

    @JsonProperty
    private String name;
}
