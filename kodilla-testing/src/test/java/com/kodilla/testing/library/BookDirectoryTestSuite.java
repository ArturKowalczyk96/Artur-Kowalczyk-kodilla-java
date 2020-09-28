package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
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
/*
    @Nested
    @DisplayName("Test listBooksInHandsOf")
    class TestListBooksInHandsOf{

        @Test
        void testListBooksInHandsOfWhenNoBooks(){
            //given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<Book>();
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser).thenReturn(resultListOf0Books);

            //when
            List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(libraryUser);

            //then
            assertEquals(0, theListOfBooks0.size());
        }

        @Test
        void testListBooksInHandsOfWhen1Book(){
            //given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf1Books = generateListOfNBooks(1);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser).thenReturn(resultListOf1Books);

            //when
            List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUser);

            //then
            assertEquals(1, theListOfBooks1.size());

        }

        @Test
        void testListBooksInHandsOfWhen5Books(){
            //given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf5Books = generateListOfNBooks(1);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser).thenReturn(resultListOf5Books);

            //when
            List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUser);

            //then
            assertEquals(5, theListOfBooks5.size());
        }
    }*/
}
