package com.bnmit.mad;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Retreive extends AppCompatActivity {
    TextView data,ttl;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItem;

    Button eve,inco,expe,del,g;
    static List a ;
    String category[] = {"Grocery", "Petrol", "Bill", "Restaurant", "Misc","Salary","Pocket Money"};
    String cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreive);
        autoCompleteTextView = findViewById(R.id.auto_complete_1);
        adapterItem = new ArrayAdapter<String>(this, R.layout.list_item, category);
        data = findViewById(R.id.dataholder);
        eve = findViewById(R.id.all);
        inco = findViewById(R.id.income);
        expe = findViewById(R.id.expense);
        del = findViewById(R.id.delete);
        ttl = findViewById(R.id.total);
        g = findViewById(R.id.go);
        autoCompleteTextView = findViewById(R.id.auto_complete_1);
        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();
                cat = item;
                makeText(Retreive.this, "Item: " + item, Toast.LENGTH_SHORT).show();
            }});

        eve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomDB db = Room.databaseBuilder(getApplicationContext(),
                        RoomDB.class,"expense_app").allowMainThreadQueries().build();
                ExpenseDao expenseDao = db.expenseDao();
                List<Expense> expenses = expenseDao.getAll();
                String str  = "";

                for (Expense expense:expenses)
                    str=str+"\t  "+expense.getCategory()+" "+expense.getDate()+" "+expense.getType()+" "+expense.getAmount()+"\n\n";
                float total = 0;

                total = expenseDao.getsum_all();

                ttl.setText(String.valueOf(total));


;
                data.setText(str);

            }
        });

        inco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomDB db = Room.databaseBuilder(getApplicationContext(),
                        RoomDB.class,"expense_app").allowMainThreadQueries().build();
                ExpenseDao expenseDao = db.expenseDao();
                List<Expense> expenses = expenseDao.getAll_type();
                String str  = "";

                for (Expense expense:expenses)
                    str=str+"\t  "+expense.getCategory()+" "+expense.getDate()+" "+expense.getType()+" "+expense.getAmount()+"\n\n";

                data.setText(str);
                float total = 0;

                total = expenseDao.getall_inc();

                ttl.setText(String.valueOf(total));

            }
        });

        expe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomDB db = Room.databaseBuilder(getApplicationContext(),
                        RoomDB.class,"expense_app").allowMainThreadQueries().build();
                ExpenseDao expenseDao = db.expenseDao();
                List<Expense> expenses = expenseDao.getAll_type_exp();
                String str  = "";

                for (Expense expense:expenses)
                    str=str+"\t  "+expense.getCategory()+" "+expense.getDate()+" "+expense.getType()+" "+expense.getAmount()+"\n\n";

                data.setText(str);
                float total = 0;

                total = expenseDao.getall_exp();

                ttl.setText(String.valueOf(total));

            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomDB db = Room.databaseBuilder(getApplicationContext(),
                        RoomDB.class,"expense_app").allowMainThreadQueries().build();
                ExpenseDao expenseDao = db.expenseDao();
                db.clearAllTables();
                String str  = "";
                data.setText(str);

            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomDB db = Room.databaseBuilder(getApplicationContext(),
                        RoomDB.class,"expense_app").allowMainThreadQueries().build();
                ExpenseDao expenseDao = db.expenseDao();
                List<Expense> expenses = expenseDao.getAll_cate(cat);
                String str  = "";
                ttl.setText(cat);

                for (Expense expense:expenses)
                    str=str+"\t  "+expense.getCategory()+" "+expense.getDate()+" "+expense.getType()+" "+expense.getAmount()+"\n\n";
                float total = 0;

                total = expenseDao.getall_cat(cat);

                ttl.setText(String.valueOf(total));


                ;
                data.setText(str);

            }
        });


    }

}
