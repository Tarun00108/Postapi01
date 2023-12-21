package com.example.postapi01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Afactivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afactivity);
        TextView productname = findViewById(R.id.productname);
        TextView sku = findViewById(R.id.sku);
        TextView brandkey = findViewById(R.id.Brandkey);
        TextView finalprice = findViewById(R.id.finalprice);
        TextView baseprice = findViewById(R.id.shipp);
        TextView shipping = findViewById(R.id.shipp);
        ImageView pimg=findViewById(R.id.ig);

        Intent intent = getIntent();

        String str = intent.getStringExtra("product_name");
        String str1 = intent.getStringExtra("brand_name");
        String str3 = intent.getStringExtra("vendor_sku");
        String str4 = intent.getStringExtra("vendorprice_price");
        String str5 = intent.getStringExtra("vendorprice_finalprice");
        String str6 = intent.getStringExtra("vendorprice_shipping");
        String str7 = intent.getStringExtra("product_image");


        productname.setText(str);
        brandkey.setText(str1);
        sku.setText("SKU: " + str3);
        finalprice.setText(str5);
        shipping.setText( str4 + " + " + str6);
        Glide.with(Afactivity.this).load(str7).into(pimg);
       //  pimg.setImageResource(Integer.parseInt(str7));

    }

}