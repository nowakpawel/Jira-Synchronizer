package io.getint.recruitment_task.retrofit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/atlassian")
public class AtlassianController {
    private final AtlassianService service;

    @GetMapping("/projects")
    public List<ProjectDto> getProjects() throws IOException {
        log.info("Collecting project for user");
        return service.getProjects();
    }
}
