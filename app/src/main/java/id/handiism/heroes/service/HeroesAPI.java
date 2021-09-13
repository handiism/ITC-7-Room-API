package id.handiism.heroes.service;

import id.handiism.heroes.model.HeroesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroesAPI {
    String URL_BASE = "https://indonesia-public-static-api.vercel.app";

    @GET("/api/heroes")
    Call<HeroesResponse> getAllHeroes();
}
