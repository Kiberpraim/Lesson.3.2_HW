package com.example.lesson32_hw.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lesson32_hw.R;

public class FourthFragment extends Fragment {

    TextView textViewName;
    TextView textViewSurname;
    TextView textViewAge;
    TextView textViewGender;
    TextView textViewPlaceOfStudy;
    TextView textViewPlaceOfWork;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        setText();
    }

    private void setText() {
        if (getArguments() != null) {
            textViewName.setText(getArguments().getString("name"));
            textViewSurname.setText(getArguments().getString("surname"));
            textViewAge.setText(String.valueOf(getArguments().getInt("age")));
            textViewGender.setText(getArguments().getString("gender"));
            textViewPlaceOfStudy.setText(getArguments().getString("study"));
            textViewPlaceOfWork.setText(getArguments().getString("work"));
        }
    }

    private void findViews() {
        textViewName = requireActivity().findViewById(R.id.textView_name);
        textViewSurname = requireActivity().findViewById(R.id.textView_surname);
        textViewAge = requireActivity().findViewById(R.id.textView_age);
        textViewGender = requireActivity().findViewById(R.id.textView_gender);
        textViewPlaceOfStudy = requireActivity().findViewById(R.id.textView_placeOfStudy);
        textViewPlaceOfWork = requireActivity().findViewById(R.id.textView_placeOfWork);
    }
}