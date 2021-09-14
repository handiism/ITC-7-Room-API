package id.handiism.heroes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import id.handiism.heroes.R;
import id.handiism.heroes.database.HeroesEntity;
import id.handiism.heroes.databinding.ActivityDetailBinding;
import id.handiism.heroes.databinding.DialogItemBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    public static final String BUNDLE = "bundle";
    private HeroesEntity hero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hero = getIntent().getParcelableExtra(BUNDLE);
        binding.tvName.setText(hero.name);
        binding.tvBirthYear.setText(hero.birthYear);
        binding.tvDeathYear.setText(String.valueOf(hero.deathYear));
        binding.tvAscensionYear.setText(String.valueOf(hero.ascensionYear));
        binding.tvDescription.setText(hero.description);
    }
}