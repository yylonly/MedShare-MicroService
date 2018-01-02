package net.mydreamy.med.result;
import javax.json.bind.JsonbBuilder;
//SQL result entry.
public class QueryFiveListResult {
	
    private long presNum;
	
    public QueryFiveListResult(long presNum){
        this.presNum = presNum;
	}

    public long getPresNum() {
        return presNum;
    }

    public void setPresNum(long presNum) {
        this.presNum = presNum;
    }
    
    
    public String toJson(){
        
        return JsonbBuilder.create().toJson(this);
        
    }

}
