package com.foreignexproject;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapActivity extends AppCompatActivity implements LocationListener
{
    public static final String BANK_NAME="bankName";
    static final int REFRESH_TIME=5000;
    static final float DISTANCE=5;
    String [] markList=null;
    String addressStr , shortAddress ,  bankName ,currentProvider;
    Double currentLat , currentLng;
    int maxResult=1 , launchCount=0;

    LocationManager mgr;
    ConnectivityManager connectivityManager;
    GoogleMap map;
    LatLng currentPoint;
    List<Address> currentAddressList;
    List<Address> addressList;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getInfoAndInitialize();

        setTitle(bankName +" 服務地點");
        setMap();
    }

    private void getInfoAndInitialize()
    {
        textView=(TextView)findViewById(R.id.location_textview);
        mgr=(LocationManager)getSystemService(LOCATION_SERVICE);
        connectivityManager=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        bankName=getIntent().getStringExtra(BANK_NAME);
        if(launchCount<1)
        {
            Toast.makeText(this,"請等待系統取得定位資訊後，\n點選右上方圖示來定位",Toast.LENGTH_LONG).show();
            launchCount++;
        }

    }

    private void setMap()
    {
        if(map==null)
        {
            map =((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if(map!=null)
            {
                map.setMyLocationEnabled(true);
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                map.moveCamera(CameraUpdateFactory.zoomTo(16));
            }
        }
    }
    @Override
    protected void onResume()
    {
        super.onResume();


        // 取得最佳的定位提供者
        // String best = mgr.getBestProvider(new Criteria(), true);
        String networkProvider = LocationManager.NETWORK_PROVIDER;
        String gps = LocationManager.GPS_PROVIDER;
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting()
                || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting())
        { // 取得快取的最後位置,如果有的話
            textView.setText("網路取得定位資訊中...");
            mgr.requestLocationUpdates(networkProvider, REFRESH_TIME, DISTANCE, this);	// 註冊位置事件監聽器
        }
        else if(gps != null)
        {
            textView.setText("GPS取得定位資訊中...");
            mgr.requestLocationUpdates(gps, REFRESH_TIME, DISTANCE, this);
        }
        else
        { // 無提供者, 顯示提示訊息
            textView.setText("請確認已開啟定位功能!");
        }
        setMap();
    }

    @Override
    public void onLocationChanged(Location location)
    {
        if(location!=null)
        {
            currentPoint= new LatLng(location.getLatitude() , location.getLongitude());
            currentLat=location.getLatitude();
            currentLng=location.getLongitude();
            currentProvider=location.getProvider();
        }
        else
        {
            textView.setText("無法取得定位資訊");
        }
        LatLngToAddress(currentLat, currentLng);
    }

    public void LatLngToAddress(Double currentLat , Double currentLng )
    {
        try
        {
            Geocoder geocoder = new Geocoder(getBaseContext());
            currentAddressList = geocoder.getFromLocation(currentLat, currentLng, maxResult);
            Address address = currentAddressList.get(0);
            addressStr = address.getAddressLine(0);
            shortAddress=addressStr.substring(5, 10);
            textView.setText(String.format("定位位置 : %s\n緯度:%.1f , 經度:%.1f ( 以 %s 定位)",
                    shortAddress,
                    currentLat,
                    currentLng,
                    currentProvider.toUpperCase()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        matcher();
    }

    public void matcher()
    {
        BankBranch bankBranch=new BankBranch(bankName,addressStr);
        markList=bankBranch.getMarkList();
        markLocation(markList);
    }

    public void markLocation(String [] markList)
    {
        Geocoder geocoder=new Geocoder(getBaseContext());

        try
        {
            for(int i =0 ; i < markList.length ; i++)
            {
                addressList=geocoder.getFromLocationName(markList[i],1);
                if(addressList==null || addressList.isEmpty() )
                {
                    Toast.makeText(getBaseContext(), "no result found", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Address address = addressList.get(0);
                    LatLng position = new LatLng(address.getLatitude(),address.getLongitude());
                    String snippet = address.getAddressLine(0);
                    map.addMarker(new MarkerOptions().position(position).title(markList[i]).snippet(snippet));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onProviderDisabled(String provider) { }
    @Override
    public void onProviderEnabled(String provider) { }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }




    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()) // 依照選項的 id 來處理
        {
            case R.id.Loction:     // 在地圖中移動到目前位置
            {
                map.animateCamera(CameraUpdateFactory.newLatLng(currentPoint));
                break;
            }
            case R.id.getBankLocation:
            {
                map.moveCamera(CameraUpdateFactory.zoomTo(10));
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onPause()
    {
        super.onPause();
        mgr.removeUpdates(this);	// 停止監聽位置事件
    }

}
