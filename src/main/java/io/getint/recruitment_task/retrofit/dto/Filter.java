package io.getint.recruitment_task.retrofit.dto;

import lombok.Data;

@Data
public class Filter {
    private String jql;
    private final int maxResults = 5;
}
