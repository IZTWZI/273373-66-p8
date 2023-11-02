public class Table {
    private int table_id[];
    private String table_status[];

    public Table(){

    }

    public Table(int table_id[],String table_status[]) {
        this.table_id = table_id;
        this.table_status = table_status;
    }

    public void Set_table_status(int table_id) {
        this.table_status[table_id] = "full";
    }
    public void Set_table_id(int table_id) {
    }

    public String Get_table_status(int table_id) {
        return this.table_status[table_id];
    }
    public int[] Get_table_id() {
        return this.table_id;
    }
}
