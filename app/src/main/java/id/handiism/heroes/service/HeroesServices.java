package id.handiism.heroes.service;

import androidx.annotation.NonNull;

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

    public HeroesAPI getHeroesAPI() {
        if (retrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(HeroesAPI.URL_BASE);
            builder.addConverterFactory(GsonConverterFactory.create());
            retrofit = builder.build();
        }
        return retrofit.create(HeroesAPI.class);
    }

    public void getAllHeroes(final HeroesListener<List<HeroesResponseItem>> listener) {
        getHeroesAPI().getAllHeroes().enqueue(new Callback<List<HeroesResponseItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<HeroesResponseItem>> call,
                                   @NonNull Response<List<HeroesResponseItem>> response) {
                HeroesResponse data = new HeroesResponse();
                data.setHeroesResponse(response.body());
                listener.onSuccess(data.getHeroesResponse());
            }

            @Override
            public void onFailure(@NonNull Call<List<HeroesResponseItem>> call,
                                  @NonNull Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
