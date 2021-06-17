package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //given
        LocalDate pub = LocalDate.now();
        //creating the library
        Library library = new Library("New Books");
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("The Book " + n, "The author " + n, pub)));

        //making a shallow copy of object library
        Library cloneLibrary = null;
        try {
            cloneLibrary = library.shallowCopy();
            cloneLibrary.setName("New Books 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object library
        Library deepCloneLibrary = null;
        try {
            deepCloneLibrary = library.deepCopy();
            deepCloneLibrary.setName("New Books 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        for (Book theBook: library.getBooks()) {
            System.out.println(theBook.hashCode());
        }

        boolean remove = library.getBooks().remove(new Book("The Book 3", "nn", pub));

        //Then
        System.out.println(remove);
        System.out.println(library);
        System.out.println(cloneLibrary);
        System.out.println(deepCloneLibrary);
        assertEquals(4, library.getBooks().size());
        assertEquals(4, cloneLibrary.getBooks().size());
        assertEquals(5, deepCloneLibrary.getBooks().size());
        assertEquals(cloneLibrary.getBooks(), library.getBooks());
        assertNotEquals(deepCloneLibrary.getBooks(),library.getBooks());
    }
}

