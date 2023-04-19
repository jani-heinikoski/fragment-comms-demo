package com.lut.jh.fragmentcommsdemo;

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

public class SendMessageFragment extends Fragment {

    private IFragmentOwner fragmentOwner;

    public SendMessageFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof IFragmentOwner) {
            this.fragmentOwner = (IFragmentOwner) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_send_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button sendMessageButton = (Button) view.findViewById(R.id.send_message_btn);
        sendMessageButton.setOnClickListener(b -> {
            View rootView = getView();
            if (rootView != null) {
                String message = ((EditText) rootView.findViewById(R.id.message_edittext)).getText().toString();
                SendMessageFragment.this.fragmentOwner.sendMessageToFragment(ReceiveMessageFragment.TAG, message);
            }
        });
    }
}