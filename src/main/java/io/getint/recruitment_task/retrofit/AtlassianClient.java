package io.getint.recruitment_task.retrofit;

import io.getint.recruitment_task.retrofit.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AtlassianClient {

    @GET("/rest/api/3/project/")
    Call<List<Project>> getAllProjects(@Header("Authorization") String auth);

    @GET("/rest/api/3/issue/{id}")
    Call<Issue> getIssueDetails(@Header("Authorization") String auth, @Path(value = "id") Integer id);

    @GET("/rest/api/3/project/search")
    Call<Values> getProjectDetails(@Header("Authorization")String auth, @Query("query") String projectName);

    @POST("/rest/api/3/issue")
    Call<Void> createIssue(@Header("Authorization") String auth, @Body Issue issue);

    @POST("/rest/api/3/search/id")
    Call<IssuesFromProject> getIssuesFromProject(@Header("Authorization") String auth, @Body Filter filter);

    @DELETE("/rest/api/3/issue/{id}")
    Call<Void> deleteIssue(@Header("Authorization") String auth, @Path(value = "id") Integer id);

}
