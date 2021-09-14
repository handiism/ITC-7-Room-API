package id.handiism.heroes.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HeroesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HeroesEntity heroesEntity);

    @Update
    void update(HeroesEntity heroesEntity);

    @Delete
    void delete(HeroesEntity heroesEntity);

    @Query("SELECT * FROM heroes")
    List<HeroesEntity> getAll();


}
