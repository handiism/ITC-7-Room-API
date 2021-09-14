package id.handiism.heroes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = HeroesEntity.class, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            Builder<AppDatabase> heroes_db = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "heroes_db");
            heroes_db.fallbackToDestructiveMigration();
            heroes_db.allowMainThreadQueries();
            instance = heroes_db.build();
        }
        return instance;
    }

    public abstract HeroesDAO heroesDAO();
}
