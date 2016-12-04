package nontakarn.Nontakarn_restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class MySQLite {
    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final String user_table = "userTABLE";
    public static final String column_id = "_id";
    public static final String column_user = "User";
    public static final String column_password = "Password";
    public static final String column_name = "Name";

    public MySQLite(Context context){
        mySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        sqLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();
    }

    public long addNewUser(String strUser,
                           String strPassword,
                           String strName){
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_user,strUser);
        contentValues.put(column_password,strPassword);
        contentValues.put(column_name,strName);
        return sqLiteDatabase.insert(user_table, null,contentValues);
    }
}
