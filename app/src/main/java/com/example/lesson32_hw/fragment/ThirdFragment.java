package com.example.lesson32_hw.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lesson32_hw.R;

public class ThirdFragment extends Fragment {

    Button buttonNavigate;
    EditText editTextPlaceOfStudy;
    EditText editTextPlaceOfWork;
    Context context;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        FourthFragment fourthFragment = new FourthFragment();

        buttonNavigate.setOnClickListener(v -> {
            if (!editTextPlaceOfStudy.getText().toString().isEmpty() && !editTextPlaceOfWork.getText().toString().isEmpty()) {
                putArgumentsInBundle();

                fourthFragment.setArguments(bundle);

                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view, fourthFragment)
                        .addToBackStack(null)
                        .commit();
            }else {
                Toast.makeText(context, "Заполните все поля", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void putArgumentsInBundle() {
        bundle.putString("name", getArguments().getString("name"));
        bundle.putString("surname", getArguments().getString("surname"));
        bundle.putInt("age", getArguments().getInt("age"));
        bundle.putString("gender", getArguments().getString("gender"));
        bundle.putString("study", editTextPlaceOfStudy.getText().toString());
        bundle.putString("work", editTextPlaceOfWork.getText().toString());
    }

    private void findViews() {
        buttonNavigate = requireActivity().findViewById(R.id.button_navigate_thirdFragment);
        editTextPlaceOfStudy = requireActivity().findViewById(R.id.editText_placeOfStudy);
        editTextPlaceOfWork = requireActivity().findViewById(R.id.editText_placeOfWork);
        context = getContext();
        bundle = new Bundle();
    }
}