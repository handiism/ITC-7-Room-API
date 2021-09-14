package id.handiism.heroes.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.handiism.heroes.R;
import id.handiism.heroes.database.AppDatabase;
import id.handiism.heroes.database.HeroesEntity;
import id.handiism.heroes.databinding.DialogItemBinding;
import id.handiism.heroes.databinding.RowItemBinding;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<HeroesEntity> list;
    private Context context;

    public Adapter(List<HeroesEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false),
                context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RowItemBinding itemBinding;
        private Context context;
        private HeroesEntity hero;

        public ViewHolder(@NonNull RowItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void onBind(HeroesEntity item) {
            hero = item;
            itemBinding.tvName.setText(item.name);
            itemBinding.rlItem.setOnClickListener(this);
        }

        public ViewHolder(RowItemBinding itemBinding, Context context) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            DialogItemBinding dialogBinding;
            if (view == itemBinding.rlItem) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.BUNDLE,hero);
                context.startActivity(intent);
            }
        }
    }
}
