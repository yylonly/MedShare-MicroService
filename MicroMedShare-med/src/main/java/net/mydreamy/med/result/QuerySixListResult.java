package net.mydreamy.med.result;
import javax.json.bind.JsonbBuilder;
//SQL result entry.
public class QuerySixListResult {
	
    private long patientNumber;
	
    public QuerySixListResult(long patientNumber){
        this.patientNumber = patientNumber;
	}

    public long getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(long patientNumber) {
        this.patientNumber = patientNumber;
    }

    
    
    
    public String toJson(){
        
        return JsonbBuilder.create().toJson(this);
        
    }

}
