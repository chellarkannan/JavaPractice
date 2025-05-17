package practice.Basics;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
public class ArrayBasics {

    public void singleDimensionalArray() {
        // This method demonstrates the use of a single-dimensional array in Java.
        // It initializes an array with some values and prints them out.

        int[] numbers = {1, 2, 3, 4, 5};

        // Print the elements of the array using a for loop
        System.out.println("Array elements using for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println(); // New line for better readability

        // Print the elements of the array using a for-each loop
        System.out.println("Array elements using for-each loop:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    public void multiDimensionalArray() {
        // This method demonstrates the use of a multi-dimensional array in Java.
        // It initializes a 2D array and prints its elements.

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Print the elements of the 2D array using nested for loops
        System.out.println("2D Array elements:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Row:"+i+", Column:"+j+"-"+matrix[i][j] + " ");
            }
            System.out.println(); // New line for each row
        }
    }

    public void StringMultiDimensionalArray() {
        // This method demonstrates the use of a multi-dimensional array of strings in Java.
        // It initializes a 2D array of strings and prints its elements.

        String[][] stringMatrix = {
            {"Hello", "World"},
            {"Java", "Programming"},
            {"Multi", "Dimensional", "Array"}
        };

        // Print the elements of the 2D string array using nested for loops
        System.out.println("2D String Array elements:");
        for (int i = 0; i < stringMatrix.length; i++) {
            for (int j = 0; j < stringMatrix[i].length; j++) {
                System.out.print(stringMatrix[i][j] + " ");
            }
            System.out.println(); // New line for each row
        }
    }

    public void arrayOfObjects() {
        // This method demonstrates the use of an array of objects in Java.
        // It initializes an array of custom objects and prints their properties.

        // Define a class named 'Person' with a constructor and a 'toString' method
        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{name='" + name + "', age=" + age + "}";
            }
        }

        Person[] people = new Person[3];

        people[0] = new Person("Alice", 25);
        people[1] = new Person("Bob", 30);
        people[2] = new Person("Charlie", 35);

        // Print the properties of each object in the array
        System.out.println("Array of Objects:");
        for (Person person : people) {
            System.out.println(person); // This will call the toString method of the Person class
        }
    }

    public void arrayoofOBjectsTwoDimensional() {
        // This method demonstrates the use of a two-dimensional array of objects in Java.
        // It initializes a 2D array of custom objects and prints their properties.

        // Define a class named 'Book with a constructor and a 'toString' method
        class Book {
            private String title;
            private String author;
            private int pages;
            private int noofCopies;
            private String publishedDate;

            public Book(String title, String author) {
                this.title = title;
                this.author = author;
            }

            @Override
            public String toString() {
                return "Book{title='" + title + "', author='" + author + "'}";
            }
        }
// booksize` is the number of books in the library
        Book[][] library = new Book[2][2]; // 2 rows and 2 columns        
        int rows=2;
        int columns=2;
       

        library[0][0] = new Book("1984", "George Orwell");
        library[0][1] = new Book("To Kill a Mockingbird", "Harper Lee");
        library[1][0] = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        library[1][1] = new Book("Master and Margarita", "Mikhail Bulgakov");

        for(int i = 0; i < library.length; i++) {
            for (int j = 0; j < library[i].length; j++) {
                System.out.println("Row:" + i + ", Column:" + j + "-" + library[i][j]);
            }
        }
        System.out.println(); // New line for better readability
    }

    public static void main(String[] args) {
        // Declare and initialize an array of integers
       ArrayBasics arrayBasics = new ArrayBasics();
    //    arrayBasics.singleDimensionalArray();
    //    arrayBasics.multiDimensionalArray();
       arrayBasics.arrayoofOBjectsTwoDimensional();

       // Create multiple book objects and make a dynamic array as input for arrayofOBjectsTwoDimensional method

       // find the book which has highest number of copies.

       // find the book which has lowest number of copies.

       // find the book which is published first.

        BooksCollection[] books = new BooksCollection[5];
        books[0] = new BooksCollection("Book A", "Author A", 200, 5, "2020");
        books[1] = new BooksCollection("Book B", "Author B", 150, 2, "2018");
        books[2] = new BooksCollection("Book C", "Author C", 300, 10, "2021");
        books[3] = new BooksCollection("Book D", "Author D", 250, 1, "2019");
        books[4] = new BooksCollection("Book E", "Author E", 100, 8, "2022");

       Map<String, Integer> bookCopies = new HashMap<>();
        for (BooksCollection book : books) {
            bookCopies.put(book.title, book.noofCopies);
        }

        

    }

    static class BooksCollection {
        private String title;
        private String author;
        private int pages;
        private int noofCopies;
        private String publishedYear;

        public BooksCollection(String title, String author, int pages, int noofCopies, String publishedYear) {
            this.title = title;
            this.author = author;
            this.pages = pages;
            this.noofCopies = noofCopies;
            this.publishedYear = publishedYear;
        }

        @Override
        public String toString() {
            return "BooksCollection{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", pages=" + pages +
                    ", noofCopies=" + noofCopies +
                    ", publishedDate='" + publishedYear + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getPages() {
            return pages;
        }

        public int getNoofCopies() {
            return noofCopies;
        }

        public String getPublishedYear() {
            return publishedYear;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }
        public void setNoofCopies(int noofCopies) {
            this.noofCopies = noofCopies;
        }
        public void setPublishedYear(String publishedYear) {
            this.publishedYear = publishedYear;
        }
        
        public int compareTo(BooksCollection other) {
            return Integer.compare(this.noofCopies, other.noofCopies);
        }
    }
}
