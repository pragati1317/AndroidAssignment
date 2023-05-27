package com.example.assignment2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class EmployeeFragment extends Fragment {

    private TextView idTextView, nameTextView, dobTextView, salaryTextView;
    private Button previousButton, nextButton,backButton;
    private SQLiteDatabase db;
    private Cursor cursor;
    private int currentId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee, container, false);
        ((MainActivity3) getActivity()).removeElements();
        idTextView = view.findViewById(R.id.view_id);
        nameTextView = view.findViewById(R.id.view_name);
        dobTextView = view.findViewById(R.id.view_dob);
        salaryTextView = view.findViewById(R.id.view_salary);
        previousButton = view.findViewById(R.id.previous_button);
        nextButton = view.findViewById(R.id.nextbutton);
        backButton=view.findViewById(R.id.back_button);
        db = new DatabaseHelper(getContext()).getWritableDatabase();

        // Get the first row from the database
        cursor = db.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        currentId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
        updateViews();

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cursor.moveToPrevious()) {
                    cursor.moveToFirst();
                }
                currentId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
                updateViews();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cursor.moveToNext()) {
                    cursor.moveToLast();
                }
                currentId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
                updateViews();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity3.class);
                startActivity(intent);

                // Remove the fragment from the back stack
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }

    private void updateViews() {
        String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME
        ));
        String dob = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DOB));
        double salary = cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_SALARY));
        idTextView.setText(String.valueOf(currentId));
        nameTextView.setText(name);
        dobTextView.setText(dob);
        salaryTextView.setText(String.valueOf(salary));
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();

    }
    private OnFragmentInteractionListener mListener;


    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }
    public void setOnFragmentInteractionListener(OnFragmentInteractionListener listener) {
        mListener = listener;
    }
}