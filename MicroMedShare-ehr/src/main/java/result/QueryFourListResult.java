package result;
import javax.json.bind.JsonbBuilder;
//SQL result entry.
public class QueryFourListResult {
	
    private char gender;
    private long numberOfPatients;
    
    public QueryFourListResult(char gender, long numberOfPatients){
        this.gender = gender;
        this.numberOfPatients = numberOfPatients;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getNumberOfPatients() {
        return numberOfPatients;
    }

    public void setNumberOfPatients(long numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }
    
    public String toJson(){
        return JsonbBuilder.create().toJson(this);
    }
}
