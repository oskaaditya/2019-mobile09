package id.ac.polinema.recyclerviewsangatsederhana.adapters;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.polinema.recyclerviewsangatsederhana.R;
import id.ac.polinema.recyclerviewsangatsederhana.models.SuperHero;


public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.MyViewFolder> {
    List<SuperHero> heroList;

    public SuperHeroAdapter(Application application, List<SuperHero> heroList) {
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public SuperHeroAdapter.MyViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View superHeroView = layoutInflater.inflate(R.layout.item_super_hero,parent,false);
        MyViewFolder viewHolder = new MyViewFolder(superHeroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroAdapter.MyViewFolder holder, int position) {
        SuperHero hero = heroList.get(position);
        int rgambar = hero.getGambar();
        holder.heroName.setText(hero.getHeroName());
        holder.gambar.setImageResource(rgambar);
    }

    @Override
    public int getItemCount() {
        return (heroList != null) ? heroList.size() : 0;
    }

    public class MyViewFolder extends RecyclerView.ViewHolder {
        public TextView heroName;
        public ImageView gambar;
        public MyViewFolder(View itemView) {
            super(itemView);
            heroName = itemView.findViewById(R.id.heroName);
            gambar = itemView.findViewById(R.id.gambar);
        }
    }
}
