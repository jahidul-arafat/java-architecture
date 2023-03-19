package org.jarotball.functional_programming.basics.project_1_greetings;

public class MathOps {
    public static double multiplication(double num, double factor){
        return num*factor;
    }

    /**
     *
     * @param num       cant be ZERO; if ZERO--> convert to 1
     * @param factor    cant be ZERO; if ZERO--> convert to 1
     * @return  num/factor
     */
    public static double division(double num, double factor){
        factor=(factor==0)?1:factor;
        num=(num==0)?1:num;
        return num/factor;
    }

}
