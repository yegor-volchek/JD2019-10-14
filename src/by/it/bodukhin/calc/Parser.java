package by.it.bodukhin.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var evaluate(String expression) {
        String[] part = expression.split(Patterns.OPERATION, 2);
        Var right = Var.createVar(part[1]); //на выходе знаю какой тип Var в двух частях
        if(expression.contains("=")) {
           return Var.saveVar(part[0], right);
        }

        Var left = Var.createVar(part[0]);

        if(left!=null && right!=null){
            Matcher matcher = Pattern
                    .compile(Patterns.OPERATION)
                    .matcher(expression);
            if(matcher.find()){
                String operation = matcher.group();
                switch (operation){
                    case "+":
                        return left.add(right);
                    case "-":
                        return left.sub(right);
                    case "*":
                        return left.mul(right);
                    case "/":
                        return left.div(right);
                    default:
                }
            }
        }
        return null;
    }
}
