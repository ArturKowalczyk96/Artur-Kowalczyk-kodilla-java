package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){
        Forum theForum = new Forum();
        Map<Integer, ForumUser> theResultMapOfForumUsers = theForum.getUsersList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getBirthDate().getYear() < 2000)
                .filter(forumUser -> forumUser.getPostCount() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));
        System.out.println("# elements: " + theResultMapOfForumUsers.size());
        theResultMapOfForumUsers.entrySet().stream()
                .map(entry -> "ID " + entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}

/*
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;

import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
    }
}
 */
/*
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){
        BookDirectory theBookDirectory = new BookDirectory();
        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
 */

/*
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                //.forEach(System.out::println);
                .collect(Collectors.toList());
        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);
    }
}
 */

/*
import com.kodilla.stream.person.People;

public class StreamMain {
    public static void main(String[] args){
        People.getList().stream().forEach(System.out::println);
        People.getList().stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        People.getList().stream().map(String::toUpperCase).forEach(s -> System.out.println(s));
        People.getList().stream().filter(s -> s.length() > 11).forEach(System.out::println);
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);
    }
}
 */



/*
import com.kodilla.stream.baeutifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;


public class StreamMain {
    public static void main(String[] args){
        System.out.println("Welcome to module 7 - Stream");
        //1
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        //2.0
        Processor processor = new Processor();
        //2.1
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);
        //2.2
        Executor codeToExecute = () -> System.out.println("This is an example text!");
        processor.execute(codeToExecute);
        //2.3
        processor.execute(() -> System.out.println("This is an example text!."));

        //3.0
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        //3.1
        System.out.println("\nCalculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        //3.2
        System.out.println("\nCalculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
        System.out.println();

        //4
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String strToBeaut = "Not so nice Text for Beautifier";

        poemBeautifier.beautify(strToBeaut, (toDecorate -> toDecorate.toUpperCase()));
        poemBeautifier.beautify(strToBeaut, (toDecorate -> toDecorate.concat(" ABC")));
        poemBeautifier.beautify(strToBeaut, (toDecorate -> toDecorate.toLowerCase()));
        poemBeautifier.beautify(strToBeaut, (toDecorate -> "ABC" + toDecorate + "ABC"));

        //5
        System.out.println("\nUsing Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
 */