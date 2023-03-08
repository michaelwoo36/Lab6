import java.util.NoSuchElementException;
import java.util.Scanner;

public class Tree{ 

    Node overallRoot;
    
    private String fName;
    private String lName;
    private String email;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phone;

    // asks for traversal order
    public void print(Node temp, Scanner input){
        
        System.out.println();
        System.out.println("""
                (p) Preorder
                (i) Inorder
                (o) Postorder
                """);
        print(temp, input.next());
    }
    
    // Prints out last names of employees in determined order
    private void print(Node temp, String ans){
        
        // inorder
        if(temp != null && ans.equals("i")){
           
            print(temp.left, ans);
            System.out.println();
            System.out.println(temp.lName);
            print(temp.right, ans);
        }

        // preorder
        else if(temp != null && ans.equals("p")){

            System.out.println();
            System.out.println(temp.lName);
            print(temp.left, ans);
            print(temp.right, ans);
        }

        // postorder
        else if(temp != null && ans.equals("o")){
            
            print(temp.left, ans);
            print(temp.right, ans);
            System.out.println();
            System.out.println(temp.lName);
        }
    }
    
    // Passes on last name
    public void mod(Node root, Scanner input, String ans){

        lName = ans;
        mod(root, input);
        }
    
    // modifies data value for employee
    private void mod(Node root, Scanner input){
        
        if(root == null){
            
            System.out.println("Employee does not exist");
        }
        
        else if(lName.compareToIgnoreCase(root.lName) == 0){
            
            System.out.println("""
                    What would you like to modify
                    (f) first name
                    (l) last name
                    (e) email
                    (a) address
                    (c) city
                    (s) state
                    (z) zip
                    (p) phone #
                    """);
                    String ans = input.next();

            if(ans.equals("f")){
                
                System.out.println("Enter new first name");
                root.fName = input.next();
            }

            else if(ans.equals("l")){
                
                System.out.println("Enter new last name");
                root.lName = input.next();
            }

            else if(ans.equals("e")){
                
                System.out.println("Enter new email");
                root.email = input.next();
            }

            else if(ans.equals("a")){
                
                System.out.println("Enter new address");
                root.address = input.next();
            }

            else if(ans.equals("c")){
                
                System.out.println("Enter new city");
                root.city = input.next();
            }

            else if(ans.equals("s")){
                
                System.out.println("Enter new state");
                root.state = input.next();
            }

            else if(ans.equals("z")){
                
                System.out.println("Enter new zipcode");
                root.zip = input.nextInt();
            }

            else if(ans.equals("p")){
                
                System.out.println("Enter new phone number");
                root.phone = input.next();
            }


        }

        else if(lName.compareToIgnoreCase(root.lName) < 0){
            
            mod(root.left, input);
        }

        else if(lName.compareToIgnoreCase(root.lName) > 0){
            
            mod(root.right, input);
        }
    }

    // Stores info about added employee
    public void add(Scanner input){
        
        System.out.println();
        System.out.println("Please enter information about the employee you are adding");
        System.out.println("First Name:");
        fName = input.next();
        System.out.println("Last Name:");
        lName = input.next();
        System.out.println("email:");
        email = input.next();
        System.out.println("address:");
        address = input.next();
        System.out.println("city:");
        city = input.next();
        System.out.println("state:");
        state = input.next();
        System.out.println("zipcode:");
        zip = input.nextInt();
        System.out.println("phone number:");
        phone = input.next();

        overallRoot = add(overallRoot);
    }

    // add info to employee node database
    private Node add(Node root){
        
        if(root == null){
            
            root = new Node(fName, lName, email, address, city, state, zip, phone);
            return root;
        }
        
        else if(lName.compareToIgnoreCase(root.lName) < 0){
            
            root.left = add(root.left);
        }
        
        else{
            
            root.right = add(root.right);
        }
        
        return root;
    }

    // Asks for employee key name
    public void delete(Node root, Scanner input){

        System.out.println();
        System.out.println("Please enter the last name of the employee you want to delete");
        System.out.println();

        lName = input.next();
        overallRoot = delete(root);
    }

    // Removes employee from database
    private Node delete(Node root){
        
        if(root == null){
            
            return null;
        }
        
        // Left branch
        else if(lName.compareToIgnoreCase(root.lName) < 0){
        
            root.left = delete(root.left);
        }
        
        // Right branch
        else if(lName.compareToIgnoreCase(root.lName) > 0){
        
            root.right = delete(root.right);
        }
        
        // when value is found
        else{
        
            if(root.right == null){
        
                return root.left;
            }
        
            else if(root.left == null){
        
                return root.right;
            }
        
            else{
        
                root.lName = getMin(root.right); // changes data to smallest value after node disconected
                root.right = delete(root.right);
            }
        }
        
        return root;
    }

    // checks for empty node
    public String getMin(){
        
        if(overallRoot == null){
        
            throw new NoSuchElementException();
        }
        
        return getMin(overallRoot);
    }
    
    // Returns smalles value on lefts side of branch
    private String getMin(Node root){
    
        if(root.left == null){
    
            return root.lName;
        }
    
        else{
            
            return getMin(root.left);
        }
    }
    
    // Returns total number of employees in database
    public int getTotal(Node temp){
        
        if(temp != null){
            
            return 1 + getTotal(temp.right) + getTotal(temp.left);
        }
        
        else{
            
            return 0;
        }

    }

    // Establishes correct employee
    public void lookUp(Node root, Scanner input){
        
        System.out.println();
        System.out.println("Please enter last name of employee you would like to view:");
        System.out.println();
        lName = input.next();
        lookUp(root);
    }

    // Displays full Employee information
    public void lookUp(Node root){

        if(root == null){
            
            System.out.println("no contacts match");
        }
        
        else if(lName.compareToIgnoreCase(root.lName) == 0){
            
            System.out.println();
            System.out.println("< " + root.fName + " " + root.lName + " >");
            System.out.println("email: " + root.address);
            System.out.println("address: " + root.address);
            System.out.println("city: " + root.city);
            System.out.println("state: " + root.state);
            System.out.println("zipcode: " + root.zip);
            System.out.println("phone number: " + root.phone);
        }
        
        else if(lName.compareToIgnoreCase(root.lName) < 0){
        
            lookUp(root.left);
        }
        
        else if(lName.compareToIgnoreCase(root.lName) > 0){
        
            lookUp(root.right);
        }
    }
}
