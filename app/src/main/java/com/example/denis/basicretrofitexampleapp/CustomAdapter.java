package com.example.denis.basicretrofitexampleapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.denis.basicretrofitexampleapp.network.GetDataServices;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<CurrencyData> dataList;
    private Context context;

    public CustomAdapter(Context context, List<CurrencyData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.currency_list_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.currencyTextView.setText(dataList.get(position).getCurrency());
        holder.unitValueTextView.setText(String.valueOf(dataList.get(position).getUnitValue()));
        holder.buyingRateTextView.setText(String.valueOf(dataList.get(position).getBuyingRate()));
        holder.medianRateTextView.setText(String.valueOf(dataList.get(position).getMedianRate()));
        holder.sellingRateTextView.setText(String.valueOf(dataList.get(position).getSellingRate()));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView currencyTextView;
        TextView unitValueTextView;
        TextView buyingRateTextView;
        TextView medianRateTextView;
        TextView sellingRateTextView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            currencyTextView = mView.findViewById(R.id.currency_textview);
            unitValueTextView = mView.findViewById(R.id.unit_value_textview);
            buyingRateTextView = mView.findViewById(R.id.buying_rate_textview);
            medianRateTextView = mView.findViewById(R.id.median_rate_textview);
            sellingRateTextView = mView.findViewById(R.id.selling_rate_textview);
        }
    }
}
