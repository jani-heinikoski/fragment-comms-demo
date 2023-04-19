package com.lut.jh.fragmentcommsdemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CommsDemoAdapter extends FragmentStateAdapter implements IFragmentOwner {

    private ReceiveMessageFragment receiveMessageFragment;
    private SendMessageFragment sendMessageFragment;

    public CommsDemoAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            this.receiveMessageFragment = new ReceiveMessageFragment();
            return this.receiveMessageFragment;
        } else {
            this.sendMessageFragment = new SendMessageFragment();
            return this.sendMessageFragment;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void sendMessageToFragment(String fragmentTag, String message) {
        if (this.receiveMessageFragment != null && fragmentTag.equals(ReceiveMessageFragment.TAG)) {
            this.receiveMessageFragment.receiveMessage(message);
        }
    }
}
