package id.handiism.heroes.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import id.handiism.heroes.model.HeroesResponseItem;

@Entity(tableName = "heroes")
public class HeroesEntity implements Parcelable {
    public static final Creator<HeroesEntity> CREATOR = new Creator<HeroesEntity>() {
        @Override
        public HeroesEntity createFromParcel(Parcel in) {
            return new HeroesEntity(in);
        }

        @Override
        public HeroesEntity[] newArray(int size) {
            return new HeroesEntity[size];
        }
    };
    @NonNull
    @PrimaryKey
    public String name = "";
    @ColumnInfo(name = "death_year")
    public int deathYear;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "ascension_year")
    public int ascensionYear;
    @ColumnInfo(name = "birth_year")
    public String birthYear;

    public HeroesEntity() {
    }

    @Ignore
    public HeroesEntity(HeroesResponseItem item) {
        this.name = item.getName();
        this.deathYear = item.getDeathYear();
        this.description = item.getDescription();
        this.ascensionYear = item.getAscensionYear();
        this.birthYear = item.getBirthYear();
    }

    protected HeroesEntity(Parcel in) {
        name = in.readString();
        deathYear = in.readInt();
        description = in.readString();
        ascensionYear = in.readInt();
        birthYear = in.readString();
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
