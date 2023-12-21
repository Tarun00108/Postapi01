package com.example.postapi01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AFadapter extends RecyclerView.Adapter<AFadapter.ViewHolder> {
    Context context;
    List<Afmodel> model;

    public AFadapter(Context context, List<Afmodel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public AFadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.aflayoutr, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AFadapter.ViewHolder holder, int position) {
        Afmodel mod = model.get(position);
        holder.brandname.setText("Brandname= " + mod.getBrandName());
        holder.sku.setText("SKU= " + mod.getVendorSku());
        Glide.with(context).load(mod.getProductImage()).into(holder.product_image);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, Afactivity.class);
                it.putExtra("vendorprice_shipping", mod.getVendorprice_shipping());
                it.putExtra("brand_key", mod.getBrandKey());
                it.putExtra("vendorprice_finalprice", mod.getVendorprice_finalprice());
                it.putExtra("product_name", mod.getProduct_name());
                it.putExtra("vendorprice_price", mod.getVendorprice_price());
                it.putExtra("vendor_sku", mod.getVendorSku());
                it.putExtra("brand_name", mod.getBrandName());
                it.putExtra("product_image" , mod.getProductImage());
                context.startActivity(it);
            }

        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productname, sku, finalprice, shipping, price, brandname, brandkey ;
        ImageView product_image, Image;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            brandname = itemView.findViewById(R.id.tx1);
            product_image = itemView.findViewById(R.id.img);
            sku = itemView.findViewById(R.id.tx2);
            cardView = itemView.findViewById(R.id.cd);


            brandkey = itemView.findViewById(R.id.Brandkey);
            Image = itemView.findViewById(R.id.ig);
            productname = itemView.findViewById(R.id.productname);
            finalprice = itemView.findViewById(R.id.finalprice);
            shipping = itemView.findViewById(R.id.shipp);
            price = itemView.findViewById(R.id.shipp);

        }
    }

    public  void  modelInserted(List<Afmodel> models){
        model = models ;
        notifyDataSetChanged();
    }
}
