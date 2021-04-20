package com.kodilla.spring.library;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import java.util.*;

//@Service
public class Library {

    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public Library(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library() {
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }

    /*
    //3
    private final List<String> books = new ArrayList<>();

    @Autowired
    private LibraryDbController libraryDbController;

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
     */

    // 2
    /*
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    @Autowired
    public void setLibraryDbController(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }

     */
    //1
    /*
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    @Autowired
    public Library(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library() {
        // do nothing
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }

     */
}

