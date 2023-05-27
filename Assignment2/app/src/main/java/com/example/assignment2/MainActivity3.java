package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity3 extends AppCompatActivity implements  EmployeeFragment.OnFragmentInteractionListener  {

    EditText ID, name, DOB, Salary;
    Button submit,prev,next,home,view;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ID=(EditText) findViewById(R.id.id_input);
        name=(EditText) findViewById(R.id.name_input);
        DOB=(EditText) findViewById(R.id.dob_input);
        Salary=(EditText) findViewById(R.id.salary_input);
        submit=findViewById(R.id.submit_button);
        prev=findViewById(R.id.prev_button);
        next=findViewById(R.id.next_button);
        home=findViewById(R.id.home_button);
        view=findViewById(R.id.home_button2);

        dbHelper = new DatabaseHelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm = name.getText().toString().trim();
                String dob = DOB.getText().toString().trim();
                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dob_var = null;
                try {
                    dob_var = sdf.parse(dob);
                } catch (ParseException e) {
                    e.printStackTrace();
                    Log.i("E11111111111", e.toString());
                }
                DateFormat dateFormatISO8601 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strDob = dateFormatISO8601.format(dob_var);
                double salary = Double.parseDouble(Salary.getText().toString().trim());

                boolean success = dbHelper.addEmployee(nm, strDob, salary);

                if (success) {
                    Toast.makeText(getApplicationContext(), "Employee added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed to add employee", Toast.LENGTH_SHORT).show();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmployeeFragment employeeFragment = new EmployeeFragment();
                displayFragment(employeeFragment);
                ViewGroup parent = (ViewGroup) ID.getParent();
            }
        });
    }
    public void displayFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
    @Override
    public void onFragmentInteraction(Uri uri) {
        // Do something with the interaction
    }
    public void removeElements() {
        // Find the parent view that holds all the elements
        ViewGroup parent = findViewById(android.R.id.content);

        // Remove all child views from the parent view
        ID.setVisibility(View.GONE);
        name.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
        prev.setVisibility(View.GONE);
        Salary.setVisibility(View.GONE);
        DOB.setVisibility(View.GONE);
        submit.setVisibility(View.GONE);
        view.setVisibility(View.GONE);
        home.setVisibility(View.GONE);
        findViewById(R.id.id_label).setVisibility(View.GONE);
        findViewById(R.id.name_label).setVisibility(View.GONE);
        findViewById(R.id.dob_label).setVisibility(View.GONE);
        findViewById(R.id.salary_label).setVisibility(View.GONE);


    }
}