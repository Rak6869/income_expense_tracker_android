package com.bnmit.mad;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Expense.class},version = 1)
public abstract class RoomDB extends RoomDatabase {

    public abstract ExpenseDao expenseDao();

}
