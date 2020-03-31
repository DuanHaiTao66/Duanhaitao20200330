package com.bw.duanhaitao.adapter;
/*
 *@auther:段海涛
 *@Date: 2020-03-30
 *@Time:15:28
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.duanhaitao.R;
import com.bw.duanhaitao.bean.BookBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<BookBean.DataBean.ContentBean>list;
    private Context context;

    public BookAdapter(List<BookBean.DataBean.ContentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book_layout, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.sdv.setImageURI(list.get(position).getBook_cover());
        holder.textName.setText(list.get(position).getBookname());
        holder.textPrice.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView textName;
        private final TextView textPrice;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            textName = itemView.findViewById(R.id.book_Name);
            textPrice = itemView.findViewById(R.id.book_Price);
        }
    }
}
