
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class ODFKANDIWEEKDAYSCHEDULESchema1Item implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("odfkandiweekdayschedule") public String odfkandiweekdayschedule;
    @SerializedName("b") public Double b;
    @SerializedName("c") public Date c;
    @SerializedName("d") public Date d;
    @SerializedName("e") public Date e;
    @SerializedName("f") public Date f;
    @SerializedName("g") public Date g;
    @SerializedName("h") public Double h;
    @SerializedName("i") public Date i;
    @SerializedName("j") public Date j;
    @SerializedName("k") public Date k;
    @SerializedName("l") public Date l;
    @SerializedName("m") public Date m;
    @SerializedName("n") public Date n;
    @SerializedName("o") public Date o;
    @SerializedName("p") public Date p;
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
        dest.writeString(odfkandiweekdayschedule);
        dest.writeValue(b);
        dest.writeValue(c != null ? c.getTime() : null);
        dest.writeValue(d != null ? d.getTime() : null);
        dest.writeValue(e != null ? e.getTime() : null);
        dest.writeValue(f != null ? f.getTime() : null);
        dest.writeValue(g != null ? g.getTime() : null);
        dest.writeValue(h);
        dest.writeValue(i != null ? i.getTime() : null);
        dest.writeValue(j != null ? j.getTime() : null);
        dest.writeValue(k != null ? k.getTime() : null);
        dest.writeValue(l != null ? l.getTime() : null);
        dest.writeValue(m != null ? m.getTime() : null);
        dest.writeValue(n != null ? n.getTime() : null);
        dest.writeValue(o != null ? o.getTime() : null);
        dest.writeValue(p != null ? p.getTime() : null);
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

    public static final Creator<ODFKANDIWEEKDAYSCHEDULESchema1Item> CREATOR = new Creator<ODFKANDIWEEKDAYSCHEDULESchema1Item>() {
        @Override
        public ODFKANDIWEEKDAYSCHEDULESchema1Item createFromParcel(Parcel in) {
            ODFKANDIWEEKDAYSCHEDULESchema1Item item = new ODFKANDIWEEKDAYSCHEDULESchema1Item();

            item.id = in.readString();
            item.odfkandiweekdayschedule = in.readString();
            item.b = (Double) in.readValue(null);
            Long cAux = (Long) in.readValue(null);
            item.c = cAux != null ? new Date(cAux) : null;
            Long dAux = (Long) in.readValue(null);
            item.d = dAux != null ? new Date(dAux) : null;
            Long eAux = (Long) in.readValue(null);
            item.e = eAux != null ? new Date(eAux) : null;
            Long fAux = (Long) in.readValue(null);
            item.f = fAux != null ? new Date(fAux) : null;
            Long gAux = (Long) in.readValue(null);
            item.g = gAux != null ? new Date(gAux) : null;
            item.h = (Double) in.readValue(null);
            Long iAux = (Long) in.readValue(null);
            item.i = iAux != null ? new Date(iAux) : null;
            Long jAux = (Long) in.readValue(null);
            item.j = jAux != null ? new Date(jAux) : null;
            Long kAux = (Long) in.readValue(null);
            item.k = kAux != null ? new Date(kAux) : null;
            Long lAux = (Long) in.readValue(null);
            item.l = lAux != null ? new Date(lAux) : null;
            Long mAux = (Long) in.readValue(null);
            item.m = mAux != null ? new Date(mAux) : null;
            Long nAux = (Long) in.readValue(null);
            item.n = nAux != null ? new Date(nAux) : null;
            Long oAux = (Long) in.readValue(null);
            item.o = oAux != null ? new Date(oAux) : null;
            Long pAux = (Long) in.readValue(null);
            item.p = pAux != null ? new Date(pAux) : null;
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
        public ODFKANDIWEEKDAYSCHEDULESchema1Item[] newArray(int size) {
            return new ODFKANDIWEEKDAYSCHEDULESchema1Item[size];
        }
    };

}

