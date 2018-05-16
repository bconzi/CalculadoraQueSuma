package com.example.brenda.clasee_calculadora;

//App conectada con base de datos Firebase- Modificación en rt

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity  {

  //Agrego la base de datos
    DatabaseReference mDatabaseReference= FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRootChild= mDatabaseReference.child("texto");

    private EditText et1;
    private EditText et2;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1= (EditText) findViewById(R.id.ETxt_Num1);
        et2= (EditText) findViewById(R.id.ETxt_Num2);
        tv1= (TextView) findViewById(R.id.txt_resultado);


    }



    //Este método sirve para que cuando se abra la app, que esto sea lo primero
   // En este caso lo uso para escuchar si lo que está en firebase, cambió

    @Override
    protected void onStart(){
        super.onStart();

        mRootChild.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Va a cambiar el texto que ingresé

                //Voy a obtner el texto de mi textview y lo paso a String
                String texto = dataSnapshot.getValue().toString();


                // en texto va a estar almacenado el nombre o la variable que nosotros pongamos en Firebase

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    //Metodo para realizar la suma
    public void Sumar (View view) {

        String valor1= et1.getText().toString();
        String valor2= et2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);

        int suma= num1+num2;

        //Tengo que parsear la suma porque es un tipo de dato string!!

        String result = String.valueOf(suma);
        tv1.setText(result);
    }





    }

