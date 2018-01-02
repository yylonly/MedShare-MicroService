package net.mydreamy.ehr.result;

//SQL result entry.
public class ListResult {
	private int id;
	private String description;
	private String sqlquery;
	private String url;
	public ListResult(int id, String des, String sql, String url)
	{
            this.id = id;
            this.description = des;
            this.sqlquery = sql;
            this.url = url;
	}
	public int getId() {
            return id;
	}
	public void setId(int id) {
            this.id = id;
	}
	public String getDescription() {
            return description;
	}
	public void setDescription(String description) {
            this.description = description;
	}
	public String getSqlquery() {
            return sqlquery;
	}
	public void setSqlquery(String sqlquery) {
            this.sqlquery = sqlquery;
	}
	public String getUrl() {
            return url;
	}
	public void setUrl(String url) {
            this.url = url;
	}
}
