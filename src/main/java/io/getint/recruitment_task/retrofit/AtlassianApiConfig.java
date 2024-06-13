package io.getint.recruitment_task.retrofit;

import io.getint.recruitment_task.configuration.PropertiesConfig;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
@AllArgsConstructor
public class AtlassianApiConfig {
   private final PropertiesConfig propertiesConfig;

    @Bean
    public AtlassianClient getClient() {
        OkHttpClient httpClient = new OkHttpClient();


        return new Retrofit.Builder()
                .baseUrl(propertiesConfig.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AtlassianClient.class);
    }
}
