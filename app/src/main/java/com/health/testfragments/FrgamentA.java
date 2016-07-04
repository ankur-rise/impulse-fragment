package com.health.testfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ankur on 19/6/15.
 */
public class FrgamentA extends Fragment implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        counter=0;
    }
    TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(savedInstanceState!=null) {
            counter = savedInstanceState.getInt("counter");
        }
        View view = inflater.inflate(R.layout.fragment_a, null);
        tv = (TextView) view.findViewById(R.id.tv);


        tv.setText(counter+"" +
                "");
        tv.setOnClickListener(this);
        view.findViewById(R.id.btn).setOnClickListener(this);
        return view;
    }
    int counter;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("counter", counter);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv:
                FragmentB fragmentB = new FragmentB();
                getActivity().getFragmentManager().beginTransaction().replace(R.id.container, fragmentB).addToBackStack(null).commit();

                break;
            case R.id.btn:
                counter++;
                tv.setText(counter+"");
                ((TextView)getView().findViewById(R.id.tv_two)).setText(counter+" second");
                break;

        }
    }
}
