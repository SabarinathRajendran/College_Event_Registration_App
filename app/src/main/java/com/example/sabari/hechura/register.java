package com.example.sabari.hechura;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    private ImageButton msearch;
    private ImageButton mqrscanner;
    private Button msubmit;

    private RecyclerView mresult_view;
    private DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        msearch = findViewById(R.id.searchregister);
        mqrscanner = findViewById(R.id.qrscannerregister);
        msubmit = findViewById(R.id.submit_payment);

        //mresult_view = findViewById(R.id.result_listregister);
        mresult_view.setHasFixedSize(true);
        mresult_view.setLayoutManager(new LinearLayoutManager(this));

        mdatabase = FirebaseDatabase.getInstance().getReference().child("details").child("1");

        msearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebasesearchuser();
            }
        });

    }

    private void firebasesearchuser() {

        FirebaseRecyclerAdapter<details_list, UserViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<details_list, UserViewHolder>(
                details_list.class,
                R.layout.details_list_recycler,
                UserViewHolder.class,
                mdatabase
        ) {
            @Override
            protected void populateViewHolder(UserViewHolder viewHolder, details_list model, int position) {

                viewHolder.setdetails(model.getName(),model.getGender(),model.getCollege());

            }
        };

        mresult_view.setAdapter(firebaseRecyclerAdapter);

    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        View mview;

        public UserViewHolder(View itemView) {
            super(itemView);

            mview = itemView;
        }

        public void setdetails(String name, String gender,String college){

            TextView user_name = mview.findViewById(R.id.nameview);
            TextView user_gender = mview.findViewById(R.id.genderview);
            TextView user_college = mview.findViewById(R.id.collegeview);

            user_name.setText(name);
            user_gender.setText(gender);
            user_college.setText(college);

        }}

}
