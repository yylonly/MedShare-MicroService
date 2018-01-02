package result;
import javax.json.bind.JsonbBuilder;
//SQL result entry.
public class QueryEightListResult {
    
    private String medicationName;
    private long totalNumber;
	
    public QueryEightListResult(String medicationName, long totalNumber){
            this.medicationName = medicationName;
            this.totalNumber = totalNumber;
	}

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }
    
    public String toJson(){
        
        return JsonbBuilder.create().toJson(this);
        
    }

}
