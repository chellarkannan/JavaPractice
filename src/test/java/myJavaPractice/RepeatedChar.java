package myJavaPractice;

public class RepeatedChar {

    public static void main(String[] args){


    // Find number of times a character is repeated in a string
        //str.charAt(1);
        String str = "abracadabra";
        int count = 0;
        int acount = 0;
        int bcount = 0;
        int ccount = 0;
        int dcount = 0;
        int rcount = 0;

        int length = str.length();

        for(int i =0; i<length; i++){
            if(str.charAt(i) == 'a'){
                ++acount;
            }
            else if(str.charAt(i) == 'b'){
                ++bcount;
            }
            else if(str.charAt(i) == 'c'){
                ++ccount;
            }
            else if(str.charAt(i) == 'd'){
                ++dcount;
            }
            else if(str.charAt(i) == 'r'){
                ++rcount;
            }

        }

        System.out.println("Char a repeated:" +acount);
        System.out.println("Char b repeated:" +bcount);
        System.out.println("Char c repeated:" +ccount);
        System.out.println("Char d repeated:" +dcount);
        System.out.println("Char r repeated:" +rcount);

       /* for(char x : str.toCharArray()){
            if(x == 'a'){
                count++;
            }
        }
        */

    }


    
}
