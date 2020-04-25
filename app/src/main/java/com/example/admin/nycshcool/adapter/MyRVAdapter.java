package com.example.admin.nycshcool.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.nycshcool.R;
import com.example.admin.nycshcool.data.School;
import com.example.admin.nycshcool.model.SchoolModel;
import com.example.admin.nycshcool.view.SchoolDetails;

import java.util.ArrayList;

public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyCustomHolder> {

    private Context context;

    ArrayList<School> schools;

    SchoolModel schoolModel;



    public MyRVAdapter(ArrayList<School> schools) {
        this.schools = schools;
    }

    @Override
    public MyCustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context)
                .inflate(R.layout.school_view, parent, false);


        return new MyCustomHolder(view) ;
    }

    @Override
    public void onBindViewHolder(final MyCustomHolder holder, int position) {

        holder.position.setText("" + (position+1));
        holder.schoolName.setText(schools.get(position).getSchoolName());

        final int x = position;
        holder.viewClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(holder.scaleAnim);
                schoolModel = SchoolModel.getInstance();
                schoolModel.setFaxNumber(schools.get(x).getFaxNumber());
                schoolModel.setPhoneNumber(schools.get(x).getPhoneNumber());
                schoolModel.setSchoolCity(schools.get(x).getCity());
                schoolModel.setSchoolName(schools.get(x).getDbn());

                Intent schoolDetails = new Intent(context, SchoolDetails.class);
                context.startActivity(schoolDetails);

            }
        });
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }


    class MyCustomHolder extends RecyclerView.ViewHolder {

        LinearLayout viewClick;
        TextView position;
        TextView schoolName;
        Animation scaleAnim;

        public MyCustomHolder(View itemView)
        {
            super(itemView);
            viewClick = itemView.findViewById(R.id.viewClick);
            position = itemView.findViewById(R.id.positionTxt);
            schoolName = itemView.findViewById(R.id.schoolName);
            scaleAnim = AnimationUtils.loadAnimation(context, R.anim.scale_anim);
        }
    }
}
