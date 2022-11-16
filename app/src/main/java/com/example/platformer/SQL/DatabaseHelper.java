package com.example.platformer.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.platformer.Model.Leaderboard;
import com.example.platformer.Model.Level;
import com.example.platformer.Model.LevelPlayed;
import com.example.platformer.Model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";
    // User table name
    private static final String TABLE_USER = "user";
    // Levels table name
    private static final String TABLE_LEVELS = "Levels";
    // LevelPlayed table name
    private static final String TABLE_LEVELPLAYED = "LevelPlayed";

    // LeaderBoard table name
    private static final String TABLE_LEADERBOARD = "LEADERBOARD";



    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_CONTACT = "user_contact";

    // Levels Table Columns names
    private static final String COLUMN_LEVEL_ID = "Level_id";
    private static final String COLUMN_PLAYER_NAME = "Player_name";
    private static final String COLUMN_LEVEL_NAME = "Level_name";
    private static final String COLUMN_LEVEL_DIFFICULTY = "Level_difficulty";
    private static final String COLUMN_LEVEL_HIGHSCORE = "Level_highscore";

    // LevelPlayed Table Columns names
    private static final String COLUMN_LEVELPLAYED_ID = "LevelPlayed_id";
    private static final String COLUMN_LEVELPLAYED_NAME = "LevelPlayed_name";
    private static final String COLUMN_LEVELPLAYED_DIFFICULTY = "LevelPlayed_difficulty";
    private static final String COLUMN_LEVELPLAYED_TIMESPLAYED = "LevelPlayed_TimesPLayed";

    // LeaderBoard Table Columns names
    private static final String COLUMN_LEADERBOARD_ID = "Leaderboard_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BESTSCORE = "BestScore";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_CONTACT + " TEXT" + ")";

    // create table sql query
    private String CREATE_LEVELS_TABLE = "CREATE TABLE " + TABLE_LEVELS + "("
            + COLUMN_LEVEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PLAYER_NAME + " TEXT,"
            + COLUMN_LEVEL_NAME + " TEXT," + COLUMN_LEVEL_DIFFICULTY + " TEXT," + COLUMN_LEVEL_HIGHSCORE+ " TEXT" + ")";

    // create table sql query
    private String CREATE_LEVELPLAYED_TABLE = "CREATE TABLE " + TABLE_LEVELPLAYED + "("
            + COLUMN_LEVELPLAYED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_LEVELPLAYED_NAME + " TEXT,"
            + COLUMN_LEVELPLAYED_DIFFICULTY + " TEXT," + COLUMN_LEVELPLAYED_TIMESPLAYED + " TEXT" + ")";

    // create table sql query
    private String CREATE_LEADERBOARD_TABLE = "CREATE TABLE " + TABLE_LEADERBOARD + "("
            + COLUMN_LEADERBOARD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT,"
            + COLUMN_BESTSCORE + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    // drop table sql query
    private String DROP_LEVELS_TABLE = "DROP TABLE IF EXISTS " + TABLE_LEVELS;

    // drop table sql query
    private String DROP_LEVELPLAYED_TABLE = "DROP TABLE IF EXISTS " + TABLE_LEVELPLAYED;

    // drop table sql query
    private String DROP_LEADERBOARD_TABLE = "DROP TABLE IF EXISTS " + TABLE_LEADERBOARD;


    /*Constructor*/
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_LEVELS_TABLE);
        db.execSQL(CREATE_LEVELPLAYED_TABLE);
        db.execSQL(CREATE_LEADERBOARD_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_LEVELS_TABLE);
        db.execSQL(DROP_LEVELPLAYED_TABLE);
        db.execSQL(DROP_LEADERBOARD_TABLE);
        // Create tables again
        onCreate(db);
    }
    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**This method is to create user record */
    public void addUser(String UserName, String UserEmail, String UserPassword, String UserContact) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(COLUMN_USER_NAME, UserName);
        values.put(COLUMN_USER_EMAIL, UserEmail);
        values.put(COLUMN_USER_PASSWORD, UserPassword);
        values.put(COLUMN_USER_CONTACT, UserContact);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_USER, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }
    /**This method is to create level record */
    public void addLevel( String PlayerName, String LevelName, String LevelDifficulty, String LevelHighscore) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(COLUMN_PLAYER_NAME, PlayerName);
        values.put(COLUMN_LEVEL_NAME, LevelName);
        values.put(COLUMN_LEVEL_DIFFICULTY, LevelDifficulty);
        values.put(COLUMN_LEVEL_HIGHSCORE, LevelHighscore);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_LEVELS, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }
    /**This method is to create levelplayed record */
    public void addLevelPlayed(String LevelPlayed, String LevelPlayedDifficulty, String TimesPlayed) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(COLUMN_LEVELPLAYED_NAME, LevelPlayed);
        values.put(COLUMN_LEVELPLAYED_DIFFICULTY, LevelPlayedDifficulty);
        values.put(COLUMN_LEVELPLAYED_TIMESPLAYED, TimesPlayed);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_LEVELPLAYED, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }

    /**This method is to create leaderboard record */
    public void addLeaderboard(String Name, String Bestscore) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(COLUMN_NAME, Name);
        values.put(COLUMN_BESTSCORE, Bestscore);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_LEADERBOARD, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

    }
    //This method to update user record
    public void updateUser(String originalUserName, String userName, String userEmail,
                           String userContact, String userPassword) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(COLUMN_USER_NAME, userName);
        values.put(COLUMN_USER_EMAIL, userEmail);
        values.put(COLUMN_USER_PASSWORD, userPassword);
        values.put(COLUMN_USER_CONTACT, userContact);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_USER, values,"user_name=?", new String[]{originalUserName});
        db.close();
    }

    //This method is to delete user record
    public void deleteUser(String userName) {
        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record
        db.delete(TABLE_USER, "user_name=?", new String[]{userName});
        db.close();
    }
    //This method to check user exist or not
    public boolean checkUser(String email) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";
        // selection argument
        String[] selectionArgs = {email};
        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
    public ArrayList<User> readUsers() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorUsers = db.rawQuery("Select * from "+TABLE_USER, null);

        // on below line we are creating a new array list.
        ArrayList<User> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorUsers.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new User(cursorUsers.getString(1),
                        cursorUsers.getString(2),
                        cursorUsers.getString(3),
                        cursorUsers.getString(4)));
            } while (cursorUsers.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorUsers.close();
        return courseModalArrayList;
    }
    public ArrayList<Level> readLevels() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorLevels = db.rawQuery("Select * from "+TABLE_LEVELS, null);

        // on below line we are creating a new array list.
        ArrayList<Level> levelsModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorLevels.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                levelsModalArrayList.add(new Level(cursorLevels.getString(1),
                        cursorLevels.getString(2),
                        cursorLevels.getString(3),
                        cursorLevels.getString(4)));
            } while (cursorLevels.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorLevels.close();
        return levelsModalArrayList;
    }
    public ArrayList<LevelPlayed> readLevelplayed() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorLevels = db.rawQuery("Select * from "+TABLE_LEVELPLAYED, null);

        // on below line we are creating a new array list.
        ArrayList<LevelPlayed> levelPlayedModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorLevels.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                levelPlayedModalArrayList.add(new LevelPlayed(cursorLevels.getString(1),
                        cursorLevels.getString(2),
                        cursorLevels.getString(3)));
            } while (cursorLevels.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorLevels.close();
        return levelPlayedModalArrayList;
    }
    public ArrayList<Leaderboard> readLeaderboard() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorLeaderboard = db.rawQuery("Select * from "+TABLE_LEADERBOARD, null);

        // on below line we are creating a new array list.
        ArrayList<Leaderboard> leaderboardModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorLeaderboard.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                leaderboardModalArrayList.add(new Leaderboard(cursorLeaderboard.getString(1),
                        cursorLeaderboard.getString(2)));
            } while (cursorLeaderboard.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorLeaderboard.close();
        return leaderboardModalArrayList;
    }
    /**
     * This method to check user exist or not
     */
    public boolean checkUser(String email, String password) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";
        // selection arguments
        String[] selectionArgs = {email, password};
        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
}
