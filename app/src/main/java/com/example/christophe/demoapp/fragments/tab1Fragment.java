package com.example.christophe.demoapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.christophe.demoapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class tab1Fragment extends Fragment {
    private ActionListener actionListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.actionListener = (ActionListener) context;
    }

    public interface ActionListener {
        void onAction();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.buttonNextFrag)
    void submit() {
        this.actionListener.onAction();
    }
}
