public class Node {
    String fName;
    String lName;
    String email;
    String address;
    String city;
    String state;
    int zip;
    String phone;
   
    Node left = null;
    Node right = null;

    public Node (String fName, String lName, String email, String addy, String city, String state, int zip, String phone){
        
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.address = addy;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }
}
