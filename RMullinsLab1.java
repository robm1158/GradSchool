import java.io.*;

class stack{

    private char[] hold;
    private int top,x;

    public stack(int max){

        x = max;
        hold = new char[x];
        top = -1;
    }
    public void push(char value){
        hold[++top] = value;

    }
    public char pop(){
        return(hold[top--]);
    }

}

class postConvert{
    public int convert(String s){
        int len,set = 0,count = 0;
        len = s.length();
        stack stackHold = new stack(len);
        for(int index = 0; index < len; index++){
            char letter = s.charAt(index);

            if(letter == '+'){
                count++;
                int firstPop = stackHold.pop();
                int secPop = stackHold.pop();
                System.out.println("LD "+(char)(secPop)+"\n"+"AD "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
            }
            else if(letter == '-'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                System.out.println("LD "+(char)(secPop)+"\n"+"SB "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );

            }
            else if(letter == '*'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                System.out.println("LD "+(char)(secPop)+"\n"+"ML "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );

            }
            else if(letter == '/'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                System.out.println("LD "+(char)(secPop)+"\n"+"DV "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                
            }
            else if(letter == '$'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                System.out.println("LD "+(char)(secPop)+"\n"+"EX "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                
            }
            else{
                //System.out.println("pushing "+letter);sadad
                stackHold.push(letter);
            }
            
        }
        set = stackHold.pop();
        return set;
    }
}

class RMullinsLab1{

    public static void main(String[] args)throws IOException{
        String input;
        postConvert test = new postConvert();
        File file = new File("PostfixMachineLangInput.txt"); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        String st; 
        while ((st = br.readLine()) != null)
            
            System.out.println("Result: "+test.convert(st));
            System.out.println(st);
    }

}