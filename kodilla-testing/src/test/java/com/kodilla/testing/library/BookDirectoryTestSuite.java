package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    private static int testCounter = 0;
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test suite: begin");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Test suite: end");
    }

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Test listBookWithConditions")
    class TestListBookWithConditions {
        @Test
        void testListBooksWithConditionsReturnList() {
            //given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            //when
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            //then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBookWithConditionMoreThan20() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<Book>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
            // Then

            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());
        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf10Books = generateListOfNBooks(10);
            //UnnecessaryStubbingException
            //https://www.baeldung.com/mockito-unnecessary-stubbing-exception
            //according to error occurred following line is not necessary
            //when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("Test listBooksInHandsOf")
    class TestListBooksInHandsOf{

        @Test
        void testListBooksInHandsOf() {
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<Book>();
            List<Book> resultListOf1Book = generateListOfNBooks(1);
            List<Book> resultListOf5Books = generateListOfNBooks(5);
            LibraryUser userWith0Books = new LibraryUser("Adam", "Zero", "000");
            LibraryUser userWith1Book = new LibraryUser("Adam", "One", "111");
            LibraryUser userWith5Books = new LibraryUser("Adam", "Five", "555");
            when(libraryDatabaseMock.listBooksInHandsOf(userWith0Books)).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksInHandsOf(userWith1Book)).thenReturn(resultListOf1Book);
            when(libraryDatabaseMock.listBooksInHandsOf(userWith5Books)).thenReturn(resultListOf5Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(userWith0Books);
            List<Book> theListOfBook1 = bookLibrary.listBooksInHandsOf(userWith1Book);
            List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(userWith5Books);

            // Then
            assertEquals(0, theListOfBooks0.size());
            assertEquals(1, theListOfBook1.size());
            assertEquals(5, theListOfBooks5.size());
        }
    }
}
