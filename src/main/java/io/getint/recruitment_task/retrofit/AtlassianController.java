package io.getint.recruitment_task.retrofit;


import io.getint.recruitment_task.retrofit.dto.Issue;
import io.getint.recruitment_task.retrofit.dto.IssuesFromProject;
import io.getint.recruitment_task.retrofit.dto.Project;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.PUT;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atlassian")
@Slf4j
public class AtlassianController {
    private final AtlassianService service;

    @GetMapping("/projects")
    public List<Project> getProjects() throws IOException {
        log.info("Collecting project for user");
        return service.getProjects();
    }

    @PostMapping("/create-issue")
    public String createIssue(@RequestBody Issue issue) throws IOException {
        return service.createIssue(issue);
    }

    /**
     *
     * @param sourceProject name of the source project
     * @param destinationProject name of the destination project
     * @return true - if success, false if failed
     */
    @GetMapping("/move-issues/from/{source}/to/{destination}")
    public List<Issue> moveIssuesToProject(@PathVariable("source") String sourceProject, @PathVariable("destination") String destinationProject) throws IOException {
        return service.moveIssues(sourceProject, destinationProject);
    }
}
