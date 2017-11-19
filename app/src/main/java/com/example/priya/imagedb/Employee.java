package com.example.priya.imagedb;

/**
 * Created by Priya on 11/19/2017.
 */

import java.sql.Blob;


/**
 6  * Created by WINDOWS 8.1 on 10/22/2016.
 7  */


public class Employee {
     int id;
     String employeeName;
     String employeeAge;
     //Blob employeeImage;


            byte[] employeeimageInByte;


             public Employee(){


             }

// constructor
             public Employee(int id,String employeeName,String employeeAge,byte employeeimageInByte[]){
                 this.id = id;
                 this.employeeName = employeeName;
                 this.employeeAge = employeeAge;
                 this.employeeimageInByte = employeeimageInByte;
             }
     public Employee(String employeeName,String employeeAge,String employeeSex,byte employeeimageInByte[]){
                 this.employeeName = employeeName;
                 this.employeeAge = employeeAge;
                 this.employeeimageInByte = employeeimageInByte;
             }
// get and set id

    public int getId() {
                 return id;
             }


             public void setId(int id) {
                 this.id = id;
             }

//get and set name
             public String getEmployeeName() {
                 return employeeName;
             }


             public void setEmployeeName(String employeeName) {
                 this.employeeName = employeeName;
             }

//get and set emp age
             public String getEmployeeAge() {
                 return employeeAge;
             }
             public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

// get and set image
    public byte[] getEmployeeimageInByte() {
                 return employeeimageInByte;
            }


             public void setEmployeeimageInByte(byte[] employeeimageInByte) {
                 this.employeeimageInByte = employeeimageInByte;
            }




         }
