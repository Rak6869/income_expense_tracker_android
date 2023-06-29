package com.bnmit.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



// Import the required libraries
import androidx.room.Room;

import android.graphics.Color;
import android.widget.TextView;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.Locale;

public class visualize
        extends AppCompatActivity {

    // Create the object of TextView
    // and PieChart class
    TextView  tvP , tvB, tvS,tvPm , tvG , tvR , tvM ;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualize);

        // Link those objects with their
        // respective id's that
        // we have given in .XML file
        tvP = findViewById(R.id.tvPetrol);
        tvB = findViewById(R.id.tvBill);
        tvR = findViewById(R.id.tvRestaurant);
        tvM = findViewById(R.id.tvMisc);
        tvS = findViewById(R.id.tvSalary);
        tvPm = findViewById(R.id.tvPM);
        tvG = findViewById(R.id.tvGrocery);
        pieChart = findViewById(R.id.piechart);

        // Creating a method setData()
        // to set the text in text view and pie chart
        setData();
    }

    private void setData()
    {

        // Set the percentage of language used
        RoomDB db = Room.databaseBuilder(getApplicationContext(),
                RoomDB.class,"expense_app").allowMainThreadQueries().build();
        ExpenseDao expenseDao = db.expenseDao();
        Float a = expenseDao.petrol();
        Float b = expenseDao.bill();
        Float c = expenseDao.misc();
        Float d = expenseDao.grocery();
        Float e = expenseDao.restaurant();
        Float f = expenseDao.salary();
        Float g = expenseDao.pocketmoney();
        String n = "NULL";
        if (a.isNaN()){
            a = 0.0f;
        }
        if (b.isNaN()){
            b = 0.0f;
        }
        if (c.isNaN()){
            c = 0.0f;
        }
        if (d.isNaN()){
            d = 0.0f;
        }
        if (e.isNaN()){
            e = 0.0f;
        }
        if (f.isNaN()){
            f = 0.0f;
        }
        if (g.isNaN()){
            g = 0.0f;
        }
        tvP.setText(String.format(Locale.getDefault(), "%f",a ));
        tvB.setText(String.format(Locale.getDefault(), "%f",b ));
        tvM.setText(String.format(Locale.getDefault(), "%f",c ));
        tvG.setText(String.format(Locale.getDefault(), "%f",d ));
        tvR.setText(String.format(Locale.getDefault(), "%f",e ));
        tvS.setText(String.format(Locale.getDefault(), "%f",f ));
        tvPm.setText(String.format(Locale.getDefault(), "%f",g ));







        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "Petrol",
                        Float.parseFloat(tvP.getText().toString()),
                        Color.parseColor("#e57373")));
        pieChart.addPieSlice(
                new PieModel(
                        "Bill",
                        Float.parseFloat(tvB.getText().toString()),
                        Color.parseColor("#ba68c8")));
        pieChart.addPieSlice(
                new PieModel(
                        "Restaurant",
                        Float.parseFloat(tvR.getText().toString()),
                        Color.parseColor("#4db6ac")));
        pieChart.addPieSlice(
                new PieModel(
                        "Misc",
                        Float.parseFloat(tvM.getText().toString()),
                        Color.parseColor("#7986cb")));
        pieChart.addPieSlice(
                new PieModel(
                        "Salary",
                        Float.parseFloat(tvS.getText().toString()),
                        Color.parseColor("#ff8a65")));
        pieChart.addPieSlice(
                new PieModel(
                        "Pocket Money",
                        Float.parseFloat(tvPm.getText().toString()),
                        Color.parseColor("#4dd0e1")));
        pieChart.addPieSlice(
                new PieModel(
                        "Grocery",
                        Float.parseFloat(tvG.getText().toString()),
                        Color.parseColor("#f06292")));

        // To animate the pie chart
        pieChart.startAnimation();
    }
}
