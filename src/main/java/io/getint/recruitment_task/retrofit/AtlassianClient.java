package io.getint.recruitment_task.retrofit;

import io.getint.recruitment_task.retrofit.dto.Filter;
import io.getint.recruitment_task.retrofit.dto.Issue;
import io.getint.recruitment_task.retrofit.dto.IssuesFromProject;
import io.getint.recruitment_task.retrofit.dto.Project;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.util.List;

public interface AtlassianClient {

    @GET("/rest/api/3/project/")
    Call<List<Project>> getAllProjects(@Header("Authorization") String auth);

    @POST("/rest/api/3/issue")
    Call<Void> createIssue(@Header("Authorization") String auth, @Body Issue issue);

    @POST("/rest/api/3/search/id")
    Call<IssuesFromProject> getIssuesFromProject(@Header("Authorization") String auth, @Body Filter filter);

}
