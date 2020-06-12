package com.example.waleed.projectcar;

/**
 * Created by waleed on 5/6/2017.
 */
public class car {
    public  int id ,price;
    public String name,model,madeIn;
    public car(int id, int price ,String name,String model, String madeIn )
    {
        this.id=id;
        this.madeIn=madeIn;
        this.name=name;
        this.model=name;
        this.price=price;
    }
    public car (int id)
    {
        this.id=id;

    }
    public car ()
    {

    }
    public void  setId(int id)
    {
        this.id=id;
    }

    public int getId() {
        return this.id;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getMadeIn() {
        return this.madeIn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
