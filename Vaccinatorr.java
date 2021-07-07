package com.codeanu.vaccinator;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;


public class Vaccinatorr extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //the Spinner widget is used to create drop-down menus
    private Spinner selectRegion;

    TextView place1, vaccine1, quantityy1, place2, vaccine2, quantityy2;

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db;

    {
        db = FirebaseFirestore.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccinatorr);
        selectRegion = (Spinner) findViewById(R.id.spinner);

        selectRegion = (Spinner) findViewById(R.id.spinner);
        place1 = (TextView) findViewById(R.id.place1);
        vaccine1 = (TextView) findViewById(R.id.vaccine1);
        quantityy1 = (TextView) findViewById(R.id.quantityy1);
        place2 = (TextView) findViewById(R.id.place2);
        vaccine2 = (TextView) findViewById(R.id.vaccine2);
        quantityy2 = (TextView) findViewById(R.id.quantityy2);

        selectRegion.setOnItemSelectedListener(this); //this line is needed to execute some code when the user selects a certain field from the drop-down menu


        String[] regions = {"Banglore", "Gorakhpur"};

        //the following lines actually invoke the function which is responsible for making the values appear in the drop-down menu
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, regions);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectRegion.setAdapter(adapter);
        //so basically we need to create an array of values which we want to appear in the drop-down menu and then pass it into the ArrayAdapter() function


    }

//the following function contains the code which is to be executed when the user selects any item from the drop-down menu

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (parent.getId() == R.id.spinner) {
            String spinnerValue = parent.getItemAtPosition(position).toString();
            if (spinnerValue == "Banglore") {

                DocumentReference docref1 = db.collection("Banglore").document("3n9kbVNrI3UscDj6F5Ic");
                docref1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                place1.setText(document.getString("place"));
                                vaccine1.setText(document.getString("vaccine_name"));
                                quantityy1.setText(document.getString("quantity"));
                            } else {
                                Log.d("LOGGER", "No such document");
                            }
                        } else {
                            Log.d("LOGGER", "get failed with ", task.getException());
                        }
                    }
                });


                DocumentReference docref2 = db.collection("Banglore").document("f1lyoPL0vFHFrUCHTgL5");
                docref2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                place2.setText(document.getString("place"));
                                vaccine2.setText(document.getString("vaccine_name"));
                                quantityy2.setText(document.getString("quantity"));
                            } else {
                                Log.d("LOGGER", "No such document");
                            }
                        } else {
                            Log.d("LOGGER", "get failed with ", task.getException());
                        }
                    }
                });


            }

            else{

                DocumentReference docref1 = db.collection("Gorakhpur").document("UWAeRUEW3we8kUph097y");
                docref1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                place1.setText(document.getString("place"));
                                vaccine1.setText(document.getString("vaccine_name"));
                                quantityy1.setText(document.getString("quantity"));
                            } else {
                                Log.d("LOGGER", "No such document");
                            }
                        } else {
                            Log.d("LOGGER", "get failed with ", task.getException());
                        }
                    }
                });

                DocumentReference docref2 = db.collection("Gorakhpur").document("v1M2871L5DsG0XNWZdFA");
                docref2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                place2.setText(document.getString("place"));
                                vaccine2.setText(document.getString("vaccine_name"));
                                quantityy2.setText(document.getString("quantity"));
                            } else {
                                Log.d("LOGGER", "No such document");
                            }
                        } else {
                            Log.d("LOGGER", "get failed with ", task.getException());
                        }
                    }
                });

            }


        }
    }


    //the following function contains the code which is to be executed when the user doesn't select any item from the drop-down menu
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}