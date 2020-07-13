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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class cietregister extends AppCompatActivity {

    private EditText mname;
    private EditText mcollege;
    private EditText mdept;
    private EditText myear;
    private EditText memail;
    private EditText mphone;
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

    private String nameset;
    private String collegeset;
    private String deptset;
    private String yearset;
    private String emailset;
    private String phoneset;
    private String qrcode;
    private String paperset;
    private String bugset;
    private String quizset;
    private String crypyset;
    private String gameset;
    private String petaset;
    private String treasureset;
    private String memeset;
    private String foodset;

    private DatabaseReference mdatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cietregister);

        mname = findViewById(R.id.name2);
        mcollege = findViewById(R.id.college2);
        mdept = findViewById(R.id.dept2);
        myear = findViewById(R.id.year2);
        memail = findViewById(R.id.email2);
        mphone = findViewById(R.id.phone2);
        mpaper = findViewById(R.id.paperbox);
        mbug = findViewById(R.id.bugBox);
        mquiz = findViewById(R.id.quizBox);
        mcrypt =findViewById(R.id.cryptBox);
        mgame = findViewById(R.id.gamebox);
        mpeta = findViewById(R.id.petaBox);
        mtreasure = findViewById(R.id.treasureBox);
        mmeme = findViewById(R.id.memeBox);
        mqr = findViewById(R.id.qrscanner);
        mpayment = findViewById(R.id.button2);
        mqrresult = findViewById(R.id.qrresultview);

        mqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(cietregister.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

        mdatabase = FirebaseDatabase.getInstance().getReference().child("cietregister");

        mpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(cietregister.this);
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


    private void registerfunction() {

        nameset = mname.getText().toString().trim();
        collegeset = mcollege.getText().toString().trim();
        deptset = mdept.getText().toString().trim();
        yearset = myear.getText().toString().trim();
        emailset = memail.getText().toString().trim();
        phoneset = mphone.getText().toString().trim();
        foodset = "notreceived";

        qrcode = mqrresult.getText().toString().trim();

        paperset = mpaper.isChecked()?"joined":"notjoined";
        bugset = mbug.isChecked()?"joined":"notjoined";
        quizset = mquiz.isChecked()?"joined":"notjoined";
        crypyset = mcrypt.isChecked()?"joined":"notjoined";
        gameset = mgame.isChecked()?"joined":"notjoined";
        petaset = mpeta.isChecked()?"joined":"notjoined";
        treasureset = mtreasure.isChecked()?"joined":"notjoined";
        memeset = mmeme.isChecked()?"joined":"notjoined";

        mdatabase.child(qrcode).child("name").setValue(nameset);
        mdatabase.child(qrcode).child("college").setValue(collegeset);
        mdatabase.child(qrcode).child("dept").setValue(deptset);
        mdatabase.child(qrcode).child("year").setValue(yearset);
        mdatabase.child(qrcode).child("email").setValue(emailset);
        mdatabase.child(qrcode).child("phone").setValue(phoneset);
        mdatabase.child(qrcode).child("payment").setValue(paymentstr);
        mdatabase.child(qrcode).child("food").setValue(foodset);
        mdatabase.child(qrcode).child("events").child("paperpresentation").child("participation").setValue(paperset);
        mdatabase.child(qrcode).child("events").child("debugging").child("participation").setValue(bugset);
        mdatabase.child(qrcode).child("events").child("quiz").child("participation").setValue(quizset);
        mdatabase.child(qrcode).child("events").child("cryptyourmind").child("participation").setValue(crypyset);
        mdatabase.child(qrcode).child("events").child("gaming").child("participation").setValue(gameset);
        mdatabase.child(qrcode).child("events").child("petapixel").child("participation").setValue(petaset);
        mdatabase.child(qrcode).child("events").child("treasurehunt").child("participation").setValue(treasureset);
        mdatabase.child(qrcode).child("events").child("memecreation").child("participation").setValue(memeset);

        Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show();

        Intent i = new Intent(cietregister.this ,MainActivity.class);
        startActivity(i);

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
