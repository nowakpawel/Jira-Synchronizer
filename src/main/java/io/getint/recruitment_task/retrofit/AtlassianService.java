package io.getint.recruitment_task.retrofit;

import io.getint.recruitment_task.configuration.PropertiesConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtlassianService {
    private final PropertiesConfig propertiesConfig;
    private final AtlassianClient client;

    public List<ProjectDto> getProjects() throws IOException {
        String base = propertiesConfig.getUserName() + ":" + propertiesConfig.getApiKey();

        String authentication = "Basic " + Base64.getEncoder().encodeToString(base.getBytes());

        Response<List<ProjectDto>> response = client.getAllProjects(authentication).execute();

        if (response.isSuccessful()) {
           return response.body();
        } else {
            throw new RuntimeException("Exception occurred");
        }
    }
}
