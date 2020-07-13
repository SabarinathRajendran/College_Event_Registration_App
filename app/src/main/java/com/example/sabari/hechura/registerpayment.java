package com.example.sabari.hechura;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class registerpayment extends AppCompatActivity {

    private TextView mname;
    private TextView mcollege;
    private TextView mdept;
    private TextView myear;
    private TextView memail;
    private TextView mphone;
    private CheckBox mpaper;
    private CheckBox mbug;
    private CheckBox mquiz;
    private CheckBox mcrypt;
    private CheckBox mgame;
    private CheckBox mpeta;
    private  CheckBox mtreasure;
    private CheckBox mmeme;
    private Button mqr;
    private Button mpayment;
    private EditText mqrresult;
    private String paymentstr;
    private String qrcode;

    private TextView mpayfield;

    private DatabaseReference mdatabase;

    private ImageButton qrscanner;
    private ImageButton search;
    private Button payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpayment);

        mpayfield = findViewById(R.id.paymentfield);
        mname = findViewById(R.id.name3);
        mcollege = findViewById(R.id.college3);
        mdept = findViewById(R.id.dept3);
        myear = findViewById(R.id.year3);
        memail = findViewById(R.id.email3);
        mphone = findViewById(R.id.phone3);
        mpaper = findViewById(R.id.paperbox1);
        mbug = findViewById(R.id.bugBox1);
        mquiz = findViewById(R.id.quizBox1);
        mcrypt =findViewById(R.id.cryptBox1);
        mgame = findViewById(R.id.gamebox1);
        mpeta = findViewById(R.id.petaBox1);
        mtreasure = findViewById(R.id.treasureBox1);
        mmeme = findViewById(R.id.memeBox1);

        mpaper.setEnabled(false);
        mbug.setEnabled(false);
        mquiz.setEnabled(false);
        mcrypt.setEnabled(false);
        mgame.setEnabled(false);
        mpeta.setEnabled(false);
        mtreasure.setEnabled(false);
        mmeme.setEnabled(false);

        qrscanner = findViewById(R.id.qrscannerbtn);
        search = findViewById(R.id.searchbtn);
        payment = findViewById(R.id.button3);
        mqrresult = findViewById(R.id.qrresultbox);

        qrscanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(registerpayment.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

        mdatabase = FirebaseDatabase.getInstance().getReference().child("cietregister");

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchcode();
            }
        });




        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(registerpayment.this);
                builder.setMessage("Message dialog with three buttons");

                builder.setPositiveButton("payed", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        paymentstr = "payed";
                        dialog.cancel();
                        registerfunction();

                    }
                });

                builder.setNegativeButton("later", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        paymentstr = "non-payed";
                        dialog.cancel();
                        registerfunction();
                    }
                });

                builder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener()     {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();



            }
        });

    }

    private void searchcode() {

        qrcode = mqrresult.getText().toString();

        DatabaseReference mnamebase = mdatabase.child(qrcode).child("name");
        mnamebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                mname.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });
        DatabaseReference mcollegebase = mdatabase.child(qrcode).child("college");
        mcollegebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                mcollege.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mdeptbase = mdatabase.child(qrcode).child("dept");
        mdeptbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                mdept.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving dept", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference myearbase = mdatabase.child(qrcode).child("year");
        myearbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                myear.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving year", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference memailbase = mdatabase.child(qrcode).child("email");
        memailbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                memail.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving email", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mphonebase = mdatabase.child(qrcode).child("phone");
        mphonebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                mphone.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving phone", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mpayment = mdatabase.child(qrcode).child("payment");
        mpayment.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                mpayfield.setText(new StringBuilder().append("payment: ").append(name).toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mpaperbase = mdatabase.child(qrcode).child("events").child("paperpresentation").child("participation");
        mpaperbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                if (name.equals("joined")) {
                    mpaper.setChecked(true);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mbugbase = mdatabase.child(qrcode).child("events").child("debugging").child("participation");
        mbugbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                if (name.equals("joined")) {
                    mbug.setChecked(true);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mquizbase = mdatabase.child(qrcode).child("events").child("quiz").child("participation");
        mquizbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                if (name.equals("joined")) {
                    mquiz.setChecked(true);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mcryptbase = mdatabase.child(qrcode).child("events").child("cryptyourmind").child("participation");
        mcryptbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                if (name.equals("joined")) {
                    mcrypt.setChecked(true);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mgamebase = mdatabase.child(qrcode).child("events").child("gaming").child("participation");
        mgamebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                if (name.equals("joined")) {
                    mgame.setChecked(true);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mtreasurebase = mdatabase.child(qrcode).child("events").child("treasurehunt").child("participation");
        mtreasurebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                if (name.equals("joined")) {
                    mtreasure.setChecked(true);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mpetabase = mdatabase.child(qrcode).child("events").child("petapixel").child("participation");
        mpetabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                if (name.equals("joined")) {
                    mpeta.setChecked(true);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference mmemebase = mdatabase.child(qrcode).child("events").child("memecreation").child("participation");
        mmemebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.getValue().toString();
                if (name.equals("joined")) {
                    mbug.setChecked(true);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(registerpayment.this, "error retreving name", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void registerfunction() {


        Toast.makeText(this, "hello! its working", Toast.LENGTH_SHORT).show();
        mdatabase.child(qrcode).child("payment").setValue(paymentstr);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("MainActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("MainActivity", "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                mqrresult.setText(result.getContents());

            }
        }
    }
}
