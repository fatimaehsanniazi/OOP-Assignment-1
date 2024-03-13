import java.util.Scanner;

public class User {

  Scanner sc= new Scanner(System.in);
  int user_id;
  String username;
  String contact;
  String borrowed_books;
                  
   User(int u_id, String u_name, String c, String b_books)
   {
    user_id=u_id;
    username=u_name;
    contact=c;
    borrowed_books=b_books;
   }

    
   void addusers() {
    try {
        System.out.println("Enter the name of user:");
        username = sc.nextLine();
        System.out.println("Enter ID:");
        user_id = Integer.parseInt(sc.nextLine()); // Parse integer from input
        System.out.println("Enter contact number:");
        contact = sc.nextLine();
        System.out.println("Enter borrowed books:");
        borrowed_books = sc.nextLine();
    } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a valid number for user ID.");
    }
}


void displayusers()
  {
    System.out.println("\nBorrowed books of user are:");
  System.out.println("\nUser ID:"+user_id+"\nName:"+username+"\nBorrowed Book:"+borrowed_books);
  }

}