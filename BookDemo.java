import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BookDemo {
    public static void main(String[] args){
        Book book_one = new Book("BestBokInTheWorld", "Artemij", "Korolev", 404);
        book_one.displayInfo();
    }
}

class Author{
    String firstName;
    String lastName;

    Author(String a, String b){
        firstName = a;
        lastName = b;
    }
    String getFirstName(){
        return this.firstName;
    }
    void setFirstName(String firstName){
        this.firstName = firstName;
    }
    String getLastName(){
        return this.lastName;
    }
    void setLastName(String lastName){
        this.lastName = lastName;
    }

}

class Book{
    String title;
    int Cost;
    Author author;

    Book(String title, String firstName, String lastName, int Cost){
        this.title = title;
        this.author = new Author(firstName, lastName);
        this.Cost = Cost;
    }

    String getTitle(){
        return this.title;
    }
    void setTitle(String title){
        this.title = title;
    }
    int getCost(){
        return this.Cost;
    }
    void setCost(int Cost){
        this.Cost = Cost;
    }

    public void displayInfo(){
        System.out.printf("title - %s\tCost - %d\nfirstName - %s\tlastName - %s\n", title, Cost, author.firstName, author.lastName);
    }


}