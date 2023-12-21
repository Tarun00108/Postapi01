
package com.example.postapi01;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import java.time.LocalDate;

public class Afmodel {
    @SerializedName("product_image")
    @Expose
    private String product_image;
    @SerializedName("product_name")
    @Expose
    private String product_name;
    @SerializedName("vendor_name")
    @Expose
    private String vendor_name;
    @SerializedName("vendor_sku")
    @Expose
    private String vendor_sku;
    @SerializedName("vendorprice_price")
    @Expose
    private String vendorprice_price;
    @SerializedName("mapPrice")
    @Expose
    private String mapPrice;
    @SerializedName("vendorprice_finalprice")
    @Expose
    private String vendorprice_finalprice;
    @SerializedName("vendorprice_shipping")
    @Expose
    private String vendorprice_shipping;
    @SerializedName("secondVendorProductid")
    @Expose
    private String secondVendorProductid;
    @SerializedName("fifthVendorPrice")
    @Expose
    private String fifthVendorPrice;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("FirstVendorName")
    @Expose
    private String FirstVendorName;
    @SerializedName("brand_name")
    @Expose
    private String brand_name;
    @SerializedName("brand_id")
    @Expose
    private String brand_id;
    @SerializedName("thirdVendorBasePrice")
    @Expose
    private String thirdVendorBasePrice;
    @SerializedName("brand_key")
    @Expose
    private String brand_key;
    @SerializedName("thirdVendorProductid")
    @Expose
    private String thirdVendorProductid;
    @SerializedName("firstVendorProductid")
    @Expose
    private String firstVendorProductid;

    public String getProductImage() {
        return product_image;
    }

    public void setProductImage(String value) {
        this.product_image = value;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String value) {
        this.product_name = value;
    }

    public String getVendorSku() {
        return vendor_sku;
    }

    public void setVendorSku(String value) {
        this.vendor_sku = value;
    }

    public String getVendorprice_price() {
        return vendorprice_price;
    }

    public void setVendorprice_price(String value) {
        this.vendorprice_price = value;
    }

    public String getVendorprice_finalprice() {
        return vendorprice_finalprice;
    }

    public void setVendorprice_finalprice(String value) {
        this.vendorprice_finalprice = value;
    }

    public String getVendorprice_shipping() {
        return vendorprice_shipping;
    }

    public void setVendorprice_shipping(String value) {
        this.vendorprice_shipping = value;
    }


    public String getVendorName() {
        return FirstVendorName;
    }

    public void setVendorName(String value) {
        this.FirstVendorName = value;
    }

    public String getBrandName() {
        return brand_name;
    }

    public void setBrandName(String value) {
        this.brand_name = value;
    }

    public String getBrandid() {
        return brand_id;
    }

    public void setBrandid(String value) {
        this.brand_id = value;
    }

    public String getBrandKey() {
        return brand_key;
    }

    public void setBrandKey(String value) {
        this.brand_key = value;
    }


}
