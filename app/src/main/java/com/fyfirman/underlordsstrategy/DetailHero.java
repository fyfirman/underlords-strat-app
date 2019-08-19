package com.fyfirman.underlordsstrategy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fyfirman.underlordsstrategy.heroesrecycleview.model.Hero;

public class DetailHero extends AppCompatActivity {
  private String heroName;
  private String heroImageUrl;
  private String heroTier;
  private String heroRaces;
  private String heroAlliances;
  private String heroLore;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_hero);

    getHeroData();
    setDataOnLayout();
  }

  private void getHeroData(){
    Bundle dataExtra = getIntent().getExtras();
    heroName = dataExtra.getString("heroName");
    heroImageUrl = dataExtra.getString("heroImageUrl");
    heroRaces = dataExtra.getString("heroRaces");
    heroAlliances = dataExtra.getString("heroAlliances");
    heroTier = dataExtra.getString("heroTier");
    heroLore = dataExtra.getString("heroLore");
  }

  private void setDataOnLayout(){
    setHeroName();
    setHeroImage();
    setHeroRaces();
    setHeroAlliances();
    setHeroTier();
    setHeroLore();
  }

  private void setHeroName(){
    TextView heroName = findViewById(R.id.heroName);
    heroName.setText(this.heroName);
  }

  private void setHeroImage(){
    ImageView heroImage = findViewById(R.id.heroImage);

    RequestOptions options = new RequestOptions()
        .error(R.mipmap.ic_launcher_round);

    Glide.with(this).load(heroImageUrl).apply(options).into(heroImage);
  }

  public void setHeroRaces() {
    TextView heroRaces = findViewById(R.id.heroRaces);
    heroRaces.setText(this.heroRaces);
  }

  public void setHeroAlliances() {
    TextView heroAlliances = findViewById(R.id.heroAlliances);
    heroAlliances.setText("| "+ this.heroAlliances);
  }

  public void setHeroTier() {
    TextView heroTier = findViewById(R.id.heroTier);
    heroTier.setText("Tier " + this.heroTier);
  }

  public void setHeroLore() {
    TextView heroLore = findViewById(R.id.heroLore);
    heroLore.setText(this.heroLore);
  }
}
