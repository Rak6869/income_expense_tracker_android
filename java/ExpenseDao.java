package com.bnmit.mad;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

class SumAveragePojo
{
    public float total1;
    public float average1;
}
@Dao
public interface ExpenseDao {

    @Query("SELECT * FROM Expense")
    List<Expense> getAll();

    @Query("SELECT  * FROM Expense ORDER BY date DESC")
    List<Expense> getAll_date();

    @Query("SELECT SUM(amount) AS TTL FROM Expense")
    float getsum_all();


    @Query("SELECT * FROM Expense WHERE type='Income' ORDER BY type DESC")
    List<Expense> getAll_type();

    @Query("SELECT * FROM Expense WHERE category=:category  ORDER BY type DESC")
    List<Expense> getAll_cate(String category);

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE type='Income'")
    float getall_inc();

    @Query("SELECT * FROM Expense WHERE type='Expense' ORDER BY type DESC")
    List<Expense> getAll_type_exp();

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE type='Expense'")
    float getall_exp();

    @Query("SELECT * FROM Expense ORDER BY amount DESC")
    List<Expense> getAll_amount();

    @Query("SELECT * FROM Expense ORDER BY category DESC")
    List<Expense> getAll_category();

    @Insert
    void insert(Expense expense);

    @Delete
    void delete(Expense expense);

    @Query("UPDATE Expense SET date = :date,type = :type,amount = :amount,category=:category WHERE id=:id")
    void update(int id,String date,String type,int amount,String category);

    @Query("SELECT * FROM expense where category = :category")
    List<Expense> loadFromUser(String category);

    @Transaction
    default List<Expense> loadFromUser(Expense expense){
        return loadFromUser(expense.category);
    }

    @Query("SELECT * FROM expense WHERE category=:category")
    List<Expense> loadAllcat(String category);

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE category=:category")
    float getall_cat(String category);

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE category='Petrol'")
    float petrol();

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE category='Bill'")
    float bill();

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE category='Grocery'")
    float grocery();

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE category='Salary'")
    float salary();

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE category='Pocket Money'")
    float pocketmoney();

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE category='Misc'")
    float misc();

    @Query("SELECT SUM(amount) AS TTL FROM Expense WHERE category='Restaurant'")
    float restaurant();












}
