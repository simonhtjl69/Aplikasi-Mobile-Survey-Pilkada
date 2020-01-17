package stud11318062.develops.surveypilkada.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePengumuman {
    @SerializedName("semuamatkul")
    private List<SemuapengumumanItem> semuapengumuman;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setSemuamatkul(List<SemuapengumumanItem> semuapengumuman){
        this.semuapengumuman = semuapengumuman;
    }

    public List<SemuapengumumanItem> getSemuamatkul(){
        return semuapengumuman;
    }

    public void setError(boolean error){
        this.error = error;
    }

    public boolean isError(){
        return error;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString(){
        return
                "ResponseMatkul{" +
                        "semuaroster = '" + semuapengumuman + '\'' +
                        ",error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}