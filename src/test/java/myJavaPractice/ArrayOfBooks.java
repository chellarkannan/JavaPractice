package myJavaPractice;


    class BooksCollection {
    
            private String title;
            private String author;
            private int pages;
            private int noOfCopies;
            private int publishedYear;

            public BooksCollection(){

            }
                
    
            public BooksCollection(String title, String author, int pages, int noOfCopies, int publishedYear){
    
                this.title = title;
                this.author = author;
                this.pages = pages;
                this.noOfCopies = noOfCopies;
                this.publishedYear = publishedYear;
    
            }
            
            void display(){

                System.out.println("Book Details: " );
                System.out.println("Book Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("No of Pages: " + pages);
                System.out.println("No of Copies: " + noOfCopies);
                System.out.println("Pyblished Date: " + publishedYear);   
            }
        
            // To find highest no of copies, this method accepting an 'Array of Objects' as input
            public void Highest(BooksCollection[] books){
                int highest = 1;
               
            
            // To find highest No of copies
                for(BooksCollection book : books){
                    if(highest < book.noOfCopies){
                        highest = book.noOfCopies;

                }

                }
                 System.out.println("Highest No of copies : " +highest);
            
            }
        
        // To find lowest no of copies, this method accepting an 'Array of Objects' as input
        public void Lowest(BooksCollection[] books){
            int lowest = books[0].noOfCopies;

            // To find lowest No of copies
            for(BooksCollection book : books){
                if(lowest > book.noOfCopies){
                    lowest = book.noOfCopies;

            }

            }
            System.out.println("Lowest No of copies : " +lowest);
        }     
        
        // Find the Author Name for the given Book
        public void FindAuthor(BooksCollection[] books, String bookName){

            for(BooksCollection book : books){
                if(book.title.equals(bookName)){
                    System.out.println(bookName + " Author Name is:" +book.author);
                }
            }

        }

        //Find the book which is published first.
        public void FirstPublished(BooksCollection[] books){
            int year = books[0].publishedYear;
            String bName = books[0].title;
        
        // To find first published Book and year
            for(BooksCollection book : books){
                if(year > book.publishedYear){
                    year = book.publishedYear;
                    bName = book.title;

            }

            }
             System.out.println("The Book: " +bName +" published on the year:"+year);
        
        }
    
    }

    
public class ArrayOfBooks{

    public static void main(String[] args){

            // Create an Array of objects for 'BooksCollection'
            BooksCollection[] BooksArray = new BooksCollection[5];
            BooksArray[0] = new BooksCollection("Book A", "A", 100, 50, 2003);
            BooksArray[1] = new BooksCollection("Book B", "B", 200, 20, 2004);
            BooksArray[2] = new BooksCollection("Book C", "C", 100, 30, 2001);
            BooksArray[3] = new BooksCollection("Book D", "D", 300, 10, 2003);
            BooksArray[4] = new BooksCollection("Book E", "E", 250, 40, 2002);

            //To Display
            for(int i=0; i<5; i++){
                
                    BooksArray[i].display();
                
            }
            
            //Calling overloaded constructor with parameter "Array of Objects"
            // BooksCollection BooksColl = new BooksCollection(BooksArray);
            BooksCollection books = new BooksCollection();
            books.Highest(BooksArray);
            books.Lowest(BooksArray);

            //Get the Author Name for the given book
            String bookName = "Book B";
            books.FindAuthor(BooksArray, bookName);

            // Find the book which is published first.
            books.FirstPublished(BooksArray);

    }
}


    


    
    
    