package id.handiism.heroes.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.handiism.heroes.database.AppDatabase;
import id.handiism.heroes.database.HeroesEntity;
import id.handiism.heroes.databinding.ActivityMainBinding;
import id.handiism.heroes.model.HeroesResponseItem;
import id.handiism.heroes.service.HeroesListener;
import id.handiism.heroes.service.HeroesServices;

public class MainActivity extends AppCompatActivity {
    private final HeroesListener<List<HeroesResponseItem>> HeroesListener;
    private final String TAG = "API Call";

    {
        HeroesListener = new HeroesListener<List<HeroesResponseItem>>() {

            @Override
            public void onSuccess(List<HeroesResponseItem> items) {
                Log.d("Test", "Executed");
                for (int i = 0; i < items.size(); i++) {
                    AppDatabase appDatabase = AppDatabase.getInstance(MainActivity.this);
                    appDatabase.heroesDAO().insert(new HeroesEntity(items.get(i)));
                    Log.d(TAG, items.get(i).toString());
                }
            }

            @Override
            public void onFailed(String message) {
                Log.d(TAG, message);
            }

        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase appDatabase = AppDatabase.getInstance(MainActivity.this);
        new HeroesServices().getAllHeroes(HeroesListener);

        binding.rvContainer.setHasFixedSize(true);
        binding.rvContainer.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                RecyclerView.VERTICAL,
                false));
        binding.rvContainer.setAdapter(new Adapter(appDatabase.heroesDAO().getAll(), this));
    }

}