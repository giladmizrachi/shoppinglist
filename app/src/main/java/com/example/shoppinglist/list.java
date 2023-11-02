package com.example.shoppinglist;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link list#newInstance} factory method to
 * create an instance of this fragment.
 */
public class list extends Fragment {
    private static ArrayList<String> items = new ArrayList<>();
    private static TableLayout Table;
    private TableRow rowone;
    public View root;
    private Button btn;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public list() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment list.
     */
    // TODO: Rename and change types and number of parameters
    public static list newInstance(String param1, String param2) {
        list fragment = new list();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_list, container, false);
        Table = root.findViewById(R.id.Table);
        rowone = root.findViewById(R.id.rowone);
        Bundle bundle = this.getArguments();
        if(bundle != null)
        {
            String data = bundle.getString("key");
            items.add(data);
            Table.removeView(rowone);
        }
        addRow();
        return root;
    }
    private void addRow()
    {
        for (int i = 0; i < items.size(); i++)
        {
            TableRow row = new TableRow(requireActivity());
            row.setLayoutParams(new TableRow.LayoutParams(600, 100));

            TextView txt = new TextView(requireActivity());
            txt.setLayoutParams(new TableRow.LayoutParams(700, 100));

            txt.setText(items.get(i));
            txt.setTextColor(getResources().getColor(R.color.black));
            txt.setTextSize(20);
            txt.setGravity(Gravity.CENTER);

            CheckBox cb = new CheckBox(requireActivity());
            TableRow.LayoutParams Params = new TableRow.LayoutParams(700, 100);
            Params.gravity = Gravity.CENTER;
            cb.setLayoutParams(Params);

            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                    {
                        txt.setTextColor(ContextCompat.getColor(requireActivity(), R.color.blue));
                    }
                    else
                    {
                        txt.setTextColor(ContextCompat.getColor(requireActivity(),R.color.black));
                    }
                }
            });
            row.addView(cb);
            row.addView(txt);
            Table.addView(row);
        }
    }
}