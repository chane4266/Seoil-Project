package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.util.FusedLocationSource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private double lon,lat;
    private NaverMap naverMap;
    private FusedLocationSource locationSource;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final String[] PERMISSION = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };


    List<LatLng> lstLatLng = new ArrayList<>();
    Button MypageBtn;
    Button MypageBtn2;
    Button Listbtn;
    EditText EditLocate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        EditLocate = (EditText)findViewById(R.id.EditLocate);
       // EditLocate.setText();

        Listbtn = (Button) findViewById(R.id.liBtn);
        Listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.liBtn){
                    Intent intentl = new Intent(MainActivity.this,ListActivity.class);
                    startActivity(intentl);
                }
            }
        });


        MypageBtn = (Button) findViewById(R.id.MyBtn);
        MypageBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.MyBtn){
                    Intent intent02 = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent02);
                }
            }
        });


        MypageBtn2 = (Button) findViewById(R.id.MyBtn2);
        MypageBtn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                if(view.getId()==R.id.MyBtn2){
                    Intent intent01 = new Intent(MainActivity.this,MyPageActivity.class);
                    startActivity(intent01);
                }


            }
        });

        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment) fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;

        naverMap.setLocationSource(locationSource); //현재위치
        ActivityCompat.requestPermissions(this, PERMISSION, LOCATION_PERMISSION_REQUEST_CODE);
        //현재위치 표시할때 권한 확인

//        naverMap.addOnLocationChangeListener(new NaverMap.OnLocationChangeListener() { //위도 경도
//            @Override
//            public void onLocationChange(@NonNull Location location) {
//                lat = location.getLatitude();
//                lon = location.getLongitude();
//                Toast.makeText(getApplicationContext(), lat + ",\n" + lon, Toast.LENGTH_SHORT).show();//위도, 경도 토스트 텍스트로 표시하는 코드 (확인용)
//            }
//        });

        Marker markertest = new Marker(); //markertest = 서일대
        markertest.setPosition(new LatLng(37.5857059,127.0974422)); //마커 표시할 위치 (위도, 경도)
        markertest.setMap(naverMap);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            if (!locationSource.isActivated()) {
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
                return;
            } else {
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }




}





    /*온클릭리스너*/