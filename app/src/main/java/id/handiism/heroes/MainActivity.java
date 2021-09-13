package id.handiism.heroes;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import id.handiism.heroes.model.HeroesResponseItem;
import id.handiism.heroes.service.HeroesListener;
import id.handiism.heroes.service.HeroesServices;

public class MainActivity extends AppCompatActivity {

    HeroesListener<List<HeroesResponseItem>> HeroesListener = new HeroesListener<List<HeroesResponseItem>>() {
        @Override
        public void onSuccess(List<HeroesResponseItem> items) {
            Log.d("Test", "Executed");
            for (int i = 0; i < items.size(); i++) {
                Log.d("Result: NAME --> ", items.get(i).getName());
                Log.d("Result: DEATH --> ", String.valueOf(items.get(i).getDeathYear()));
            }
        }

        @Override
        public void onFailed(String message) {
            Log.d("API Call Error: ", message);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new HeroesServices().getHeroes(HeroesListener);
    }
}