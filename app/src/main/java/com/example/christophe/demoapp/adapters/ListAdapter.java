package com.example.christophe.demoapp.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.christophe.demoapp.R;
import com.example.christophe.demoapp.models.Person;
import com.example.christophe.demoapp.utils.LoadImage;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Person> personList;

    public ListAdapter(Context context, ArrayList<Person> personList) {
        this.context = context;
        this.personList = personList;
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
        return this.personList == null ? 0 : this.personList.size();
    }


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameTv;
        private TextView addressTv;
        private ImageView personIv;

        private ListViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.textViewName);
            addressTv = itemView.findViewById(R.id.Address);
            personIv = itemView.findViewById(R.id.imagePerson);
            itemView.setOnClickListener(this);
        }


        private void bindView(int position) {
            Person person = personList.get(position);
            this.nameTv.setText(person.getPersonName());
            this.addressTv.setText(person.getPersonAddress());
            new LoadImage().loadImageByinternetUrl(context, person.getImageUrl(), this.personIv);
        }


        @Override
        public void onClick(View v) {
            Toast.makeText(context,"You clicked on: "+nameTv.getText().toString(),Toast.LENGTH_LONG).show();
            SharedPreferences namePrevSelected;
            namePrevSelected=context.getSharedPreferences("SaveName", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=namePrevSelected.edit();
            editor.putString("Value",nameTv.getText().toString());
            editor.apply();

        }
    }
}
