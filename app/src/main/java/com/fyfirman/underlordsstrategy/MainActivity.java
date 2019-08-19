package com.fyfirman.underlordsstrategy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.fyfirman.underlordsstrategy.heroesrecycleview.adapter.ListHeroAdapter;
import com.fyfirman.underlordsstrategy.heroesrecycleview.model.Hero;
import com.fyfirman.underlordsstrategy.heroesrecycleview.model.HeroesData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {
  private RecyclerView rvHeroes;
  private ArrayList<Hero> list = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    NavigationView navigationView = findViewById(R.id.nav_view);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();
    navigationView.setNavigationItemSelectedListener(this);

    rvHeroes = findViewById(R.id.rv_heroes);
    rvHeroes.setHasFixedSize(true);

    list.addAll(HeroesData.getListData());
    showRecyclerList();
  }

  private void showRecyclerList(){
    rvHeroes.setLayoutManager(new LinearLayoutManager(this));
    ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
    rvHeroes.setAdapter(listHeroAdapter);

    listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
      @Override
      public void onItemClicked(Hero data) {
        moveToHeroDetail(data);
      }
    });
  }

  private void moveToHeroDetail(Hero hero){
    Intent showDetail = new Intent(MainActivity.this, DetailHero.class);
    showDetail.putExtra("heroName",hero.getName());
    showDetail.putExtra("heroImageUrl",hero.getImage());
    showDetail.putExtra("heroRaces",hero.getRaces());
    showDetail.putExtra("heroAlliances",hero.getAlliance());
    showDetail.putExtra("heroTier",hero.getTier());
    showDetail.putExtra("heroLore",hero.getLore());

    startActivity(showDetail);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.nav_hero) {

    } else if (id == R.id.nav_contact) {
      Intent moveToContact = new Intent(MainActivity.this, About.class);
      startActivity(moveToContact);
    }

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }
}
