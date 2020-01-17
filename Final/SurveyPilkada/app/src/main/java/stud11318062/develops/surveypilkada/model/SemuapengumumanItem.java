package stud11318062.develops.surveypilkada.model;

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.SerializedName;

public class SemuapengumumanItem {
@SerializedName("judul")
private String judul;

@SerializedName("id")
private String id;

@SerializedName("isi")
private String isi;

public void setJudul(String judul){
    this.judul = judul;
}

public String getJudul(){
    return judul;
}

public void setId(String id){
    this.id = id;
}

public String getId(){
    return id;
}

public void setIsi(String isi){
    this.isi= isi;
}

public String getIsi(){
    return isi;
}

@Override
public String toString(){
    return
            "SemuamatkulItem{" +
                    "judul = '" + judul + '\'' +
                    ",id = '" + id + '\'' +
                    ",isi = '" + isi+ '\'' +
                    "}";
}
}