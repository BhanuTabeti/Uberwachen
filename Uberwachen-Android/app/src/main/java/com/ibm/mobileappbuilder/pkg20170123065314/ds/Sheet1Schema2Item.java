
package com.ibm.mobileappbuilder.pkg20170123065314.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Sheet1Schema2Item implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("name") public String name;
    @SerializedName("code") public Double code;
    @SerializedName("datasheet") public String datasheet;
    @SerializedName("quantity") public Double quantity;
    @SerializedName("e") public String e;
    @SerializedName("f") public String f;
    @SerializedName("g") public String g;
    @SerializedName("h") public String h;
    @SerializedName("i") public String i;
    @SerializedName("j") public String j;
    @SerializedName("k") public String k;
    @SerializedName("l") public String l;
    @SerializedName("m") public String m;
    @SerializedName("n") public String n;
    @SerializedName("o") public String o;
    @SerializedName("p") public String p;
    @SerializedName("q") public String q;
    @SerializedName("dataField0") public String dataField0;
    @SerializedName("s") public String s;
    @SerializedName("t") public String t;
    @SerializedName("u") public String u;
    @SerializedName("v") public String v;
    @SerializedName("w") public String w;
    @SerializedName("x") public String x;
    @SerializedName("y") public String y;
    @SerializedName("z") public String z;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeValue(code);
        dest.writeString(datasheet);
        dest.writeValue(quantity);
        dest.writeString(e);
        dest.writeString(f);
        dest.writeString(g);
        dest.writeString(h);
        dest.writeString(i);
        dest.writeString(j);
        dest.writeString(k);
        dest.writeString(l);
        dest.writeString(m);
        dest.writeString(n);
        dest.writeString(o);
        dest.writeString(p);
        dest.writeString(q);
        dest.writeString(dataField0);
        dest.writeString(s);
        dest.writeString(t);
        dest.writeString(u);
        dest.writeString(v);
        dest.writeString(w);
        dest.writeString(x);
        dest.writeString(y);
        dest.writeString(z);
    }

    public static final Creator<Sheet1Schema2Item> CREATOR = new Creator<Sheet1Schema2Item>() {
        @Override
        public Sheet1Schema2Item createFromParcel(Parcel in) {
            Sheet1Schema2Item item = new Sheet1Schema2Item();

            item.id = in.readString();
            item.name = in.readString();
            item.code = (Double) in.readValue(null);
            item.datasheet = in.readString();
            item.quantity = (Double) in.readValue(null);
            item.e = in.readString();
            item.f = in.readString();
            item.g = in.readString();
            item.h = in.readString();
            item.i = in.readString();
            item.j = in.readString();
            item.k = in.readString();
            item.l = in.readString();
            item.m = in.readString();
            item.n = in.readString();
            item.o = in.readString();
            item.p = in.readString();
            item.q = in.readString();
            item.dataField0 = in.readString();
            item.s = in.readString();
            item.t = in.readString();
            item.u = in.readString();
            item.v = in.readString();
            item.w = in.readString();
            item.x = in.readString();
            item.y = in.readString();
            item.z = in.readString();
            return item;
        }

        @Override
        public Sheet1Schema2Item[] newArray(int size) {
            return new Sheet1Schema2Item[size];
        }
    };

}

