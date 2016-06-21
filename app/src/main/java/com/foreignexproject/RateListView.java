package com.foreignexproject;


import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
/*
public class RateListView extends ListActivity
{
    Context context;
    ArrayList<RateBean> rateItem ;
    MyHandler handler;
    RateAdapter adapter;
    String url="http://rate.bot.com.tw/Pages/Static/UIP003.zh-TW.htm";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_list_view);
        context=this;

        main();
    }

    public void main()
    {
        handler = new MyHandler();
        Button button=(Button)findViewById(R.id.fresh_button);
        new t1().start();
        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new t1().start();
            }
        });
    }

    class MyHandler extends Handler
    {

        @Override
        public void handleMessage(Message m)
        {
            if(m.what==0)
            {
                setListAdapter(adapter);
            }
        }
    }

    class t1 extends Thread
    {

        @Override
        public void run()
        {
            try
            {
                RateBean rate;
                int i =0;
                String currency="";
                rateItem =new ArrayList<>();
                Document doc= Jsoup.connect(url).get();
                for(Element e : doc.select("td.titleLeft"))
                {
                    currency=e.text();
                    if(i<doc.select("td.decimal").size())
                    {
                        rate=new RateBean( currency,
                                                                doc.select("td.decimal").eq(i++).text(),
                                                                doc.select("td.decimal").eq(i++).text(),
                                                                doc.select("td.decimal").eq(i++).text(),
                                                                doc.select("td.decimal").eq(i++).text()
                                                                );
                        rateItem.add(rate);
                    }
                }
                adapter=new RateAdapter(context,rateItem);
                handler.sendEmptyMessage(0);

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}*/
