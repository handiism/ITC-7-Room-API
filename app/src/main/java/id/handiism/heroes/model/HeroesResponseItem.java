package id.handiism.heroes.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class HeroesResponseItem {

    @SerializedName("name")
    private String name;

    @SerializedName("death_year")
    private int deathYear;

    @SerializedName("description")
    private String description;

    @SerializedName("ascension_year")
    private int ascensionYear;

    @SerializedName("birth_year")
    private int birthYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAscensionYear() {
        return ascensionYear;
    }

    public void setAscensionYear(int ascensionYear) {
        this.ascensionYear = ascensionYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @NonNull
    @Override
    public String toString() {
        return
                "HeroesResponseItem{" +
                        "name = '" + name + '\'' +
                        ",death_year = '" + deathYear + '\'' +
                        ",description = '" + description + '\'' +
                        ",ascension_year = '" + ascensionYear + '\'' +
                        ",birth_year = '" + birthYear + '\'' +
                        "}";
    }
}