/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result;

import javax.json.bind.JsonbBuilder;

/**
 *
 * @author lp
 */
public class DQListResult {
    private String countryName;
    private long totalNumber;
    
    public DQListResult(String countryName, long totalNumber){
        this.countryName = countryName;
        this.totalNumber = totalNumber;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
