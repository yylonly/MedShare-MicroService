package net.mydreamy.ehr.result;
import javax.json.bind.JsonbBuilder;
//SQL result entry.
public class QueryThreeListResult {
    
    private long numBelow18;
    private long num18to40;
    private long num40to60;

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

    public long getNum40to60() {
        return num40to60;
    }

    public void setNum40to60(long num40to60) {
        this.num40to60 = num40to60;
    }

    public long getNumAbove60() {
        return numAbove60;
    }

    public void setNumAbove60(long numAbove60) {
        this.numAbove60 = numAbove60;
    }
    private long numAbove60;
    
    public QueryThreeListResult(long numBelow18, long num18to40, long num40to60, long numAbove60){
        this.num18to40 = numBelow18;
        this.num18to40 = num18to40;
        this.num40to60 = num40to60;
        this.numAbove60 = numAbove60;
    }
	
    
    
    public String toJson(){
        return JsonbBuilder.create().toJson(this);
    }
}
