package com.fyfirman.underlordsstrategy.heroesrecycleview.model;

public class Hero {
  private String name;
  private String image;
  private String tier;
  private String races;
  private String alliance;
  private String lore;

  public String getLore() {
    return lore;
  }

  public void setLore(String lore) {
    this.lore = lore;
  }

  public String getTier() {
    return tier;
  }

  public void setTier(String tier) {
    this.tier = tier;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRaces() {
    return races;
  }

  public void setRaces(String races) {
    this.races = races;
  }

  public String getAlliance() {
    return alliance;
  }

  public void setAlliance(String alliance) {
    this.alliance = alliance;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


}
