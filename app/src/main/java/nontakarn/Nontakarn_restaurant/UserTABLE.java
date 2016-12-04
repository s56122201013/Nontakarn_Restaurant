package nontakarn.Nontakarn_restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class UserTABLE {

    //Explicit
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqliteDatabase, readSqliteDatabase;

    public static final String USER_TABLE = "userTABLE";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_USER = "User";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_NAME = "Name";

    public UserTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqliteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqliteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }   //Constructor

    public long addNewUser(String strUser, String strPassword, String strName){
        ContentValues objcontentValues = new ContentValues();
        objcontentValues.put(COLUMN_USER, strUser);
        objcontentValues.put(COLUMN_PASSWORD, strPassword);
        objcontentValues.put(COLUMN_NAME, strName);
        return  readSqliteDatabase.insert(USER_TABLE, null, objcontentValues);
    }   //Add New User
}   //Main Class
