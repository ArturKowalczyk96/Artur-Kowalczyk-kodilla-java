package com.kodilla.testing;

import com.kodilla.testing.calculaor.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        //Here will be next test->
        System.out.println("Test - pierwszy test jednostkowy");

        Calculator calculator = new Calculator(45, 15);

        int sum = calculator.addAToB();

        if (sum == calculator.getA() + calculator.getB()){
            System.out.println("Adding test OK");
        } else {
            System.out.println("Adding error!");
        }

        int subtract = calculator.subtractBFromA();

        if (subtract == calculator.getA() - calculator.getB()){
            System.out.println("Subtraction test OK");
        } else {
            System.out.println("Subtraction error!");
        }
    }
}
