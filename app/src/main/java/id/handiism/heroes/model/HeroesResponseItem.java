package id.handiism.heroes.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class HeroesResponseItem implements Parcelable {

    public static final Creator<HeroesResponseItem> CREATOR = new Creator<HeroesResponseItem>() {
        @Override
        public HeroesResponseItem createFromParcel(Parcel in) {
            return new HeroesResponseItem(in);
        }

        @Override
        public HeroesResponseItem[] newArray(int size) {
            return new HeroesResponseItem[size];
        }
    };
    @SerializedName("name")
    private String name;
    @SerializedName("death_year")
    private int deathYear;
    @SerializedName("description")
    private String description;
    @SerializedName("ascension_year")
    private int ascensionYear;
    @SerializedName("birth_year")
    private String birthYear;

    protected HeroesResponseItem(Parcel in) {
        name = in.readString();
        deathYear = in.readInt();
        description = in.readString();
        ascensionYear = in.readInt();
        birthYear = in.readString();
    }

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

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(deathYear);
        parcel.writeString(description);
        parcel.writeInt(ascensionYear);
        parcel.writeString(birthYear);
    }
}