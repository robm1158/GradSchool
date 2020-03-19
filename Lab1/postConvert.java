/* 
Author by Rob Mullins

postCOnvert will go through the logic of picking out the opperators and opperands.
If it is a +-* /$ it will look at the stack and pop it twice, and then write the command to file.
If it is an opperand it will get pushed to the stack right away.*/


public class postConvert{
    private fileTasks write = new fileTasks();
    private stackChar stackHold = new stackChar(6);
    public int count = 0;
    private char letter;

    public void convert(String fileName, char someChar){
        
        letter = someChar;

    /* Using an if statement instead of a switch statement mainly for ease of use and readability.
    Dont think it really provices anything or takes away from anything. Here we also check for the null char.*/

        if ((int)(letter) != 0){
            System.out.println(letter);
            //Logic for checking for addition opperation

            if(letter == '+'){
                
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName, "LD TEMP"+(int)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop)+"\n");
                }
                
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName, "LD TEMP"+(int)(secPop)+"\n"+"AD "+ (char)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"AD "+ (char)(firstPop)+"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName, "LD "+(char)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName, "LD "+(char)(secPop)+"\n"+"AD "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"AD "+ (char)(firstPop)+"\n");

                }

                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");
            }
            //Logic for checking for subtraction opperation

            else if(letter == '-'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName, "LD TEMP"+(int)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop) +"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop) +"\n" );
                }
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName,"LD TEMP"+(int)(secPop)+"\n"+"SB "+ (char)(firstPop)+"\n");

                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"SB "+ (char)(firstPop) +"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop)+"\n");

                    System.out.println("LD "+(char)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"SB "+ (char)(firstPop)+"\n");

                    System.out.println("LD "+(char)(secPop)+"\n"+"SB "+ (char)(firstPop)+"\n");
                }

                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");

            }
            //Logic for checking for multiplication opperation

            else if(letter == '*'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName,"LD TEMP"+(int)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop)+"\n");
                }
                
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName,"LD "+(int)(secPop)+"\n"+"ML "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(int)(secPop)+"\n"+"ML "+ (char)(firstPop)+"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"ML "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"ML "+ (char)(firstPop)+"\n");
                }

                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");
            }
            //Logic for checking for division opperation

            else if(letter == '/'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName,"LD TEMP"+(int)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop)+"\n");
                }
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName,"LD "+(int)(secPop)+"\n"+"DV "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(int)(secPop)+"\n"+"DV "+ (char)(firstPop)+"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"DV "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"DV "+ (char)(firstPop)+"\n");
                }
                
                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");
                
            }
            //Here I am implememnting my enhancment. I am including the $ which is a ^ in terms of math.

            else if(letter == '$'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName,"LD TEMP"+(int)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop)+"\n");
                }
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName,"LD "+(int)(secPop)+"\n"+"EX "+ (char)(firstPop)+"\n" );
                    System.out.println("LD "+(int)(secPop)+"\n"+"EX "+ (char)(firstPop) +"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"EX "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"EX "+ (char)(firstPop)+"\n");
                }

                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");
                
            }
            // If it is not an opperation then push to stack

            else if(Character.isLetter(letter)){
                stackHold.push((letter));
            }
            //If no letter or opperator is found we throw an exception

            else{
                write.writeFile(fileName, "Did not finish File Error: No a letter or operator");
                throw new RuntimeException("Not a letter or operator");
            }

        }
        else{
            throw new RuntimeException("Null char encountered");
        }
    }
}