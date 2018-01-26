package net.mydreamy.ehr.result;
import javax.json.bind.JsonbBuilder;
//SQL result entry.
public class QueryTwoListResult {
	
    private String diagnoseText;
    private long number;
	
    public QueryTwoListResult(String diagnoseText, long number){
        this.diagnoseText = diagnoseText;
        this.number = number;
	}

    public String getDiagnoseText() {
        return diagnoseText;
    }

    public void setDiagnoseText(String diagnoseText) {
        this.diagnoseText = diagnoseText;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
    
    public String toJson(){
        
        return JsonbBuilder.create().toJson(this);
        
    }

}
