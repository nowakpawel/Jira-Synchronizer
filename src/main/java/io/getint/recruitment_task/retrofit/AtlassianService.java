package io.getint.recruitment_task.retrofit;

import io.getint.recruitment_task.configuration.PropertiesConfig;
import io.getint.recruitment_task.retrofit.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AtlassianService {
    private final PropertiesConfig propertiesConfig;
    private final AtlassianClient client;

    public List<Project> getProjects() throws IOException {
        String authentication = getAuthentication();
        Response<List<Project>> response = client.getAllProjects(authentication).execute();

        if (response.isSuccessful()) {
           return response.body();
        } else {
            throw new RuntimeException("Exception occurred");
        }
    }

    public String createIssue(Issue issue) throws IOException {
        log.info(">>>> Creating issue %s".formatted(issue.toString()));

        String authentication = getAuthentication();
        Response<Void> response = client.createIssue(authentication, issue).execute();

        if (response.isSuccessful()) {
            return "Issue %s created".formatted(issue.toString());
        } else {
            throw new RuntimeException("Could not create issue %s".formatted(issue.toString()));
        }
    }

    public List<Issue> moveIssues(String sourceProject, String destinationProjectName) throws IOException {
        String authentication = getAuthentication();

        Filter filter = new Filter();
        filter.setJql("project = %s".formatted(sourceProject));

        Project destinationProject = new Project();
        Response<Values> projectResponse = client.getProjectDetails(authentication, destinationProjectName).execute();

        destinationProject.setId(projectResponse.body().getValues().get(0).getId());
        destinationProject.setKey(projectResponse.body().getValues().get(0).getKey());
        destinationProject.setName(projectResponse.body().getValues().get(0).getName());

        Response<IssuesFromProject> issuesFromProjectResponse = client.getIssuesFromProject(authentication, filter).execute();

        List<Integer> issueIds = issuesFromProjectResponse.body().getIssueIds();

        for (Integer id: issueIds) {
            Fields newFields = new Fields();
            Response<Issue> issueResponse = client.getIssueDetails(authentication, id).execute();

            newFields.setIssuetype(issueResponse.body().getFields().getIssuetype());
            newFields.setSummary(issueResponse.body().getFields().getSummary());
            newFields.setPriority(issueResponse.body().getFields().getPriority());
            newFields.setProject(destinationProject);

            Issue movedIssue = new Issue();
            movedIssue.setFields(newFields);

            client.createIssue(authentication, movedIssue).execute();

            client.deleteIssue(authentication, id).execute();
        }

        return null;
    }

    private String getAuthentication() {
        String base = propertiesConfig.getUserName() + ":" + propertiesConfig.getApiKey();
        String authentication = "Basic " + Base64.getEncoder().encodeToString(base.getBytes());

        return authentication;
    }
}
