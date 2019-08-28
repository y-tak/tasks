package com.tsystems.javaschool.tasks.calculator;

import java.util.ArrayList;
import java.util.Arrays;


public class Calculator {
    /*
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */

    ///-----вычисления выражения типа 1+1+4*2-----------------------
    public String evaluateR(String statement) {
        String operators[] = statement.split("[0-9]+");
        String operands[] = statement.split("[*/+-]");

        int agregate = Integer.parseInt(operands[0]);
        String agregateString;

//------разбить по приоритетам вычисления------------------------------------------
        for (int i = 0; i < operands.length-1; i++) {

            if (operators[i+1].equals("*")) {
                agregate = Integer.parseInt(operands[i]) * Integer.parseInt(operands[i + 1]);
                ///---переопредление выражения 1+1+4*2=1+1+8+0
                operators[i+1] = "+";
                agregateString = "" + agregate;
                operands[i+1] = agregateString;
                operands[i] = "0";
            }
        }

            for (int i = 0; i < operands.length-1; i++)
            {
            if (operators[i+1].equals("/")) {
                agregate = Integer.parseInt(operands[i]) / Integer.parseInt(operands[i+1]);
                ///---переопредление выражения 1+1+4/2=1+1+2+0
                operators[i+1] = "+";
                agregateString = "" + agregate;
                operands[i+1] = agregateString;
                operands[i] = "0";

            }
        }

        //----вычисления + или -----------------------
        int agregate1 = Integer.parseInt(operands[0]);
        for (int i = 1; i < operands.length; i++) {
            if (operators[i].equals("+"))
                agregate1 += Integer.parseInt(operands[i]);
            else
                agregate1 -= Integer.parseInt(operands[i]);
        }

        return Integer.toString(agregate1);
    }

    ///-------разбора выражения по скобкам----------первого уровня---------------------
    public String evaluate(String statement)
    // TODO: Implement the logic here
    {
        String operators[] = statement.split("[0-9]+");
        String operands[] = statement.split("[()*/+-]");
        String res = "";
        boolean por=false;

        String res1 = operands[0];


        int kol = 0;
        int g=0;
        boolean sk = false;

   //     System.out.println("Arrays.toString(operands) = " + Arrays.toString(operands));
    //    System.out.println("Arrays.toString(operators) = " + Arrays.toString(operators));

        for (int i = 0; i < operands.length; i++) {

            ///-отрицательные-------------
            if (i == 0 && operands[i].equals("")&& operators[i].equals("-"))
            {
                res1 = "-";
                continue; }

            if (i > operators.length - 1) {
                res1 = res1 + operands[i];
                continue;
            }
            else

                {

                if (operators[i].equals("+(")) {
                    res1 = res1 + "+";
                    kol = i;
                    sk = true;


                } else if (operators[i].equals("-(")) {
                    sk = true;
                    kol = i;
                    res1 = res1 + "-";

                } else if (operators[i].equals("*(")) {
                    sk = true;
                    kol = i;
                    res1 = res1 + "*";

                } else if (operators[i].equals("/(")) {

                    sk = true;
                    kol = i;
                    res1 = res1 + "/";

                } else if (operators[i].equals("(")) {
                    sk = true;
                    kol = i;
                    res1 = res1+"";
                }
                else if (operators[i].equals(")") && sk==true) {

                     for (int j = kol; j < i; j++) {
                        res = res + operands[j] + operators[j];
                        System.out.println(" res = " +  res);
                    }
                    sk = true;
                    res1 = res1 + evaluateR(res);
                    kol = 0;
                } else if (operators[i].equals(")-")&& sk==true) {

                    for (int j = kol+1; j < i; j++) {
                        res = res + operands[j] + operators[j];
                    }
                    res = res + operands[i];
                    sk = false;
                    res1 = res1 + evaluateR(res) + "-";
                    kol = 0;

                } else if (operators[i].equals(")*")&& sk==true) {
                    for (int j = kol + 1; j < i; j++) {
                        res = res + operands[j] + operators[j];
                    }
                    res = res + operands[i];
                    sk = false;
                    res1 = res1 + evaluateR(res) + "*";
                    kol = 0;
                } else if (operators[i].equals(")/")&& sk==true) {


                    for (int j = kol; j < i; j++) {
                        res = res + operands[j] + operators[j];
                    }
                    res = res + operands[i];
                    sk = false;
                    res1 = res1 + evaluateR(res) + "/";
                    kol = 0;

                } else if (operators[i].equals(")+")&& sk==true) {

                    for (int j = kol; j < i; j++) {
                        res = res + operands[j] + operators[j];

                    }
                    res = res + operands[i];
                    sk = false;
                    res1 = res1 + evaluateR(res) + "+";
                    kol = 0;
                }
                //------------отработка ошибки------------------
                else if (operators[i].equals(")") && sk==false)
                {
                    System.out.println("Выражение = "+ statement+" ОТВЕТ = " +  null);
                    return "";
                }
                else if (operators[i].equals(")+") && sk==false)
                {
                    System.out.println("Выражение = "+ statement+" ОТВЕТ = " +  null);
                    return "";
                }
                else if (operators[i].equals(")-") && sk==false)
                {
                    System.out.println("Выражение = "+ statement+" ОТВЕТ = " +  null);
                    return "";
                }
                else if (operators[i].equals(")*") && sk==false)
                {
                    System.out.println("Выражение = "+ statement+" ОТВЕТ = " +  null);
                    return "";
                }
                else if (operators[i].equals(")/") && sk==false)
                {
                    System.out.println("Выражение = "+ statement+" ОТВЕТ = " +  null);
                    return "";
                }
             ///-----------------еси пустое число ---------
                else if (operands[i].equals(""))
                    {
                    res1 = res1 + operands[i + 1] + operators[i];
                    i++;
                    continue;
                }

                ///------------если пустая операция------------
                else if (operators[i].equals("")) {
                    res1 =res1+ "";
                    por=true; ///меняем порядок

                    continue;
                }
                else if (kol == 0 & sk == false) {

                    if (por == false)
                        res1 = res1 + operands[i] + operators[i];
                    else
                        res1 = res1 + operators[i] + operands[i];
                    continue;

                } else if (kol == 0 & sk == true) {
                    continue;
                }
                else {
                    continue;
                }
            }
        }
        //------конец цикла-----------------

           if (sk == false) { System.out.println("Выражение = "+ statement+"  ОТВЕТ  " + evaluateR(res1));
              return "";
            } else
                return evaluate(res1);
               }

    public static void main(String[] args) {


        Calculator calculator = new Calculator();
  //      calculator.evaluate("1+10+14/2+(6*7-4*1)-7");
       calculator.evaluate("(1+38)*4-5");
       calculator.evaluate("7*6/2+8");
       calculator.evaluate("-12)1//(");
    }




}
