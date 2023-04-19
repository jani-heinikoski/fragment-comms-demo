package com.lut.jh.fragmentcommsdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ReceiveMessageFragment extends Fragment {

    public static final String TAG = "receive_msg";

    private TextView messageTextView;

    public ReceiveMessageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_receive_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.messageTextView = view.findViewById(R.id.message_textview);
    }

    public void receiveMessage(String message) {
        if (message != null && this.messageTextView != null) {
            this.messageTextView.setText(message);
        }
    }
}