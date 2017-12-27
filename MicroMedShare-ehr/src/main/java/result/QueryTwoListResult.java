package result;

//SQL result entry.
public class QueryTwoListResult {
	
    private String diagnoseText;
    private int number;
	
    public QueryTwoListResult(String diagnoseText, int number){
        this.diagnoseText = diagnoseText;
        this.number = number;
	}

    public String getDiagnoseText() {
        return diagnoseText;
    }

    public void setDiagnoseText(String diagnoseText) {
        this.diagnoseText = diagnoseText;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
