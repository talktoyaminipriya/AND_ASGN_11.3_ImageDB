package com.example.priya.imagedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

         /**
 13  * Created by WINDOWS 8.1 on 10/20/2016.
 14  */

     public class DBHelper extends SQLiteOpenHelper {
     public static final String DATABASE_NAME ="employeeDBName.db";
     public static final String EMPLOYEE_TABLE_NAME = "employees";
     public static final String EMPLOYEE_COLUMN_ID = "id";
     public static final String EMPLOYEEs_COLUMN_NAME = "employeeName";
     public static final String EMPLOYEEs_COLUMN_AGE = "employeeAge";
     private static final String EMPLOYEEs_COLUMN_IMAGE = "employeeImage";
   // create table
    private static final String CREATE_IMAGES_TABLE =
                         "CREATE TABLE " + EMPLOYEE_TABLE_NAME + " (" +
                                 EMPLOYEE_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                 + EMPLOYEEs_COLUMN_NAME + " text,"
                                 + EMPLOYEEs_COLUMN_AGE + " text,"
                                 + EMPLOYEEs_COLUMN_IMAGE + " BLOB NOT NULL );";

//constructor
             DBHelper(Context context){
                 super(context,DATABASE_NAME,null,1);
             }

// creates table
             @Override
     public void onCreate(SQLiteDatabase db) {

                db.execSQL(CREATE_IMAGES_TABLE);
             }


             @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                 db.execSQL("DROP TABLE IF EXISTS employees");
                 onCreate(db);
             }

// inserting data
             public boolean insertEmployee  (String employeeName, String employeeAge, String employeeSex, byte[] employeeimageInByte) {
                 SQLiteDatabase db = this.getWritableDatabase();
                 ContentValues contentValues = new ContentValues();
                 contentValues.put("employeeName", employeeName);
                 contentValues.put("employeeAge", employeeAge);
                 contentValues.put("employeeImage", employeeimageInByte);
                 db.insert("employees", null, contentValues);
                 return true;
             }


            public boolean insertEmployee  (Employee employee) {
                SQLiteDatabase db = this.getWritableDatabase();
                 ContentValues contentValues = new ContentValues();
                 contentValues.put(EMPLOYEEs_COLUMN_NAME, employee.employeeName);
                 contentValues.put(EMPLOYEEs_COLUMN_AGE, employee.employeeAge);
                contentValues.put(EMPLOYEEs_COLUMN_IMAGE, employee.employeeimageInByte);
                db.insert(EMPLOYEE_TABLE_NAME, null, contentValues);
                 return true;
             }

// Retrieves data
             public Cursor getData(int id){
                 SQLiteDatabase db = this.getReadableDatabase();
                 Cursor res =  db.rawQuery( "select * from employees where id=" + id + "", null );
                 return res;
            }


             public int numberOfRows(){
                 int numRows;
                SQLiteDatabase db = this.getReadableDatabase();


                 return numRows = (int) DatabaseUtils.queryNumEntries(db, EMPLOYEE_TABLE_NAME);
            }


             public ArrayList<Employee> getAllEmployee()
    {
                ArrayList<Employee> employeeList = new ArrayList<Employee>();
             // Select All Query
                 String selectQuery = "SELECT * FROM employees";


                SQLiteDatabase db = this.getWritableDatabase();
                Cursor cursor = db.rawQuery(selectQuery, null);
             // looping through all rows and adding to list
                 if (cursor.moveToFirst()) {
                        do {
                                 Employee employee = new Employee();
                                employee.setId(Integer.parseInt(cursor.getString(0)));
                               employee.setEmployeeName(cursor.getString(1));
                                employee.setEmployeeAge(cursor.getString(2));
                                 employee.setEmployeeimageInByte(cursor.getBlob(3));
                    // Adding contact to list
                                employeeList.add(employee);
                            } while (cursor.moveToNext());
                    }
            // close inserting data from database
                db.close();
             // return employee list
                return employeeList;


           }
 }

