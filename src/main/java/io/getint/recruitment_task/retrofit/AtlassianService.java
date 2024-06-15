package io.getint.recruitment_task.retrofit;

import com.google.gson.Gson;
import io.getint.recruitment_task.configuration.PropertiesConfig;
import io.getint.recruitment_task.retrofit.dto.Fields;
import io.getint.recruitment_task.retrofit.dto.Issue;
import io.getint.recruitment_task.retrofit.dto.Project;
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



    private String getAuthentication() {
        String base = propertiesConfig.getUserName() + ":" + propertiesConfig.getApiKey();
        String authentication = "Basic " + Base64.getEncoder().encodeToString(base.getBytes());

        return authentication;
    }
}
