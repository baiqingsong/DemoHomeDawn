package com.dawn.demohomedawn.model;

/**
 * Created by 90449 on 2017/8/3.
 */

public class ProductModel {
    private int id;
    private String name;
    private String description;
    private int state;

    public ProductModel(int id, String name, String description, int state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getState() {
        return state;
    }
}
