package com.CS.sound_ccis;

public class KMP {

    public  int [] prefix_function(String Value) {
        int length_Value = Value.length();
        int Failure []=new int [length_Value];

        for (int i = 1; i < length_Value; i++) {
            int j = Failure[i-1];
            while (j > 0 && Value.charAt(i) != Value.charAt(j))
                j = Failure[j-1];
            if (Value.charAt(i) == Value.charAt(j))
                j++;
            Failure[i] = j;
        }
        return Failure;}


    public int KMP(String text, String Value){

        int length_text =text.length();
        int length_value =Value.length();

        int Failure[] =prefix_function(Value);
        int k =0;
        for(int i =0;i<length_text;i++){

            while (k > 0 && Value.charAt(k) != text.charAt(i))
                k=Failure[k-1];

            if(Value.charAt(k) == text.charAt(i))
                k++;

            if(k==length_value){
              //  System.out.println("Done");
                return 1;
            }

        }


         return  0;


    }



}
