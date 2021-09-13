package id.handiism.heroes.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeroesResponse {

    @SerializedName("HeroesResponse")
    private List<HeroesResponseItem> heroesResponse;

    public List<HeroesResponseItem> getHeroesResponse() {
        return heroesResponse;
    }

    public void setHeroesResponse(List<HeroesResponseItem> heroesResponse) {
        this.heroesResponse = heroesResponse;
    }

    @NonNull
    @Override
    public String toString() {
        return
                "HeroesResponse{" +
                        "heroesResponse = '" + heroesResponse + '\'' +
                        "}";
    }
}