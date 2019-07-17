package com.example.automation;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import com.example.automation.Adapters.AutoAdapter;
import com.example.automation.Generator.ServicesGenerator;
import com.example.automation.Services.DevicesService;
import com.example.automation.models.AutoModel;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CardFragment extends Fragment {
//    ArrayList<AutoModel> listItem = new ArrayList<>();
    RecyclerView MyRecyclerView;
    TextView tvTitle;
    ImageView imgView;
    AutoModel model;
    AutoAdapter adapter;
    DevicesService service;
    private OnFragmentInteractionListener mListener;

    public static CardFragment newInstance(AutoModel model) {
        CardFragment fragment = new CardFragment();
        Bundle bundle = new Bundle();
        // TODO: pass object calory dengan menggunakan bundle.putParcelable

        bundle.putParcelable(Constant.NAME,model);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initializeList();


    }


//    public void initializeList() {
//        listItem.clear();
//
//        for (int i = 0; i < 4; i++) {
//
//
//            AutoModel item = new AutoModel();
//            item.setCardName(model.getCardName());
//            item.setImgId(model.getImgId());
//            listItem.add(item);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        service = ServicesGenerator.createService(DevicesService.class);
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        MyRecyclerView = view.findViewById(R.id.cardView);
        MyRecyclerView.setHasFixedSize(true);
        tvTitle = view.findViewById(R.id.titleTextView);
        imgView = view.findViewById(R.id.coverImageView);


        Bundle bundle = getArguments();
        if (bundle != null) {
            model = bundle.getParcelable(Constant.NAME);
            // TODO: set informasi calory pada layar tampilan
            tvTitle.setText(model.getCardName());
            imgView.setImageResource(Integer.parseInt(model.getImgId()));
        }
        else{
//            Snackbar.make(view,"GAGAL",Snackbar.LENGTH_LONG).show();
        }




        RecyclerView.LayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyRecyclerView.setAdapter(adapter);
        MyRecyclerView.setLayoutManager(MyLayoutManager);


            mListener.onCaloryFragmentCreated(getView(), adapter);


//        onCaloryFragmentCreated(view,adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener {
        void onCaloryFragmentCreated(final View view, final AutoAdapter adapter);
    }


//    public interface onInteractionListener{
//        void onCaloryFragmentCreated(final View view, final AutoAdapter adapter, final TextView caloryText);
//
//    }
//    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//        private ArrayList<AutoModel> list;
//
//        public MyAdapter(ArrayList<AutoModel> Data){
//            list = Data;
//        }
//
//        @NonNull
//        @Override
//        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item
//                    ,parent,false);
//            MyViewHolder holder = new MyViewHolder(view);
//
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
//            holder.tvTitle.setText(model.getCardName());
//            holder.imgAuto.setImageResource(Integer.parseInt(model.getImgId()));
//            holder.imgAuto.setTag(list.get(position).getImgId());
//
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return list.size();
//        }
//
//        public static class MyViewHolder extends RecyclerView.ViewHolder {
//            public TextView tvTitle,tvOn,tvOff;
//            public ImageView imgAuto;
//            public Switch aSwitch;
//            Button btn;
//
//            public MyViewHolder(@NonNull View itemView) {
//
//                super(itemView);
//
//                tvTitle = itemView.findViewById(R.id.titleTextView);
//                imgAuto = itemView.findViewById(R.id.coverImageView);
//                aSwitch = itemView.findViewById(R.id.abcSwitch);
//                tvOff = itemView.findViewById(R.id.tvOff);
//                tvOn = itemView.findViewById(R.id.tvOn);
//                btn = itemView.findViewById(R.id.stat);
//
//
//                btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        String stat;
//                        if(aSwitch.isChecked()){
//                             stat = "Menyala";
//                        } else
//                        {
//                             stat = "Mati";
//                        }
//
//                        String label = "Nama Devices: " + tvTitle.getText()+"\n\n"
//                                +"Status: "+stat;
//                        AlertDialog.Builder tampil = new AlertDialog.Builder(getActivity());
//                        tampil.setMessage(label).setNeutralButton("Close", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//
//                            }
//                        });
//                        AlertDialog alertDialog = tampil.create();
//                        alertDialog.show();
//                    }
//                });
//
//
//
//
//                aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                        if(b){
//                            FirebaseDatabase database = FirebaseDatabase.getInstance();
//                            DatabaseReference myRef = database.getReference(tvTitle.getText().toString());
//
//                            Toast.makeText(getActivity(),tvTitle.getText()+" Menyala",Toast.LENGTH_SHORT).show();
//                            tvOff.setTypeface(Typeface.DEFAULT_BOLD);
//                            tvOn.setTextColor(Color.GRAY);
//                            tvOff.setTextColor(Color.RED);
//
//
//                            myRef.setValue(1);
//                        } else {
//                            Toast.makeText(getActivity(),tvTitle.getText()+" Mati",Toast.LENGTH_SHORT).show();
//                            tvOn.setTextColor(Color.RED);
//                            tvOff.setTextColor(Color.GRAY);
//                            tvOff.setTypeface(Typeface.DEFAULT_BOLD);
//                            FirebaseDatabase database = FirebaseDatabase.getInstance();
//                            DatabaseReference myRef = database.getReference(tvTitle.getText().toString());
//
//                            myRef.setValue(0);
//                        }
//                    }
//                });
//
//            }
//        }
//    }

}





