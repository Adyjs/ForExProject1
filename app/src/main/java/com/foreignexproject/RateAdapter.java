package com.foreignexproject;


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/*
public class RateAdapter extends BaseAdapter
{

    private LayoutInflater inflater;
    private ArrayList<RateBean> list = new ArrayList<>();
    public RateAdapter(Context context , ArrayList<RateBean> list)
    {
        inflater = LayoutInflater.from(context);
        this.list = list;
    }
    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position , View convertView , ViewGroup parent)
    {
        ViewHolder holder ;
        if(convertView == null)
        {
            convertView=inflater.inflate(R.layout.activity_rate_adapter, null);
            holder = new ViewHolder
            (
                (TextView)convertView.findViewById(R.id.xml_currency),
                (TextView)convertView.findViewById(R.id.xml_cashIn),
                (TextView)convertView.findViewById(R.id.xml_cashOut),
                (TextView)convertView.findViewById(R.id.xml_spotIn),
                (TextView)convertView.findViewById(R.id.xml_spotOut)
            );

            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
        }

        RateBean rate = list.get(position);
        holder.holderCurrency.setText(rate.getCurrency());
        holder.holderCashIn.setText(rate.getCashIn());
        holder.holderCashOut.setText(rate.getCashOut());
        holder.holderSpotIn.setText(rate.getSpotIn());
        holder.holderSpotOut.setText(rate.getSpotOut());
        return convertView;
    }

    class ViewHolder
    {
        TextView holderCurrency , holderCashIn , holderCashOut , holderSpotIn , holderSpotOut;

        public ViewHolder(TextView holderCurrency , TextView holderCashIn , TextView holderCashOut , TextView holderSpotIn , TextView holderSpotOut)
        {
            this.holderCurrency=holderCurrency;
            this.holderCashIn=holderCashIn;
            this.holderCashOut=holderCashOut;
            this.holderSpotIn=holderSpotIn;
            this.holderSpotOut=holderSpotOut;
        }
    }


}*/
