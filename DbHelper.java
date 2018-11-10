package com.example.sois.healthcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ListView;

public class DbHelper extends SQLiteOpenHelper {
    Cursor c;

    SQLiteDatabase db;

    public static final String DATABASE_NAME = "Health.DB";
    public static final String TABLE_NAME = "contact";

    public static final String TABLE_COLUMN1 = "name";
    public static final String TABLE_COLUMN2 = "emailid";
    public static final String TABLE_COLUMN3= " doctorname ";
    public static final String TABLE_COLUMN4 = " city";
    public static final String TABLE_COLUMN5 = " password ";



    public DbHelper(Context context) {
        super(context, "mud", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        sqliteDatabase.execSQL("create table contact (  name txt  , emailid txt, doctorname txt , city txt , password txt )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

        db.execSQL("DROP TABLE IF EXISTS contact" + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertcontact( String name , String emailid , String doctorname , String city , String password ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TABLE_COLUMN1, name);
        contentValues.put(TABLE_COLUMN2, emailid);
        contentValues.put(TABLE_COLUMN3, doctorname);
        contentValues.put(TABLE_COLUMN4, city);
        contentValues.put(TABLE_COLUMN5, password);


         long v = db.insert(TABLE_NAME, null, contentValues);

        db.close();

         return true;
    }



    public boolean validate(String name , String password) {
        Log.v("validate", name);
        Log.v("validate", password);
        SQLiteDatabase db = this.getReadableDatabase();
        c = db.rawQuery(" SELECT * FROM contact  WHERE name ='" +name+ "' AND password = '"+password+"'" , null);
        if(c != null){
            if (c.getCount() > 0) {
                c.moveToNext();
                Log.d("mytag", "LOGGED IN");
                return true;
            } else {
                Log.d("mytag", "this is my tag");
            }
        }
        return false;
    }




    public String fetch(String search) {

        ListView LISTVIEW;
        //String  res =  db.rawQuery( "select Name from Registration where id="+id+"", null );
        SQLiteDatabase db = this.getReadableDatabase();
        String s1 = "SELECT * FROM contact where name = ' " +search+ " ' ";
        Cursor cursor = db.rawQuery(s1 , null);
        cursor.moveToFirst();
        //Cursor res = db.rawQuery("select Name from contacts where name=" + name+ "", null);
        if ( cursor.getCount() > 0) {

            String name = cursor.getString(cursor.getColumnIndex( " name "));
            cursor.close();
            return name;
            //res.moveToFirst();
            //return res.getString(res.getColumnIndex("name"));
        } else{
             cursor.close();
             return null;

        }

    }
}
