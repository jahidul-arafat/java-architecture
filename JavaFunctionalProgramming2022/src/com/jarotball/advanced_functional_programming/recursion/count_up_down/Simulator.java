package com.jarotball.advanced_functional_programming.recursion.count_up_down;

public class Simulator {
    public static void main(String[] args) {
        //countDown(10);
        countUp(0);

    }

    // Starting with 10, recursively down to 0 until <0
    // countDown(10) -> countDown(9) -> countDown(8) -> countDown(7) -> countDown(6) ->
    // -> countDown(5) -> countDown(4) -> countDown(3) -> countDown(2) -> countDown(1) -> countDown(0) -> countDown(-1): BREAK x<0
    public static void countDown(Integer x){
        if (x<0){
            System.out.println("done!");
            return;
        }
        System.out.println(x);
        countDown(x-1);
    }

    // Starting with 0, recursively down to 10 until >10
    // countUp(0) -> countUp(1) -> countUp(2) -> countUp(3) -> countUp(4) -> countUp(5) ->
    // -> countUp(6) -> countUp(7) -> countUp(8) -> countUp(9) -> countUp(10) -> countUp(11): BREAK, x>10
    public static void countUp(Integer x){
        if (x>10){
            System.out.println("done!");
            return;
        }
        System.out.println(x);
        countUp(x+1);
    }


}
