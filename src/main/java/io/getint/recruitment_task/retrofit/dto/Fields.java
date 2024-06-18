package io.getint.recruitment_task.retrofit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Fields {
    @JsonProperty
    private Project project;
    @JsonProperty
    private String summary;
    @JsonProperty
    private IssueType issuetype;

    //TODO: Description

}
