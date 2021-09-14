package id.handiism.heroes.service;

import java.util.List;

import id.handiism.heroes.model.HeroesResponseItem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroesAPI {
    String URL_BASE = "https://indonesia-public-static-api.vercel.app";

    @GET("/api/heroes")
    Call<List<HeroesResponseItem>> getAllHeroes();
}
