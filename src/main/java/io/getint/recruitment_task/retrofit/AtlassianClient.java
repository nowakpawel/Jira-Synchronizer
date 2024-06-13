package io.getint.recruitment_task.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.List;

public interface AtlassianClient {

    @GET("/rest/api/3/project/")
    Call<List<ProjectDto>> getAllProjects(@Header("Authorization") String auth);

}
