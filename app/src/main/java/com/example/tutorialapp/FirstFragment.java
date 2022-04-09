package com.example.tutorialapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tutorialapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    TextView showCountTextView;
    private FragmentFirstBinding binding;

    private void countMe(View view) {
        // Get the value of theview
        String countString = showCountTextView.getText().toString();

        // Calculate the new value
        Integer count = Integer.parseInt(countString);
        count++;

        // Display the new value
        showCountTextView.setText(count.toString());


    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        //Inflate he layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first,container,false);

        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return fragmentFirstLayout;

    }

 public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
     view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Toast myToast = Toast.makeText(getActivity(), R.string.toast_text,Toast.LENGTH_SHORT);
             myToast.show();
         }
     });
     view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View view) {
             countMe(view);
         }
     });
     view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             int currentCount = Integer.parseInt(showCountTextView.getText().toString());
             FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);
             NavHostFragment.findNavController(FirstFragment.this).navigate(action);
         }
     });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}