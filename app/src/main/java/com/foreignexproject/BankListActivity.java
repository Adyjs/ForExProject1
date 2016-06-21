package com.foreignexproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BankListActivity extends Activity
{
    ArrayList<bankCategory> bankListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);

        main();
    }

    private void main()
    {
        bankListItem=new ArrayList<>();
        bankListItem.add( new bankCategory("(004)","台灣銀行", "http://rate.bot.com.tw/Pages/Static/UIP003.zh-TW.htm"));
        bankListItem.add( new bankCategory("(808)","玉山銀行", "http://www.esunbank.com.tw/info/rate_spot_exchange.aspx"));
        bankListItem.add( new bankCategory("(054)","京城銀行", "http://www.ktb.com.tw/Exchange_Rates.asp"));
        bankListItem.add( new bankCategory("(822)","中國信託商銀", "https://www.ctbcbank.com/CTCBPortalWeb/toPage?id=TW_RB_CM_ebank_018001"));
        bankListItem.add( new bankCategory("(006)","合作金庫銀行", "http://www.tcb-bank.com.tw/finance_info/Pages/foreign_spot_rate.aspx"));



        ArrayAdapter<bankCategory> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,bankListItem);
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(itemClick);
    }

    OnItemClickListener itemClick = new OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView , View view , int position , long id)
        {
            bankCategory category = bankListItem.get(position);
            Intent intent = new Intent(BankListActivity.this,CashOrSpotActivity.class);
            intent.putExtra(CashOrSpotActivity.EXTRA_BANK_NAME,category.bankName);
            intent.putExtra(CashOrSpotActivity.EXTRA_BANK_PAGE_URL,category.pageUrl);
            startActivity(intent);
        }
    };


    public class bankCategory
    {
        String bankName ,  pageUrl , code;

        bankCategory(String code , String bankName , String pageUrl)
        {
            this.code=code;
            this.bankName=bankName;
            this.pageUrl=pageUrl;
        }

        @Override
        public String toString()
        {
            return code+"\t"+bankName;
        }
    }
}