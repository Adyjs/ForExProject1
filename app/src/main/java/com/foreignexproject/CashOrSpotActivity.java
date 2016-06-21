package com.foreignexproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CashOrSpotActivity extends Activity
{
    ArrayList<OptionCategory> optionItem;
    public static final String EXTRA_BANK_NAME="bank_name";
    public static final String EXTRA_BANK_PAGE_URL="page_url";
    String bankName , pageUrl;
    Context context =this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_or_spot);

        getInformation();
        main();
    }

    public void getInformation()
    {
        bankName=getIntent().getStringExtra(EXTRA_BANK_NAME);
        pageUrl=getIntent().getStringExtra(EXTRA_BANK_PAGE_URL);
        setTitle(bankName);
    }
    public void main()
    {
        optionItem = new ArrayList<>();

        optionItem.add( new OptionCategory("現金匯率"));
        optionItem.add( new OptionCategory("即期匯率"));
        optionItem.add( new OptionCategory("現金匯率 & 即期匯率"));

        ArrayAdapter<OptionCategory> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,optionItem);
        ListView optionList = (ListView)findViewById(R.id.listview_cash_or_spot);
        optionList.setAdapter(adapter);
        optionList.setOnItemClickListener(itemClick);
    }

    OnItemClickListener itemClick = new OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            switch (position)
            {
                case 0:
                {
                    OptionCategory  optionCategory = optionItem.get(position);
                    Intent intent = new Intent(CashOrSpotActivity.this,CashRateActivity.class);
                    intent.putExtra(CashRateActivity.EXTRA_BANK_NAME,bankName);
                    intent.putExtra(CashRateActivity.EXTRA_BANK_PAGE_URL,pageUrl);
                    intent.putExtra(CashRateActivity.EXTRA_BANK_OPTION, optionCategory.option);
                    startActivity(intent);
                    break;
                }
                case 1:
                {
                    OptionCategory  optionCategory = optionItem.get(position);
                    Intent intent = new Intent(CashOrSpotActivity.this,SpotRateActivity.class);
                    intent.putExtra(SpotRateActivity.EXTRA_BANK_NAME,bankName);
                    intent.putExtra(SpotRateActivity.EXTRA_BANK_PAGE_URL,pageUrl);
                    intent.putExtra(SpotRateActivity.EXTRA_BANK_OPTION, optionCategory.option);
                    startActivity(intent);
                    break;
                }

                case 2:
                {
                    Toast.makeText(context,"Activity 製作中 ",Toast.LENGTH_SHORT).show();
                    /*
                    OptionCategory  optionCategory = optionItem.get(position);
                    Intent intent = new Intent(CashOrSpotActivity.this,AllRateActivity.class);
                    intent.putExtra(CashRateActivity.EXTRA_BANK_NAME,bankName);
                    intent.putExtra(CashRateActivity.EXTRA_BANK_PAGE_URL, pageUrl);
                    intent.putExtra(CashRateActivity.EXTRA_BANK_OPTION, optionCategory.option);
                    startActivity(intent);*/
                    break;
                }
            }
        }
    };

    public class OptionCategory
    {
        String option;

        public OptionCategory(String option)
        {
            this.option=option;
        }

        @Override
        public String toString ()
        {
            return option;
        }
    }

}
