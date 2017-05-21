package com.example.karthik.karthiks_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by karthik on 5/20/2017.
 */

public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.MyViewHolder>{

    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<DataModel> mDataModel;



   public HomeRecycleAdapter(Context context, ArrayList<DataModel> model){
       this.mContext=context;
       this.mDataModel=model;
       mInflater = LayoutInflater.from(context);
   }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fragment_filler, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataModel data=mDataModel.get(position);
        holder.title.setText(data.getTitle());
        holder.description.setText(data.getDescription());
        holder.time.setText(data.getTime());
        holder.image.setImageResource(data.getImgdata());
    }

    @Override
    public int getItemCount() {
        return mDataModel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView description;
        private TextView time;
        private ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            description=(TextView)itemView.findViewById(R.id.description);
            time=(TextView)itemView.findViewById(R.id.time);
            image=(ImageView) itemView.findViewById(R.id.image);
        }
    }
}
