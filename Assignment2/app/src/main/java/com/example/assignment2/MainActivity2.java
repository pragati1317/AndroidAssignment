package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name, phone, email;
    Button nm, ph, em, Home, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = (EditText) findViewById(R.id.editTextName);
        phone = (EditText) findViewById(R.id.editTextPhone);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        nm = findViewById(R.id.button4);
        ph = findViewById(R.id.button5);
        em = findViewById(R.id.button6);
        Home = findViewById(R.id.button7);
        next = findViewById(R.id.button9);
        nm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the popup layout XML file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_window, null);

// Get references to the TextViews and Button in the popup layout
                TextView titleTextView = (TextView) popupView.findViewById(R.id.popup_title);
                TextView messageTextView = (TextView) popupView.findViewById(R.id.popup_message);
                Button closeButton = (Button) popupView.findViewById(R.id.popup_close_button);

// Set the title and message text in the popup layout
                titleTextView.setText("Name");
                messageTextView.setText(name.getText());

// Create the popup window
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = (int) (displayMetrics.widthPixels * 0.8);
                int height = (int) (displayMetrics.heightPixels * 0.6);
                popupView.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
                PopupWindow popupWindow = new PopupWindow(popupView, width, height,true);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));

// Show the popup window at the center of the activity page
                View rootView = findViewById(android.R.id.content).getRootView();
                popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);

// Set a click listener for the close button to dismiss the popup window
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });
        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the popup layout XML file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_window, null);

// Get references to the TextViews and Button in the popup layout
                TextView titleTextView = popupView.findViewById(R.id.popup_title);
                TextView messageTextView = popupView.findViewById(R.id.popup_message);
                Button closeButton = popupView.findViewById(R.id.popup_close_button);

// Set the title and message text in the popup layout
                titleTextView.setText("Phone");
                messageTextView.setText(phone.getText());

// Create the popup window
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = (int) (displayMetrics.widthPixels * 0.8);
                int height = (int) (displayMetrics.heightPixels * 0.6);
                popupView.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
                PopupWindow popupWindow = new PopupWindow(popupView, width, height,true);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));

// Show the popup window at the center of the activity page
                View rootView = findViewById(android.R.id.content).getRootView();
                popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);

// Set a click listener for the close button to dismiss the popup window
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });
        em.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the popup layout XML file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_window, null);

// Get references to the TextViews and Button in the popup layout
                TextView titleTextView = popupView.findViewById(R.id.popup_title);
                TextView messageTextView = popupView.findViewById(R.id.popup_message);
                Button closeButton = popupView.findViewById(R.id.popup_close_button);

// Set the title and message text in the popup layout
                titleTextView.setText("Email");
                messageTextView.setText(email.getText());

// Create the popup window
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = (int) (displayMetrics.widthPixels * 0.8);
                int height = (int) (displayMetrics.heightPixels * 0.6);
                popupView.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
                PopupWindow popupWindow = new PopupWindow(popupView, width, height,true);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));

// Show the popup window at the center of the activity page
                View rootView = findViewById(android.R.id.content).getRootView();
                popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);

// Set a click listener for the close button to dismiss the popup window
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}