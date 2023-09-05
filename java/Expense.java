package com.bnmit.mad;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity
    public class Expense implements Serializable {
        @PrimaryKey(autoGenerate = true)
        int id=0;

        @ColumnInfo(name = "date")
        String date="";

        @ColumnInfo(name = "type")
        String type = "";

        @ColumnInfo(name = "amount")
        float amount= 0;

        @ColumnInfo(name = "category")
        String category = "";   

    public Expense(String date, String type, float amount, String category) {

        this.date = date;
        this.type = type;
        this.amount = amount;
        this.category = category;

    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


