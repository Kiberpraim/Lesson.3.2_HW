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

public class FirstFragment extends Fragment {

    Button buttonNavigate;
    EditText editTextName;
    EditText editTextSurname;
    Context context;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();

        SecondFragment secondFragment = new SecondFragment();

        buttonNavigate.setOnClickListener(v -> {
            if (!editTextName.getText().toString().isEmpty() && !editTextSurname.getText().toString().isEmpty()) {
                putArgumentsInBundle();

                secondFragment.setArguments(bundle);

                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view, secondFragment)
                        .addToBackStack(null)
                        .commit();
            }else {
                Toast.makeText(context, "Заполните все поля", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void putArgumentsInBundle() {
        bundle.putString("name", editTextName.getText().toString());
        bundle.putString("surname", editTextSurname.getText().toString());
    }

    private void findViews() {
        buttonNavigate = requireActivity().findViewById(R.id.button_navigate_firstFragment);
        editTextName = requireActivity().findViewById(R.id.editText_name);
        editTextSurname = requireActivity().findViewById(R.id.editText_surname);
        context = getContext();
        bundle = new Bundle();
    }
}