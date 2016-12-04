package nontakarn.Nontakarn_restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class OrderTABLE {

    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqliteDatabase, readSqliteDatabase;

    public static final String ORDER_TABLE = "orderTABLE";
    public static final String COLUMN_ID_ORDER = "_id";
    public static final String COLUMN_OFFICER = "Officer";
    public static final String COLUMN_DESK = "Desk";
    public static final String COLUMN_FOOD = "Food";
    public static final String COLUMN_ITEM = "Item";

    public OrderTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqliteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqliteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addOrder(String strOfficer, String strDesk, String strFood, String strItem ){
        ContentValues objcontentValues = new ContentValues();
        objcontentValues.put(COLUMN_OFFICER, strOfficer);
        objcontentValues.put(COLUMN_DESK, strDesk);
        objcontentValues.put(COLUMN_FOOD, strFood);
        objcontentValues.put(COLUMN_ITEM, strItem);
        return  readSqliteDatabase.insert(ORDER_TABLE, null, objcontentValues);
    }   //Add New Food
}
