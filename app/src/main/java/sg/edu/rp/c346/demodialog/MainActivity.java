package sg.edu.rp.c346.demodialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;

    TextView tvDemo2;
    Button btnDemo2;

    TextView tvDemo3;
    Button btnDemo3;

    TextView tvEx3;
    Button btnEx3;

    TextView tvDemo4;
    Button btnDemo4;

    TextView tvDemo5;
    Button btnDemo5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);

        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo2 = findViewById(R.id.buttonDemo2);

        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnDemo3 = findViewById(R.id.buttonDemo3);

        tvEx3 = findViewById(R.id.textViewExercise3);
        btnEx3 = findViewById(R.id.buttonExercise3);

        tvDemo4 = findViewById(R.id.textViewDemo4);
        btnDemo4 = findViewById(R.id.buttonDemo4);

        tvDemo5 = findViewById(R.id.textViewDemo5);
        btnDemo5 = findViewById(R.id.buttonDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Button Dialog");
                myBuilder.setMessage("Select one of the buttons below.");
                myBuilder.setCancelable(false);

                //Configure the 'positive' button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");

                    }
                });

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                //Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                //Obtain the UI component in the input.xml layout
                //It needs to be defined as "final", so that it can used in the onCLick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog); //Set the view of the dialog
                myBuilder.setTitle("Demo 3- Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        String message = etInput.getText().toString();
                        //Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnEx3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                final EditText etInput = viewDialog.findViewById(R.id.editText);
                final EditText etInput2 = viewDialog.findViewById(R.id.editText2);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = etInput.getText().toString();
                        String message2 = etInput2.getText().toString();
                        int num1 = Integer.parseInt(message);
                        int num2 = Integer.parseInt(message2);
                        int total = num1 + num2;
                        String tvMessage = Integer.toString(total);

                        // Update the Text to TextView
                        tvEx3.setText("The sum is " + tvMessage);
                    }
                });


                myBuilder.setNegativeButton("Cancel", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                //Create the Date Picker Dialog
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DATE);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);

                myDateDialog.show();

            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                //Create the Date Picker Dialog
                Calendar now = Calendar.getInstance();
                int hour = now.get(Calendar.HOUR_OF_DAY);
                int minute = now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hour, minute, true);
                myTimeDialog.show();

            }
        });
    }
}
