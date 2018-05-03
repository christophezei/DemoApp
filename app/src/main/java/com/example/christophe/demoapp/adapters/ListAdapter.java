package com.example.christophe.demoapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.christophe.demoapp.R;
import com.example.christophe.demoapp.models.Person;
import com.example.christophe.demoapp.utils.LoadImage;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Person> personList;

    public ListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    TextView name;
    TextView address;
    ImageView personImage;


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ListViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textViewName);
            address = (TextView) itemView.findViewById(R.id.Address);
            personImage = (ImageView) itemView.findViewById(R.id.imagePerson);

            itemView.setOnClickListener(this);
        }


        public void bindView(int position) {

            Person chris=new Person();
            Person roudy=new Person();
            Person adam=new Person();

            chris.setPersonName("Chris");
            chris.setPersonAddress("Kaslik");
            chris.setImageUrl("http://www.dogbreedslist.info/uploads/allimg/dog-pictures/Labador-Retriever-2.jpg");

           /* roudy.setPersonName("Adam");
            roudy.setPersonAddress("Beirut");
            roudy.setImageUrl("null");

            adam.setPersonName("Adam");
            adam.setPersonAddress("Beirut");
            adam.setImageUrl("null");




            LoadImage imageRoudy = new LoadImage();
            imageRoudy.loadImageByinternetUrl(context, chris.getImageUrl(), personImage);

            LoadImage imageAdam = new LoadImage();
            imageAdam.loadImageByinternetUrl(context, chris.getImageUrl(), personImage);*/



            /*personList.add(chris);
            personList.add(roudy);
            personList.add(adam);*/

            name.setText(chris.getPersonName());
            address.setText(chris.getPersonAddress());
            LoadImage imageChris = new LoadImage();
            imageChris.loadImageByinternetUrl(context, chris.getImageUrl(), personImage);



        }

        @Override
        public void onClick(View v) {

        }
    }
}
