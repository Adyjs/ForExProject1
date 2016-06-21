package com.foreignexproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SpotAdapter extends BaseAdapter
{
    private LayoutInflater inflater;
    private ArrayList<RateBean> list = new ArrayList<>();


    public SpotAdapter(Context context , ArrayList<RateBean> list)
    {
        inflater=LayoutInflater.from(context);
        this.list=list;
    }

    class ViewHolder
    {
        TextView holderCurrency , holderBuyIn , holderSoldOut ;


        public ViewHolder(TextView holderCurrency ,
                                             TextView holderBuyIn ,
                                             TextView holderSoldOut )
        {
            this.holderCurrency=holderCurrency;
            this.holderBuyIn=holderBuyIn;
            this.holderSoldOut=holderSoldOut;
        }
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
            convertView=inflater.inflate(R.layout.activity_spot_adapter, null);
            holder = new ViewHolder
                    (
                            (TextView)convertView.findViewById(R.id.xml_currency),
                            (TextView)convertView.findViewById(R.id.xml_buyIn),
                            (TextView)convertView.findViewById(R.id.xml_soldOut)
                    );

            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
        }

        RateBean rate = list.get(position);
        holder.holderCurrency.setText(rate.getCurrency());
        holder.holderBuyIn.setText(rate.getBuyIn());
        holder.holderSoldOut.setText(rate.getSoldOut());
        return convertView;
    }
}
