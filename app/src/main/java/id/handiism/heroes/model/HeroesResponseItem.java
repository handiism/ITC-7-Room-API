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

    @SerializedName("death_year")
    private final int deathYear;
    @SerializedName("description")
    private final String description;
    @SerializedName("ascension_year")
    private final int ascensionYear;
    @SerializedName("birth_year")
    private final String birthYear;
    @SerializedName("name")
    private String name;

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

    public String getDescription() {
        return description;
    }

    public int getAscensionYear() {
        return ascensionYear;
    }

    public String getBirthYear() {
        return birthYear;
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