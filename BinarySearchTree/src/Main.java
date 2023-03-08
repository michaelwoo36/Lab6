// Michael Woo
// CS 145
// Lab 6: Dictionary
// VSC

// Creates and allows modifications to employee database.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        Tree tree = new Tree();

        while(true){
            
            intro();

            String ans = input.next();
            
            switch (ans){
                case "a":
                    tree.add(input);
                    break;
                case "g":
                    tree.print(tree.overallRoot, input);
                    System.out.println();
                    System.out.println("There are " + tree.getTotal(tree.overallRoot) + " employees in the database");
                    break;
                case "d":
                    tree.delete(tree.overallRoot, input);
                    break;
                case "m":
                    System.out.println("Enter last name of Employee you wish to modify");
                    tree.mod(tree.overallRoot, input, input.next());
                    break;
                case "l":
                    tree.lookUp(tree.overallRoot, input);
                    break;
            }
        }
    }

    public static void intro(){
        
        System.out.println();
        System.out.println("""
                (a) add
                (g) get database
                (d) delete
                (m) modify
                (l) lookup
                """);
    }
}
