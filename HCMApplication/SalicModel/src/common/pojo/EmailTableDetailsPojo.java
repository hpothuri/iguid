package common.pojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class EmailTableDetailsPojo {
    public EmailTableDetailsPojo() {
        super();
    }
    
    private ArrayList<String> tableContentColumns = new ArrayList<String>();
    private String detailsQuery;
    private LinkedHashMap<String, String> tableColumnDatatypes = new LinkedHashMap<String, String>();
    private String tableLabel;

    public void setTableContentColumns(ArrayList<String> tableContentColumns) {
        this.tableContentColumns = tableContentColumns;
    }

    public ArrayList<String> getTableContentColumns() {
        return tableContentColumns;
    }

    public void setDetailsQuery(String detailsQuery) {
        this.detailsQuery = detailsQuery;
    }

    public String getDetailsQuery() {
        return detailsQuery;
    }

    public void setTableColumnDatatypes(LinkedHashMap<String, String> tableColumnDatatypes) {
        this.tableColumnDatatypes = tableColumnDatatypes;
    }

    public LinkedHashMap<String, String> getTableColumnDatatypes() {
        return tableColumnDatatypes;
    }

    public void setTableLabel(String tableLabel) {
        this.tableLabel = tableLabel;
    }

    public String getTableLabel() {
        return tableLabel;
    }
}
