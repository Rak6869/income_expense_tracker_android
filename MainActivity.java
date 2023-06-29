package com.bnmit.mad;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Button fab1;
    String category[] = {"Grocery", "Petrol", "Bill", "Restaurant", "Misc","Salary","Pocket Money"};
    String type[] = {"Income", "Expense"};
    EditText t1, t2;
    TextView date_text;
    private DatePickerDialog datePickerDialog;
    private Button dateButton,rb,rb2;
    TextInputLayout ti1, ti2;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItem;
    String cat, ty,val;
    float amt=0;
    TextView dateText;
    static String date1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView = findViewById(R.id.auto_complete_1);
        adapterItem = new ArrayAdapter<String>(this, R.layout.list_item, category);
        fab1 = findViewById(R.id.fab);
        t1 = findViewById(R.id.amt);
        rb = findViewById(R.id.retrieve);
        rb2 = findViewById(R.id.retrieve2);
        dateText = findViewById(R.id.date_text);
        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();
                cat = item;
                makeText(MainActivity.this, "Item: " + item, Toast.LENGTH_SHORT).show();
            }

        });
        autoCompleteTextView = findViewById(R.id.auto_complete_2);
        adapterItem = new ArrayAdapter<String>(this, R.layout.list_item, type);
        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();
                ty = item;
                makeText(MainActivity.this, "Item: " + item, Toast.LENGTH_SHORT).show();
            }

        });

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        fab1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                new bgthread().start();


                dateText.setText("DD/MM/YYYY");
                makeText(MainActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }


        });

        rb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openRetrieve();
            }
        });

        rb2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openVisualize();
            }
        });



    }
    public void openRetrieve(){
        Intent intent = new Intent(this,Retreive.class);
        startActivity(intent);
    }

    public void openVisualize(){
        Intent intent = new Intent(this,visualize.class);
        startActivity(intent);
    }

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (DatePickerDialog.OnDateSetListener) this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;
        dateText.setText(date);
        date1 = date;

    }

    class bgthread extends Thread {

        public void run() {
            super.run();
            RoomDB db = Room.databaseBuilder(getApplicationContext(),
                    RoomDB.class,"expense_app").fallbackToDestructiveMigration().build();
            ExpenseDao expenseDao = db.expenseDao();
            expenseDao.insert(new Expense(date1,ty,(Float.parseFloat(t1.getText().toString())),cat));


        }
    }

}

