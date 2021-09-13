package id.handiism.heroes.service;

import java.util.List;

import id.handiism.heroes.model.HeroesResponse;
import id.handiism.heroes.model.HeroesResponseItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesServices {
    private Retrofit retrofit = null;

    public HeroesAPI getAPI() {
        if (retrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(HeroesAPI.URL_BASE);
            builder.addConverterFactory(GsonConverterFactory.create());
            retrofit = builder.build();
        }
        return retrofit.create(HeroesAPI.class);
    }

    public void getHeroes(final HeroesListener<List<HeroesResponseItem>> listener) {
        getAPI().getAllHeroes().enqueue(new Callback<HeroesResponse>() {
            @Override
            public void onResponse(Call<HeroesResponse> call, Response<HeroesResponse> response) {
                HeroesResponse data = response.body();

                if (data != null) {
                    listener.onSuccess(data.getHeroesResponse());
                }
            }

            @Override
            public void onFailure(Call<HeroesResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}