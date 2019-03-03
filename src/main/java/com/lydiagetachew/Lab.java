package com.lydiagetachew;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lydiagetachew.book.Book;
import com.lydiagetachew.book.Digital;
import com.lydiagetachew.book.HardCopy;
import com.lydiagetachew.people.Academic;
import com.lydiagetachew.people.Lecture;
import com.lydiagetachew.people.Student;

import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab {
    static int num;
    static int validator;
    static int loop = 0, track = 0;
    static String username, key;
    static boolean bool = false;
    static int pos;
    static String password;

    private static Console console = System.console();


    static int n_hard = 0, n_digital;
    static Book book = new Book();
    static Borrow borrow = new Borrow();

    static ArrayList<Book> HBOOK = new ArrayList<>();//arraylist to store hardcopy
    static ArrayList<Book> DBOOK = new ArrayList<>();//arraylist to store digital books
    static ArrayList<Borrow> BORROW = new ArrayList<>();
    static ArrayList<Lecture> LEC = new ArrayList<>();
    static ArrayList<Student> STUD = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static HashMap<Integer, ArrayList> libraryHash = new HashMap<>();

    public static void main(String [] args) {
        System.out.println("\n\n\t\t\t\t\t\t\tMEKELLE UNIVERISTY\n\n\t\t\t\t\t\tOBJECT ORIENTED PROGRAMMING PROJECT\n\n\t\t\t\t\tLABRARY MANAGMENT SYSTEM\n\n");
        System.out.println("\n\n\t\t\t\t\t\t##         #######  ######  ########  #######  ########   ##      ## ");
        System.out.println("\n  \t\t\t\t\t\t##         #######  ######  ##   ##   #######  ##   ##     ##    ##  ");
        System.out.println("\n  \t\t\t\t\t\t##           ##     ##  ##  ##  ##    ##   ##  ##  ##       ######   ");
        System.out.println("\n  \t\t\t\t\t\t##           ##     ######  #####     #######  #####        #####   ");
        System.out.println("\n  \t\t\t\t\t\t##           ##     ######  ##  ##    #######  ##  ##       #### ");
        System.out.println("\n  \t\t\t\t\t\t#########  #######  ##  ##  ##   ##   ##   ##  ##   ##      ### ");
        System.out.println("\n  \t\t\t\t\t\t#########  #######  ######  ##    ##  ##   ##  ##    ##    ### ");
        System.out.println();

        System.out.println("\n\n\t\t  =====+++++++++++++++++++=======");
        System.out.println("\n  \t\t  |  lIBRARY MANAGEMENT SYSTEM      |");
        System.out.println("\n\t\t  =====+++++++++++++++++++=======");
        do {
            System.out.println("Please choose an account \n");
            System.out.println("\n\n\t\t\t#1.---------labrarian\n");
            System.out.println("\n\n\t\t\t#2.---------Student\n");
            System.out.println("\n\n\t\t\t#3.---------Lecture\n");
            System.out.println("\n\n\t\t\t#8.---------  EXIT");
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    librarianPage();
                    break;
                case 2:
                    StudentPage();
                    break;

                case 3:

                    LecturerPage();
                    break;
                default:
                    System.out.println("\nIncorrect choice , Please re-enter");
                    loop = 1;
                    break;
                case 0:
                    System.exit(0);
            }

        } while (loop == 1);

        ///////// Exporting option before eXiting ////////////
        if (loop == 2) {
            System.out.println("Do you want to export the changes you made ? If yes press 1 \n ");
            num = scanner.nextInt();
            if (num == 1) {
                System.out.println(libraryHash);
                exportBook();
            } else {


                System.out.println("< S Y S T E M  _  T E R M I N A T E D  >");
                System.exit(1);
            }
        }
    }

    private static ArrayList<Book> addBook(ArrayList HBOOK, ArrayList DBOOK) {
        scanner.nextLine();

        System.out.println("\nBook Adding ");
        System.out.println("1) For hard copy ");
        System.out.println("2) For digital book\n");
        num = scanner.nextInt();
        scanner.nextLine();

        if (num == 1) {
            System.out.println("BOOKA IN HARD COPY");
            System.out.println("\nHow many book/s do you want to add?\n");
            n_hard = scanner.nextInt();
            scanner.nextLine();


            for (int i = 0; i < n_hard; i++) {

                HardCopy hardCopy = new HardCopy();
                System.out.println("\nEnter the requested information");
                System.out.println("\n Book name ");
                String bookName = scanner.nextLine();
                hardCopy.setName(bookName);
                System.out.println("\n Book Id ");

                String bookId = scanner.nextLine();
                hardCopy.setId(bookId);

                System.out.println("\n Author");
                String author = scanner.nextLine();
                hardCopy.setAuthor(author);
                System.out.println("\n Number of pages  ");
                int page = scanner.nextInt();

                hardCopy.setNumberOfPages(page);
                scanner.nextLine();
                System.out.println("\n Published date  ");
                String publishedDate = scanner.nextLine();
                hardCopy.setPublishedDate(publishedDate);
                System.out.println("\n publisher  ");

                String publisher = scanner.nextLine();
                hardCopy.setPublisher(publisher);

                System.out.println("\n Number of books  ");
                String number = scanner.nextLine();
                hardCopy.setNumberofbooks(number);

                HBOOK.add(hardCopy);
                scanner.nextLine();

                libraryHash.put(i + 1, HBOOK);
            }
            return HBOOK;
        } else if (num == 2) {
            System.out.println("\nDIGITAL BOOKS\n");
            System.out.println("\nHow many book/s do you want to add?\n");
            n_digital = scanner.nextInt();
            scanner.nextLine();
            HashMap<Integer, ArrayList> libraryHash = new HashMap<>();


            for (int i = 0; i < n_digital; i++) {

                Digital digital = new Digital();
                System.out.println("\nFill the requested information");
                System.out.println("\n Book name ");
                String bookName = scanner.nextLine();
                digital.setName(bookName);
                System.out.println("\n Book Id ");

                String bookId = scanner.nextLine();
                digital.setId(bookId);

                System.out.println("\n Author");
                String author = scanner.nextLine();
                digital.setAuthor(author);
                System.out.println("\n Number of pages  ");
                int page = scanner.nextInt();

                digital.setNumberOfPages(page);
                scanner.nextLine();
                System.out.println("\n Published date  ");
                String publishedDate = scanner.nextLine();
                digital.setPublishedDate(publishedDate);
                System.out.println("\n publisher  ");

                String publisher = scanner.nextLine();
                digital.setPublisher(publisher);

                System.out.println("\n Size(in Kb)  ");
                float size = scanner.nextFloat();

                digital.setSize(size);

                DBOOK.add(digital);
                scanner.nextLine();
                libraryHash.put(i + 1, DBOOK);

            }
        }
        return DBOOK;
    }


    private static void viewBooks() {
        if (DBOOK.size() == 0 && HBOOK.size() == 0) {
            System.out.println("N O _ B O O K S _ I N _ T H E _ L I B R A R Y\n");
        } else {
            // HashMap<String, ArrayList> libraryHash = null;
            System.out.println(" BOOKS \n`'`'`'`'`'`\nH A R D C O P Y \n");
            for (int i = 0; i < HBOOK.size(); i++)
                System.out.println(i + 1 + " " + HBOOK.get(i) + "\n");

            System.out.println("\nD I G I T A L\n");
            for (int i = 0; i < DBOOK.size(); i++)
                System.out.println(i + 1 + " " + DBOOK.get(i) + " \n");
        }
    }

    public static void viewBorrowers() {
        if (BORROW.size() == 0) {
            System.out.println("Empty Borrowers or no Borrowers added\n");
        }
        System.out.println("Borrowers book\n-------------------");
        for (int i = 0; i < BORROW.size(); i++)
            System.out.println(i + 1 + " " + BORROW.get(i) + "\n");
    }


    private static void borrowBook()//all attributes are common to both student and lecturer
    {


        System.out.println("\nDisplaying available books(Hardcopy)\n\t");
        viewBooks();
        System.out.println("Enter the name of book to be borrowed\n");
        String key = scanner.nextLine();
        if (searchBook(key)) {
            HashMap<Integer, ArrayList> libraryHash = new HashMap<>();

        }

        System.out.println("Enter the requested info\n");
        System.out.println("1.Lecturer");
        System.out.println("2.Student\n");
        num = scanner.nextInt();
        switch (num) {
            case 1:
                System.out.println("Lecturer borrowing \n");
                System.out.println("Enter lecturers id");
                key = scanner.nextLine();
                for (int i = 0; i < LEC.size(); i++) {
                    if (key == LEC.get(i).getId()) {
                        LEC.get(i).setMaxBook(+1);
                        bool = true;
                    }
                }
                if (bool = false) {
                    System.out.println("Lecturer id not found /!\\");
                    break;
                }


                System.out.println("\nBorrower id");
                String borrowerId = scanner.nextLine();
                borrow.setBorrower_id(borrowerId);

                borrow = new Borrow();

                System.out.println("\nBorrowing id");
                String id = scanner.nextLine();
                borrow.setId(id);

                System.out.println("\nBook id");
                String bookId = scanner.nextLine();
                borrow.setBook_id(bookId);


                System.out.println("\nBorrowed date ");
                String borrowedDate = scanner.nextLine();
                borrow.setborrowed_date(borrowedDate);

                System.out.println("\nLibrarian id");
                String librarianId = scanner.nextLine();
                borrow.setlibrarian_id(librarianId);

                System.out.println("\nStatus");
                String state = scanner.nextLine();
                borrow.setstatus(state);

                //############ NO_of_copies --
                BORROW.add(borrow);
                libraryHash.put(track++, BORROW);
                break;
            case 2:
                System.out.println("Student borrwing zone");
                borrow = new Borrow();

                System.out.println("\nBorrowing id");
                id = scanner.nextLine();
                borrow.setId(id);

                System.out.println("\nBook id");
                bookId = scanner.nextLine();
                borrow.setBook_id(bookId);

                System.out.println("\nBorrower id");
                borrowerId = scanner.nextLine();
                borrow.setBorrower_id(borrowerId);

                System.out.println("\nBorrowed date ");
                borrowedDate = scanner.nextLine();
                borrow.setborrowed_date(borrowedDate);

                System.out.println("\nLibrarian id");
                librarianId = scanner.nextLine();
                borrow.setlibrarian_id(librarianId);

                state = scanner.nextLine();
                borrow.setstatus(state);

                //############ NO_of_copies --
                BORROW.add(borrow);
                libraryHash.put(track++, BORROW);
                break;
        }

    }


    private static Boolean searchBook(String key) {
        scanner.nextLine();
        Boolean bool = false;
        System.out.println("\n Searching zone \n0/0/0/0/0/0/0/0/0/0/0/0\n");
        System.out.println("Enter name of book to search\n");
        key = scanner.nextLine();
        if (HBOOK.size() == 0) {
            System.out.println("No hardcopy books in the library ");
        }

        for (int i = 0; i < HBOOK.size(); i++) {//if size of hbook is 0 loop wont start


//        bool=BOOK.set(i,Book.).equals(key);
            String cmp = HBOOK.get(i).getName();

            if ((cmp).equals(key)) {
                System.out.println(cmp + "  book  is found in library :) \n");
                bool = true;
            }

        }
        return bool;
    }

    private static void removeBook() {
        System.out.println(" B O O K  R E M O V I N G  Z O N E\n-------------------------\n");
        System.out.println("Choose 1.Hardcopy\t 2.Digital\n");
        num = scanner.nextInt();
        scanner.nextLine();
        Boolean bool = false;
        System.out.println("Enter the name of the book ");
        String key = scanner.nextLine();
        String cmp;
        if (num == 1) {
            for (int i = 0; i < HBOOK.size(); i++) {
                cmp = HBOOK.get(i).getName();
                if ((cmp).equals(key)) {
                    HBOOK.remove(i);
                    System.out.println("Book " + cmp + " is succesfully removed !");
                    bool = true;
                }
            }
            if (bool = false)
                System.out.println("Book not found :( ");
        }
        if (num == 2) {
            for (int i = 0; i < DBOOK.size(); i++) {
                cmp = DBOOK.get(i).getName();
                if ((cmp).equals(key)) {
                    DBOOK.remove(i);
                    System.out.println("Book " + cmp + " is succesfully removed !");
                } else
                    System.out.println("Book not found :( ");
            }
        }
    }

    private static void editBook() {
        System.out.println("\nB O O K  I N F O.  E D I T I N G   Z O N E ");
        System.out.println("\n^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`\n");
        System.out.println("Choose\n1.HARDCOPY\t\t2.DIGITAL");
        num = scanner.nextInt();
        scanner.nextLine();

        if (num == 1) {
            System.out.println("Enter the name of the book\n");
            String key = scanner.nextLine();

            for (int i = 0; i < HBOOK.size(); i++) {

                String nam = HBOOK.get(i).getName();
                if ((nam).equals(key))
                    loop = 1;
                pos = i;
            }
            if (loop == 0) {
                System.out.println("\n Sorry :( BOOK not found in library\n");
            } else {
                System.out.println("  Enter edited info of  Book " + HBOOK.get(pos).getName());
                System.out.println("\n Book name ");
                String bookName = scanner.nextLine();
                HBOOK.get(pos).setName(bookName);
                System.out.println("\n Book Id ");

                String bookId = scanner.nextLine();
                HBOOK.get(pos).setId(bookId);

                System.out.println("\n Author");
                String author = scanner.nextLine();
                HBOOK.get(pos).setAuthor(author);
                System.out.println("\n Number of pages  ");
                //int page = scanner.nextInt();

                //HBOOK.get(pos).setNumber_of_pages(page);
                scanner.nextLine();
                System.out.println("\n Published date  ");
                String publishedDate = scanner.nextLine();
                HBOOK.get(pos).setPublishedDate(publishedDate);
                System.out.println("\n publisher  ");

                String publisher = scanner.nextLine();
                HBOOK.get(pos).setPublisher(publisher);

                System.out.println("\n Number of copies  ");
                int no_of_copies = scanner.nextInt();
                //>>>>   HBOOK.get(i).setNo_of_copies(no_of_copies)

                scanner.nextLine();

            }

        } else if (num == 2) {
            System.out.println("Enter the name of the book\n");
            String key = scanner.nextLine();
            for (int i = 0; i < DBOOK.size(); i++) {
                String nam = DBOOK.get(i).getName();
                if ((nam).equals(key))
                    loop = 1;
                pos = i;
            }
            if (loop == 0) {
                System.out.println("\n Sorry BOOK not found in library\n");
            } else {


                System.out.println("\nEnter the requested information" + DBOOK.get(pos).getName());
                System.out.println("\n Book name ");
                String bookName = scanner.nextLine();
                DBOOK.get(pos).setName(bookName);
                System.out.println("\n Book Id ");

                String bookId = scanner.nextLine();
                DBOOK.get(pos).setId(bookId);

                System.out.println("\n Author");
                String author = scanner.nextLine();
                DBOOK.get(pos).setAuthor(author);
                System.out.println("\n Number of pages  ");
                //String page = scanner.nextInt();

                // DBOOK.get(pos).setNumber_of_pages(page);
                scanner.nextLine();
                System.out.println("\n Published date  ");
                String publishedDate = scanner.nextLine();
                DBOOK.get(pos).setPublishedDate(publishedDate);
                System.out.println("\n publisher  ");

                String publisher = scanner.nextLine();
                DBOOK.get(pos).setPublisher(publisher);

                System.out.println("\n Size(in Kb) ");
                float size = scanner.nextFloat();


                scanner.nextLine();


            }
        }
    }

    public static void exportBook() {

        System.out.println("E_X_P_O_R_T_I_N_G____Z_O_N_E\n");
        do {
            System.out.println("Choose exporting option \n1.All info(both borrowers' and books')\n2.Only book\n3.Only borrowers'");
            num = scanner.nextInt();
            Gson jsonWrite;
            switch (num) {
                case 1:
                    System.out.println("E X P O R T _ B O O K _ A N D _ B O R R O W E R");
//Gson gson=new Gson();
//String json=gson.toJson(libraryHash);
//try{
//    FileWriter writer=new FileWriter("D:Library.txt");
//writer.write(json);
//writer.close();
//
//}catch(IOException e)
//{
//    e.printStackTrace();
//}System.out.println(json);


                    GsonBuilder gsonBuild = new GsonBuilder();//to set configuration other than default
                    Gson gson = gsonBuild.create();

                    String JSONObject = gson.toJson(libraryHash);//arraylist Borrow converted to jsonobj
                    System.out.println("Converted json obj ->>>" + JSONObject);

                    Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                    String pj = prettyGson.toJson(libraryHash);
                    System.out.println("Pretty JSON obj ->>>" + pj);

//        JsonParser jp=new JsonParser();
//        JsonElement je=jp.parse(JSONObject);

                    //String prettyJson=prettyGson.toJson(HBOOK);

                    try {
                        FileWriter writer = new FileWriter("D:Library.pdf");
                        writer.write(pj);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(pj);


                    break;

                case 2:
                    System.out.println("E X P O R T_ _B O O K\n");

                    jsonWrite = new Gson();
                    String json = jsonWrite.toJson(HBOOK);
                    try {
                        FileWriter writer = new FileWriter("D:Book.json");
                        writer.write(json);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(json);
                    break;

                case 3:
                    /*GsonBuilder */
                    gsonBuild = new GsonBuilder();//to set configuration other than default
                    gson = gsonBuild.create();

                    /*String */
                    JSONObject = gson.toJson(BORROW);//arraylist Borrow converted to jsonobj
                    System.out.println("Converted json obj ->>>" + JSONObject);

                    /* Gson */
                    prettyGson = new GsonBuilder().setPrettyPrinting().create();
                    /* String */
                    pj = prettyGson.toJson(BORROW);
                    System.out.println("Pretty JSON obj ->>>");

//        JsonParser jp=new JsonParser();
//        JsonElement je=jp.parse(JSONObject);

                    //String prettyJson=prettyGson.toJson(HBOOK);

                    try {
                        FileWriter writer = new FileWriter("D:Borrow.json");
                        writer.write(pj);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(pj);
//        System.out.println(prettyJson);
//
//        Document document=new Document();
//        PdfWriter.getInstance(document,new FileOutputStream("Borrow.pdf"));
//document.add(prettyGson);


                    break;

                default:
                    System.out.println("Invaid choice ");
                    loop = 1;

                    break;
            }
        } while (loop == 1);

    }

    public static Boolean searchBorrower() {
        Boolean bool = false;
        scanner.nextLine();
        System.out.println("B O R R O W E R   S E R A R C H I N G   Z O N  E \n");
        if (BORROW.size() == 0)
            System.out.println("No borroers added yet ");
        else {
            System.out.println("please enter id  number \n");
            String key = scanner.nextLine();
            for (int i = 0; i < BORROW.size(); i++) {
                String cmp = BORROW.get(i).getBorrower_id();
                System.out.println("Searching id " + cmp);
                if ((cmp).equals(key)) {
                    System.out.println(" Borrower with id number " + cmp + " is found at position " + i + 1);
                    bool = true;
                }

            }
            if (bool = false) System.out.println("Sorry :( Borrower with id number " + key + " is not found");
        }
        return bool;
    }


    public static void editBorrower() {
        System.out.println("\nB O R R O W E R  I N F O.  E D I T I N G   Z O N E ");
        System.out.println("\n^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`^`\n");
        scanner.nextLine();
        if (BORROW.size() == 0)
            System.out.println("No borrowers added yet  /!\\ \n\n");
        else {
            System.out.println("Enter borrowers's id\n");
            String key = scanner.nextLine();
            for (int i = 0; i < BORROW.size(); i++) {
                String com = BORROW.get(i).getBorrower_id();

                if ((com).equals(key)) {
                    System.out.println("Borrower " + com + " is found at position " + i + 1);
                    int pos = i;
                }
                System.out.println("Re-enter the edited info  ");


                System.out.println("\nBorrowing id");
                String id = scanner.nextLine();
                BORROW.get(i).setId(id);

                System.out.println("\nBook id");
                String bookId = scanner.nextLine();
                BORROW.get(i).setBook_id(bookId);
                System.out.println("\nBorrower id");
                String borrowerId = scanner.nextLine();
                BORROW.get(i).setBorrower_id(borrowerId);

                System.out.println("\nBorrowed date ");
                String borrowedDate = scanner.nextLine();
                BORROW.get(i).setborrowed_date(borrowedDate);

                System.out.println("\nLibrarian id");
                String librarianId = scanner.nextLine();
                BORROW.get(i).setlibrarian_id(librarianId);

                System.out.println("\nStatus");
                String state = scanner.nextLine();
                BORROW.get(i).setstatus(state);

            }
            System.out.println("Succesfully edited borrowers' info.");
        }


    }

    public static void removeBorrower() {
        scanner.nextLine();
        System.out.println("Enter borrowers id");
        String key = scanner.nextLine();
        if (BORROW.size() == 0)
            System.out.println("No borrowers added yet ");
        for (int i = 0; i < BORROW.size(); i++) {
            String cmp = BORROW.get(i).getBorrower_id();
            if ((cmp).equals(key)) {
                System.out.println("Borrower with id number " + cmp + " is succesfully removed \n");
                BORROW.remove(i);
            }
        }

    }


    private static void librarianPage() {
        System.out.println("Librarian login\n=====\n");
//    scanner.nextLine();

        int x;
        //Console console= System.console();
        System.out.println("\n\tEnter username");
        username = checkusername(scanner.next());
        System.out.println("\n\tEnter password");
        password = checkpassword(String.valueOf(console.readPassword()));
//            password = checkpassword(scanner.next().toCharArray());

        System.out.println("\nW E L C O M E >>> Librarian " + username);
//operations for librarian
        loop = 0;
        do {
            System.out.println("Where do you want to go ?");
            System.out.println("1.adding Book\n");
            System.out.println("2. Books viewing zone");
            System.out.println("3. Book Borrowing zone\n");
            System.out.println("4.Borrower Searching zone \n");
            System.out.println("5.Borrowers viewing zone");
            System.out.println("6.Book searching zone\n");
            System.out.println("7.Book removing zone\n");
            System.out.println("8.Book information editing zone");
//        System.out.println("9.Borrowers info.");
            System.out.println("9.editing zone \n");
            System.out.println("10.Borrowers removing zone \n");
            System.out.println("11. E_X_I_T");
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    addBook(HBOOK, DBOOK);
                    break;

                case 2:
                    viewBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    searchBorrower();
                    break;
                case 5:
                    viewBorrowers();
                    break;
                case 6:
                    searchBook(key);
                    break;
                case 7:
                    removeBook();
                    break;
                case 8:
                    editBook();
                    break;
                case 9:
                    editBorrower();
                    break;
                case 10:
                    removeBorrower();
                    break;
                case 11:
                    System.exit(0);
//                System.out.println("Do you want to export the changes you made ? If yes press 1 \n ");
//                num = scanner.nextInt();
//                if (num == 1)
//                {
//                    System.out.println("Arraylist HBOOK "+HBOOK);
//                    exportBook();
//                }
//                else
//                {
//
//
//                System.out.println("< S Y S T E M  _  T E R M I N A T E D  >");
//
//                System.exit(0);}
                    break;
                default:
                    System.out.println("Incorrct choice, Please choose again");
                    loop = 1;
                    break;
            }
        }
        while (loop == 1);

    }

    private static void StudentPage() {

        System.out.println("Student login\n=====\n");
        scanner.nextLine();

        int x;

        System.out.println("\n\tEnter username?");

        username = checkusername(scanner.next());

        System.out.println("\n\tEnter username?");
        password = checkpassword(String.valueOf(console.readPassword()));


        System.out.println("\nW E L C O M E " + username);

        //operations for librarian
        scanner.nextLine();
        do {
            System.out.println("\nWhere do you want to go ? \n1. Available books viewing zone\n2.Book searching zone\n ");
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    viewBooks();
                    break;

                case 2:
                    searchBook(key);
                    break;

                default:
                    System.out.println("Incorrect choice, Please choose again");
                    loop = 1;
                    break;
            }

        }
        while (loop == 1);


        //operations of student
    }

    private static void LecturerPage() {
        scanner.nextLine();
        System.out.println("Lecturer login\n=====\n");
        int x;

        System.out.println("\n\tEnter username?");

        username = checkusername(scanner.next());

        System.out.println("\n\tEnter username?");
        password = checkpassword(String.valueOf(console.readPassword()));

        //operations for librarian
        do {
            System.out.println("\nWhere do you want to go ? ");
            System.out.println("\n1. Available books viewing zone\\n");
            System.out.println("2.Book searching zone\\n");
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    viewBooks();
                    break;

                case 2:
                    searchBook(key);
                    break;

                default:
                    System.out.println("Incorrect choice, Please choose again");
                    loop = 1;
                    break;
            }
        }
        while (loop == 1);


    }


    public static String checkusername(String username) {
        boolean status = false;
        do {

            String regxname = "^[a-z10-9]{11}$";
            Pattern namepat = Pattern.compile(regxname, Pattern.CASE_INSENSITIVE);
            Matcher matcher = namepat.matcher(username);

            if (matcher.matches()) {
                status = true;

            } else {
                status = false;
                System.out.println("invalid username please re-enter valid NAME?");
                username = scanner.next();
                //reader.nextLine();


            }
        }
        while (!status);

        return username;

    }


    public static String checkpassword(String password) {

        loop = 0;

        if (console == null) {
            do {

                if (password.length() <= 6) {
                    System.out.println("Length of character must atleast 6");
                    loop = 1;
                } else loop = 0;
            }
            while (loop == 1);
        } else {
            do {

                if (password.length() < 6) {
                    System.out.println("Length of character must atleast 6");
                    loop = 1;
                } else loop = 0;
            }

            while (loop == 1);
        }
        return password;
    }
}
