package com.fyfirman.underlordsstrategy.heroesrecycleview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fyfirman.underlordsstrategy.R;
import com.fyfirman.underlordsstrategy.heroesrecycleview.model.Hero;
import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {

  private ArrayList<Hero> listHero;

  private OnItemClickCallback onItemClickCallback;

  public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
    this.onItemClickCallback = onItemClickCallback;
  }

  public ListHeroAdapter(ArrayList<Hero> list) {
    this.listHero = list;
  }

  @NonNull
  @Override
  public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater
        .from(viewGroup.getContext()).inflate(R.layout.item_row_hero, viewGroup, false);
    return new ListViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, int position) {
    Hero hero = listHero.get(position);
    Glide.with(listViewHolder.itemView.getContext())
        .load(hero.getImage())
        .apply(new RequestOptions().override(55, 55))
        .into(listViewHolder.imgPhoto);
    listViewHolder.tvName.setText(hero.getName());
    listViewHolder.tvAlliance.setText(hero.getRaces() + " | "+ hero.getAlliance());
    listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onItemClickCallback.onItemClicked(listHero.get(listViewHolder.getAdapterPosition()));
      }
    });
  }

  @Override
  public int getItemCount() {
    return listHero.size();
  }

  public class ListViewHolder extends ViewHolder {
    ImageView imgPhoto;
    TextView tvName, tvAlliance;

    ListViewHolder(View itemView){
      super(itemView);
      imgPhoto = itemView.findViewById(R.id.img_item_photo);
      tvName = itemView.findViewById(R.id.tv_item_name);
      tvAlliance = itemView.findViewById(R.id.tv_item_from);
    }

  }

  public interface OnItemClickCallback {
    void onItemClicked(Hero data);
  }
}
