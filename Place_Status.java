public class Place_Status {
    private int place_id;
    private String place_status;

    public Place_Status(){
        this.place_status = "Open";
    }

    public void Set_places_status(String place_status){
        this.place_status = place_status;
    }    
    public String Get_place_status(){
        return this.place_status;
    }
}
