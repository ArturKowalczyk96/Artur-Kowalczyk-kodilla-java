package com.kodilla.stream;

import com.kodilla.stream.baeutifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.lang.StringBuilder;

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
        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        //3.2
        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        //4
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String strToBeaut = "Not so nice Text for Beautifier";

        poemBeautifier.beautify(strToBeaut, (toDecorate -> toDecorate.toUpperCase()));
        poemBeautifier.beautify(strToBeaut, (toDecorate -> toDecorate.concat(" ABC")));
        poemBeautifier.beautify(strToBeaut, (toDecorate -> toDecorate.toLowerCase()));
        poemBeautifier.beautify(strToBeaut, (toDecorate -> "ABC" + toDecorate + "ABC"));
    }
}
