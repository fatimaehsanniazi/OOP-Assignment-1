import java.util.InputMismatchException;
import java.util.Scanner;
public class Library {

    static Scanner input = new Scanner(System.in);
    static int booksize = 100;
    static int usersize = 100;
    static Book[] books = new Book[100]; //creation of book and user array
    static User[] users = new User[100];

    public static void main(String[] args){
    Scanner input = new Scanner(System.in); 
        initializeBooks();
        initializeUsers();
        System.out.println("\t\t\tWelcome to Library Management System");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nPlease enter the task you would like to perform:");
            System.out.println("1) Add Books \n2) Add Users \n3) Display Books \n4) Borrow Books \n5) Return Books \n6) Search Books \n7) Exit");

         int choice = input.nextInt();
            input.nextLine(); // consume newline character

            switch (choice) {
                case 1:
    {
        
    
    System.out.println("How many books do you want to add?");
    int numbook=input.nextInt();
    for(int i=0; i<numbook; i++)
    {
    books[i].addbooks();
    }
    break;
}

    case 2:
    {
        System.out.println("How many users do you want to add?");
        int num_user=input.nextInt();
        for(int i=0; i<num_user; i++)
        {
        users[i].addusers();
        }
        break;
    }
    case 3:
           displaybooks();
             break;
                
    case 4:
           borrowBooks();
             break;
               
    case 5:
           returnbooks();
              break;
                   
    case 6:
           search();
            break;
    case 7:
    exit=true;
    System.out.println("Thank you. Exiting..");
    break;
                       
    default:
     System.out.println("Invalid choice!");
    
            }
        }
    }

    static void initializeBooks() {
       
        for (int k = 0; k < booksize; k++) {
            books[k] = new Book(0, "", "", "", true);
        }
    }

    static void initializeUsers() {
       
        for (int k = 0; k < usersize; k++) {
            users[k] = new User(0, "", "", "");
        }
    }

    
    static void borrowBooks() {
    try {
        String Bt;
        System.out.println("Enter your user ID:");
        int Uid = input.nextInt();
        input.nextLine(); // consume newline character

        // Check if the user ID is valid
        boolean userFound = false;
        for (User user : users) {
            if (user != null && user.user_id == Uid) {
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            System.out.println("User ID not found. Please enter a valid user ID.");
            return;
        }

        System.out.println("Enter title of the book you want to borrow:");
        Bt = input.nextLine();

        // Check if the book title is valid
        boolean bookFound = false;
        for (Book book : books) {
            if (book != null && Bt.equals(book.title)) {
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book not found. Please enter a valid book title.");
            return;
        }

        // Borrow the book
        for (int i = 0; i < booksize; i++) {
            if (Bt.equals(books[i].title)) {
                for (int j = 0; j < usersize; j++) {
                    if (Uid == users[j].user_id) {
                        users[j].borrowed_books = Bt;
                        System.out.println("Book borrowed successfully");
                        users[j].displayusers();
                        books[i].availability = false;
                        return; // exit the loop once the book is borrowed
                    }
                }
            }
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter a valid user ID.");
        input.nextLine(); // clear input buffer
    }
}


    static void returnbooks()
    {

        System.out.println("Enter your user ID:");
        int Uid = input.nextInt();

        String Bt;
        System.out.println("Enter the book you want to return:");
        Bt=input.nextLine();
        Bt=input.nextLine();
          for (int i=0; i<usersize; i++){
            if (Uid==users[i].user_id){
             if (Bt.equals(users[i].borrowed_books))
             {
                 users[i].borrowed_books="";
                 for(int j=0; j<booksize; j++) {
                    if ((books[j].title).equals(Bt))
                    {
                      books[j].availability=true;
                      System.out.println("Book Successfully returned");

                    }
             }
            }
          }
        }
    }

    static void search()
    {
        System.out.println("Enter the title or author of the book you want information about:");
        String title_or_author= input.nextLine();

        for (int i=0; i<booksize; i++){
            if (title_or_author.equals(books[i].title)||title_or_author.equals(books[i].author))
            {
                System.out.println("\nBook ID:"+books[i].book_id+"\nName:"+books[i].title+"\nAuthor:"+books[i].author+"\nGenre:"+books[i].genre+"\nAvailability:"+books[i].availability);
            }
        }
    }

   


      static void displaybooks()
  {
    System.out.println("\nBooks in the Library Management System are:");
    for (int i=0; i<booksize; i++)
    if (books[i].book_id!=0 & books[i].title!=" " & books[i].author!=" " & books[i].genre!=" " & books[i].availability!=false) {
  System.out.println("\nBook ID:"+books[i].book_id+"\nName:"+books[i].title+"\nAuthor:"+books[i].author+"\nGenre:"+books[i].genre+"\nAvailability:"+books[i].availability);
    }
  }


}





    
    


                   