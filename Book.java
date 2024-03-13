import java.util.Scanner;
public class Book {
   Scanner sc= new Scanner(System.in);
  int book_id;
  String title;
  String author;
  String genre;
  boolean availability;

  Book(int b_id, String t, String a, String g, boolean av)
  {
    book_id=b_id;
    title=t;
    author=a;
    genre=g;
  }

  void displaybooks()
  {
    System.out.println("\nBooks in the Library Management System are:");
  System.out.println("\nBook ID:"+book_id+"\nName"+title+"\nAuthor"+author+"\nGenre:"+genre+"\nAvailability:"+availability);
  }

  void addbooks()
{ //Error Handling
  try {
    System.out.println("Enter name of the book:");
    title = sc.nextLine();
    
    System.out.println("Enter book ID:");
    String idInput = sc.nextLine();
    // Parse the input string to an integer
    book_id = Integer.parseInt(idInput);
} catch (NumberFormatException e) {
    System.out.println("Invalid input for book ID. Please enter an integer value.");
    return; //  Return from the method to prevent further execution
}

    System.out.println("Enter author:");
    author=sc.nextLine();
    
    System.out.println("Enter genre:");
    genre=sc.nextLine();
    availability= true;

}
}