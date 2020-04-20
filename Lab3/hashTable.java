package Lab3;

public class hashTable {

    char[] letters = new char[100];
    String[] binaryLetters = new String[100];

    public void setLetterInArray(char c){

        letters[(int)c] = c;

    }

    public void setBinaryInArray(char c, String s ){

        binaryLetters[(int)c] = s;

    }

    public String getbinary(char c){
        String number;
        number = binaryLetters[(int)c];
        return number;
    }

    public void printArray(){
        for(int index = 0; index < letters.length; index++){

            System.out.println(letters[index] + ": " + binaryLetters[index]);

        }
    }

}