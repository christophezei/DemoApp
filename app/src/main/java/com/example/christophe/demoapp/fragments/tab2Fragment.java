package com.example.christophe.demoapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.christophe.demoapp.R;
import com.example.christophe.demoapp.adapters.ListAdapter;
import com.example.christophe.demoapp.models.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class tab2Fragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        recyclerView = view.findViewById(R.id.personViewer);

        Person chris = new Person();
        Person roudy = new Person();
        Person adam = new Person();

        chris.setPersonName("Chris");
        chris.setPersonAddress("Kaslik");
        chris.setImageUrl("http://www.dogbreedslist.info/uploads/allimg/dog-pictures/Labrador-Retriever-2.jpg");

        roudy.setPersonName("Roudy");
        roudy.setPersonAddress("Beirut");
        roudy.setImageUrl("http://www.dogbreedslist.info/uploads/allimg/dog-pictures/Labrador-Retriever-2.jpg");

        adam.setPersonName("Adam");
        adam.setPersonAddress("Beirut");
        adam.setImageUrl("http://www.dogbreedslist.info/uploads/allimg/dog-pictures/Labrador-Retriever-2.jpg");

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(chris);
        personList.add(roudy);
        personList.add(adam);

        ListAdapter listAdapter = new ListAdapter(getContext(), personList);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }
}
