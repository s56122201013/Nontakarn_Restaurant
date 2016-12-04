package nontakarn.Nontakarn_restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class FoodTABLE {

    //Explicit
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqliteDatabase, readSqliteDatabase;

    public static final String FOOD_TABLE = "foodTABLE";
    public static final String COLUMN_ID_FOOD = "_id";
    public static final String COLUMN_FOOD = "Food";
    public static final String COLUMN_SOURCE = "Source";
    public static final String COLUMN_PRICE = "Price";

        public FoodTABLE(Context context){
            objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
            writeSqliteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
            readSqliteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
        }   //Constructor

        public long addNewFood(String strFood, String strSource, String strPrice){
            ContentValues objcontentValues = new ContentValues();
            objcontentValues.put(COLUMN_FOOD, strFood);
            objcontentValues.put(COLUMN_SOURCE, strSource);
            objcontentValues.put(COLUMN_PRICE, strPrice);
            return  readSqliteDatabase.insert(FOOD_TABLE, null, objcontentValues);
        }   //Add New Food
}   //Main Class
