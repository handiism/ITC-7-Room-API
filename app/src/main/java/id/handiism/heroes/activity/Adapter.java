package id.handiism.heroes.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.handiism.heroes.database.HeroesEntity;
import id.handiism.heroes.databinding.RowItemBinding;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final List<HeroesEntity> list;
    private final Context context;

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

    public static class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        private final RowItemBinding itemBinding;
        private final Context context;
        private HeroesEntity hero;

        public ViewHolder(RowItemBinding itemBinding, Context context) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            this.context = context;
        }

        public void onBind(HeroesEntity item) {
            hero = item;
            itemBinding.tvName.setText(item.name);
            itemBinding.rlItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view == itemBinding.rlItem) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.BUNDLE, hero);
                context.startActivity(intent);
            }
        }
    }
}
