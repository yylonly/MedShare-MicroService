package net.mydreamy.ehr.result;
import javax.json.bind.JsonbBuilder;
//SQL result entry.
public class NumberOfAge {

    private long numBelow18;
    private long num18to40;
    private long number40to60;
    private long numAbove60;

    public NumberOfAge(long numBelow18, long num18to40, long number40to60, long numAbove60) {
        this.numBelow18 = numBelow18;
        this.num18to40 = num18to40;
        this.number40to60 = number40to60;
        this.numAbove60 = numAbove60;
    }

    public long getNumBelow18() {
        return numBelow18;
    }

    public void setNumBelow18(long numBelow18) {
        this.numBelow18 = numBelow18;
    }

    public long getNum18to40() {
        return num18to40;
    }

    public void setNum18to40(long num18to40) {
        this.num18to40 = num18to40;
    }

    public long getNumber40to60() {
        return number40to60;
    }

    public void setNumber40to60(long number40to60) {
        this.number40to60 = number40to60;
    }

    public long getNumAbove60() {
        return numAbove60;
    }

    public void setNumAbove60(long numAbove60) {
        this.numAbove60 = numAbove60;
    }
    
    
   
    public String toJson(){
        
        return JsonbBuilder.create().toJson(this);
        
    }

}
