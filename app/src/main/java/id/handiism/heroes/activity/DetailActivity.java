package id.handiism.heroes.activity;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import id.handiism.heroes.database.HeroesEntity;
import id.handiism.heroes.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    public static final String BUNDLE = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        HeroesEntity hero = getIntent().getParcelableExtra(BUNDLE);
        binding.tvName.setText(hero.name);
        binding.tvBirthYear.setText(hero.birthYear);
        binding.tvDeathYear.setText(String.valueOf(hero.deathYear));
        binding.tvAscensionYear.setText(String.valueOf(hero.ascensionYear));
        binding.tvDescription.setText(hero.description);
    }
}