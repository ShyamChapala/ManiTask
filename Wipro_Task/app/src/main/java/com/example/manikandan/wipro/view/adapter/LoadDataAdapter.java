package com.example.manikandan.wipro.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.manikandan.wipro.R;
import com.example.manikandan.wipro.model.ApiResponse;



public class LoadDataAdapter extends RecyclerView.Adapter<LoadDataAdapter.ViewHolder> {

    Context context;
    ApiResponse mlist;

    public LoadDataAdapter(Context context, ApiResponse itemList) {
        this.context = context;
        this.mlist = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ApiResponse.Rows list = mlist.getRows().get(position);
//        if (list.getTitle() != null)
            holder.txtTitle.setText(list.getTitle());

//        if (list.getDescription() != null)
            holder.txtDesc.setText(list.getDescription());

//        if (list.getImageHref() != null)
            Glide.with(context).load(list.getImageHref()).placeholder(R.drawable.ic_all_inclusive_black_24dp).error(R.drawable.ic_all_inclusive_black_24dp).skipMemoryCache(true).into(holder.imgProfile);



    }

    @Override
    public int getItemCount() {
        return mlist.getRows().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtDesc;
        ImageView imgProfile;

        public ViewHolder(View view) {
            super(view);
            txtTitle = view.findViewById(R.id.txt_title);
            txtDesc = view.findViewById(R.id.txt_desc);
            imgProfile = view.findViewById(R.id.img_profile);
        }
    }
}
