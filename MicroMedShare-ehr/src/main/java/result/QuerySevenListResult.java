package result;
import javax.json.bind.JsonbBuilder;
//SQL result entry.
public class QuerySevenListResult {
	
    private long numBelow18;
    private long num18to40;
    private long numAbove40;

    public QuerySevenListResult(long numBelow18, long num18to40, long numAbove40) {
        this.numBelow18 = numBelow18;
        this.num18to40 = num18to40;
        this.numAbove40 = numAbove40;
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

    public long getNumAbove40() {
        return numAbove40;
    }

    public void setNumAbove40(long numAbove40) {
        this.numAbove40 = numAbove40;
    }
    

   
    
    public String toJson(){
        
        return JsonbBuilder.create().toJson(this);
        
    }

}
