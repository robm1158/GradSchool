package Lab4;
import java.io.*;

public class readData {
    String fileName;

    public readData(String file){

        fileName = file;
    }

    public void readInData() throws IOException{
        Boolean eof = false;
        DataInputStream input = new DataInputStream(new FileInputStream(fileName));

        while(!eof){
            try{
                int x = input.readInt();
                System.out.println(x);
            }
            catch(EOFException e){
                eof = true;
            }

        }

    }

}