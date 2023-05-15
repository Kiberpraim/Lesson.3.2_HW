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

public class SecondFragment extends Fragment {

    Button buttonNavigate;
    EditText editTextAge;
    EditText editTextGender;
    Context context;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();

        ThirdFragment thirdFragment = new ThirdFragment();

        buttonNavigate.setOnClickListener(v -> {
                if (!editTextAge.getText().toString().isEmpty() && !editTextGender.getText().toString().isEmpty()) {
                    putArgumentsInBundle();

                    thirdFragment.setArguments(bundle);

                    requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container_view, thirdFragment)
                            .addToBackStack(null)
                            .commit();
                } else {Toast.makeText(context, "Заполните все поля", Toast.LENGTH_LONG).show();}
        });
    }

    private void putArgumentsInBundle() {
        bundle.putString("name", getArguments().getString("name"));
        bundle.putString("surname", getArguments().getString("surname"));
        bundle.putInt("age", Integer.parseInt(editTextAge.getText().toString()));
        bundle.putString("gender", editTextGender.getText().toString());
    }

    private void findViews() {
        buttonNavigate = requireActivity().findViewById(R.id.button_navigate_secondFragment);
        editTextAge = requireActivity().findViewById(R.id.editText_age);
        editTextGender = requireActivity().findViewById(R.id.editText_gender);
        context = getContext();
        bundle = new Bundle();
    }
}