package com.koliadev.example.model;

/**
 * Created on 03/09/2017.
 */

public class MyItem {
  public String name;
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override public String toString() {
    return "MyItem{" + "name='" + name + '\'' + ", description='" + description + '\'' + '}';
  }
}
