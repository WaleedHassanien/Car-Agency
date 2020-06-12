package com.example.waleed.projectcar;

/**
 * Created by waleed on 5/6/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by waleed on 5/2/2017.
 */
public class DB_manager extends SQLiteOpenHelper {
    static String DB_NAME="DB_Database";
    static int DB_VERSION=1;
    public DB_manager(Context context)
    {
        super(context ,DB_NAME,null,DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table customer (customerId INTEGER PRIMARY KEY AUTOINCREMENT ,customerName varchar ,customerEmail varchar ,customerPassword varchar , customerVisa varchar)");
        db.execSQL("create table car (carId INTEGER PRIMARY KEY AUTOINCREMENT ,carName varchar, carKind varchar,carPrice varchar,carModel varchar ,carMedeIn varchar)");
        db.execSQL("create table admin (adminemail varchar,adminpassword varchar)");
        DefultData(db);

    }
    public  void DefultData(SQLiteDatabase db)
    {
        db.execSQL("insert into customer values(null,' Ahmed','ahmed@gmail.com', '123',1234567)");
        db.execSQL("insert into customer values(null,' mohamed','mohamed@gmail.com', '123',1234567)");
        db.execSQL("insert into customer values(null,' mahmoud','mahmoud@gmail.com', '123',1234567)");
        db.execSQL("insert into customer values(null,' khald','khald@gmail.com', '123',1234567)");
        db.execSQL("insert into customer values(null,' omar','omar@gmail.com', '123',1234567)");
        db.execSQL("insert into customer values(null,' hany','hany@gmail.com', '123',1234567)");

        db.execSQL("insert into car values (null, 'verna', 'sport', 1000000,'verna2017','Jaban')");
        db.execSQL("insert into car values (null, 'marcedce', 'sport', 1000000,'marcedce2017','Germman')");
        db.execSQL("insert into car values (null, 'Bmw', 'sport', 1000000,'Bmw2017','Germman')");
        db.execSQL("insert into car values (null, 'Hendae', 'sport', 1000000,'endae2017','Kore')");
        db.execSQL("insert into car values (null, 'nessan', 'sport', 1000000,'nessan2017','chania')");
        db.execSQL("insert into car values (null, 'scoda', 'sport',1000000,'scodai2017','kory')");
        db.execSQL("insert into car values (null, 'chevorelate', 'sport',1000000,'chevorelate2017','kory')");

        db.execSQL("insert into admin values ('a','123')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean checkAdmin(SQLiteDatabase db,String Email,String pass)

    {

        Cursor cur=db.rawQuery("SELECT * FROM admin where adminemail ='"+Email+"' and adminpassword='"+pass+"' ",null);
        if(cur.getCount()>0)
        {
            return  true;
        }
        else {
            return  false;
        }

    }
    //for login Customer
    public boolean checkCustomer(SQLiteDatabase db,String Email,String pass)

    {

        Cursor cur=db.rawQuery("SELECT * FROM customer where customerEmail ='"+Email+"' and customerPassword='"+pass+"' ",null);
        if(cur.getCount()>0)
        {
            return  true;
        }
        else {
            return  false;
        }

    }
    public Cursor getcar(SQLiteDatabase db ,int id)
    {
        return db.rawQuery("SELECT  carName ,carKind,carPrice,carModel,carMedeIn  FROM car where carId= '"+id+"'  ",null);
    }
    public void addcustomer(SQLiteDatabase db, String name, String password, String email, String visa)
    {
        ContentValues customer =new ContentValues();
        customer.put("customerName",name);
        customer.put("customerPassword",password);
        customer.put("customerEmail",email);
        customer.put("customerVisa",visa);
        db.insert("customer",null,customer);
    }
    public void addcar(SQLiteDatabase db, String model, String madeIn, String price, String kind,String name)
    {
        ContentValues car =new ContentValues();
        car.put("carName",name);
        car.put("carKind",kind);
        car.put("carPrice",price);
        car.put("carModel",model);
        car.put("carMedeIn",madeIn);
        db.insert("car",null,car);
    }
    public Cursor getCars()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("SELECT  carName FROM car",null);
    }
    public void updateCar(String model, String madeIn, String price, String kind,String name,int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query="update car set carName='"+name+"', carKind ='"+kind+"',carPrice= '"+price+"',carModel= '"+model+"',carMedeIn= '"+madeIn+"'  where carId = '"+id+"'";
        db.execSQL(query);
        db.close();

    }
    public Cursor getAllCustomer()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("SELECT  customerName FROM customer ",null);
    }
    public  void delete_car( int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="delete from car where carId = '"+id+"'";
        db.execSQL(query);
        db.close();

    }
    public  void delete_Customer( int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="delete from customer where customerId = '"+id+"'";
        db.execSQL(query);
        db.close();

    }
}
