package com.example.waleed.projectcar;

/**
 * Created by waleed on 5/6/2017.
 */
public class customer  {
    public int ID;
    public String Name;
    public String emial,password,numberVisa;
    public customer(int Id,String name,String email,String password, String numbervisa)
    {
        this.emial=email;
        this.ID=Id;
        this.Name=name;
        this.password=password;
        this.numberVisa=numbervisa;
    }
    public customer(String email,String password)
    {
        this.password=password;
        this.emial=email;


    }
    public void setID(int id)
    {
        this.ID=id;
    }
    public  int getId()
    {
        return  this.ID;
    }
    public void setName(String name)
    {
        this.Name=name;
    }
    public  String getName()
    {
        return  this.Name;
    }
    public  void setEmial(String email)
    {
        this.emial=email;
    }
    public  String getEmial()
    {
        return this.emial;
    }
    public  void setPassword(String password)
    {
        this.password=password;

    }
    public String getPassword()
    {
        return  this.password;
    }
    public  void  setNumberVisa(String visa)
    {
        this.numberVisa=visa;
    }
    public  String getNumberVisa()
    {
        return  this.numberVisa;
    }

}