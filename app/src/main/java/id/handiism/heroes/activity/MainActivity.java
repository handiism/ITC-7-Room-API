package id.handiism.heroes.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.handiism.heroes.R;
import id.handiism.heroes.database.AppDatabase;
import id.handiism.heroes.database.HeroesEntity;
import id.handiism.heroes.databinding.ActivityMainBinding;
import id.handiism.heroes.model.HeroesResponse;
import id.handiism.heroes.model.HeroesResponseItem;
import id.handiism.heroes.service.HeroesAPI;
import id.handiism.heroes.service.HeroesListener;
import id.handiism.heroes.service.HeroesServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<HeroesResponseItem> dataArrayList;
    private static List<HeroesResponseItem> dataAsArrayList;
    private ActivityMainBinding binding;

    final HeroesListener<List<HeroesResponseItem>> HeroesListener = new HeroesListener<List<HeroesResponseItem>>() {
        AppDatabase appDatabase;
        @Override
        public void onSuccess(List<HeroesResponseItem> items) {
            Log.d("Test", "Executed");
            for (int i = 0; i < items.size(); i++) {
                Log.d("Result", items.get(i).toString());
                appDatabase = AppDatabase.getInstance(MainActivity.this);
                appDatabase.heroesDAO().insert(new HeroesEntity(items.get(i)));
            }
        }

        @Override
        public void onFailed(String message) {
            Log.d("API Call Error: ", message);
        }

        public AppDatabase getAppDatabase() {
            return appDatabase;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppDatabase appDatabase = AppDatabase.getInstance(MainActivity.this);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // getDataFromAPI();

        /*@BISA
        loadAllHeroes();*/

         new HeroesServices().getAllHeroes(HeroesListener);

         binding.rvContainer.setHasFixedSize(true);
         binding.rvContainer.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                 RecyclerView.VERTICAL,
                 false));
         binding.rvContainer.setAdapter(new Adapter(appDatabase.heroesDAO().getAll(),this));
    }

    /*@BISA
    private void loadAllHeroes() {
        dataArrayList = new ArrayList<>();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(HeroesAPI.URL_BASE);
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        HeroesAPI heroesAPI = retrofit.create(HeroesAPI.class);
        Call<List<HeroesResponseItem>> call = heroesAPI.getAllHeroes();
        call.enqueue(new Callback<List<HeroesResponseItem>>() {
            @Override
            public void onResponse(Call<List<HeroesResponseItem>> call, Response<List<HeroesResponseItem>> response) {
                dataArrayList = response.body();
                for (int i = 0; i < dataArrayList.size(); i++) {
                    Log.d("API Call Success -> ",dataArrayList.get(i).toString());
                }
            }

            @Override
            public void onFailure(Call<List<HeroesResponseItem>> call, Throwable t) {
                Log.d("API Call", t.getMessage());
            }
        });
    }*/


    /*private void getDataFromAPI() {
        HeroesServices.endpoint().getAllHeroes().enqueue(new Callback<HeroesResponse>() {
            @Override
            public void onResponse(Call<HeroesResponse> call, Response<HeroesResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    List<HeroesResponseItem> heroes = response.body().getHeroesResponse();
                    Log.d("API Call Success -> ", heroes.toString());
                }
            }

            @Override
            public void onFailure(Call<HeroesResponse> call, Throwable t) {
                Log.d("API Call Failed", t.getMessage());
            }
        });
    }*/
}