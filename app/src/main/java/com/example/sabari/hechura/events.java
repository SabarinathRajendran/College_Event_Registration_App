package com.example.sabari.hechura;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class events extends AppCompatActivity {

    private TextView mentry;
    private String settext;

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
    private Spinner neventspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        mpayfield = findViewById(R.id.paymentfield1);
        mname = findViewById(R.id.name4);
        mcollege = findViewById(R.id.college4);
        mdept = findViewById(R.id.dept4);
        myear = findViewById(R.id.year4);
        memail = findViewById(R.id.email4);
        mphone = findViewById(R.id.phone4);
        mpaper = findViewById(R.id.paperbox2);
        mbug = findViewById(R.id.bugBox2);
        mquiz = findViewById(R.id.quizBox2);
        mcrypt =findViewById(R.id.cryptBox2);
        mgame = findViewById(R.id.gamebox2);
        mpeta = findViewById(R.id.petaBox2);
        mtreasure = findViewById(R.id.treasureBox2);
        mmeme = findViewById(R.id.memeBox2);

        mentry = findViewById(R.id.entry123);

        mdatabase = FirebaseDatabase.getInstance().getReference().child("cietregister");

        mpaper.setEnabled(false);
        mbug.setEnabled(false);
        mquiz.setEnabled(false);
        mcrypt.setEnabled(false);
        mgame.setEnabled(false);
        mpeta.setEnabled(false);
        mtreasure.setEnabled(false);
        mmeme.setEnabled(false);

        qrscanner = findViewById(R.id.qrscannerbtn1);
        search = findViewById(R.id.searchbtn1);
        payment = findViewById(R.id.button4);
        mqrresult = findViewById(R.id.qrresultbox1);
        neventspinner = findViewById(R.id.spinner);

        neventspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                settext = neventspinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                settext = neventspinner.getSelectedItem().toString();

            }
        });

        qrscanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(events.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving dept", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving year", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving email", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving phone", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

                    }
                });


                /*if (settext.equals("joined")) {
                    DatabaseReference mtimestampbase = mdatabase.child(qrcode).child("events").child(select).child("timestamp");
                    mtimestampbase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            String name = dataSnapshot.getValue().toString();
                            mtimestamp.setText(name);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                            Toast.makeText(events.this, "error retreving dept", Toast.LENGTH_SHORT).show();

                        }
                    });
                }*/

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(events.this, "error retreving name", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String select = neventspinner.getSelectedItem().toString();

                final DatabaseReference mtimebase = mdatabase.child("events").child(select).child("timestamp");
                final DatabaseReference mjoinbase = mdatabase.child("events").child(select).child("participation");
                AlertDialog.Builder builder = new AlertDialog.Builder(events.this);
                builder.setMessage("Message dialog with three buttons");

                builder.setPositiveButton("entered", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        mjoinbase.setValue("joined");
                        mtimebase.setValue(ServerValue.TIMESTAMP);


                    }
                });

                builder.setNegativeButton("later", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        mjoinbase.setValue("notjoined");
                        mtimebase.setValue(ServerValue.TIMESTAMP);

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

    private void setevents() {



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

    private void searchcode() {



    }

}
