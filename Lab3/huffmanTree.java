// Rob Mullins
// This file contains the code to build a huffman tree fome a stack containing
// an ordered freq table read in from a file.

package Lab3;

public class huffmanTree {

    // Intial vars to use through out the file.
    int MaxSize;
    String fileName;
    Lab3.hashTable ht = new hashTable();

    private Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(MaxSize);
    private Lab3.huffmanNode hn1 = new Lab3.huffmanNode();
    private Lab3.huffmanNode hn2= new Lab3.huffmanNode();
    private Lab3.huffmanNode hn = new Lab3.huffmanNode();

    
    // COnstructor reading in vars needed from other files.
    // Also set class vars to use.

    public huffmanTree(genericStack<Lab3.huffmanNode> gshn, int size,String file){
        gs = gshn;
        MaxSize = size;
        fileName = file;
    }

    // Main code to build the huffman tree from the stack passed in the constructor
    // Here also lies the tir breakers for pushing the huffman nodes in the
    // correct order given by complexit and alpha order.

    public Lab3.huffmanNode buildHuffmanTree(){
        Lab3.fileManipulation files = new Lab3.fileManipulation(fileName,gs);
        while(gs.size() > 0){
            Lab3.huffmanNode newhn = new Lab3.huffmanNode();

            hn1 = (Lab3.huffmanNode)gs.pop();
            hn2 = (Lab3.huffmanNode)gs.pop();
            newhn.data = hn1.data+hn2.data;
            String sortedString = stringSort(hn1.s, hn2.s);
            newhn.s = sortedString;
            boolean flip = false;
            if (hn1.data > hn2.data) {
                flip = true;
            } else if (hn1.data == hn2.data) {
                if (hn1.s.length() > hn2.s.length()) {
                    flip = true;
                } else if (hn1.s.length() == hn2.s.length()) {
                    if (hn1.s.charAt(0) > hn2.s.charAt(0)) {
                        flip = true;
                    }
                }
            }

            if (flip) {
                newhn.left = hn2;
                newhn.right = hn1;
            } else {
                newhn.left = hn1;
                newhn.right = hn2;
            }

            gs.push(newhn);
            files.setHuffmanStack(gs);
            gs = files.sortData();
    

        }
        hn = (Lab3.huffmanNode)gs.pop();


        String s ="";
        ht = files.binaryPrint(hn,s);
        return hn;


    }

    // Pre order traversal print. A recursive solution to print it out

    public void print(Lab3.huffmanNode hn){
        if(hn.left == null && hn.right == null && !hn.s.isEmpty()){
            System.out.println(hn.s + ": " + hn.data);

            return;
        }
        System.out.println(hn.s + ": " + hn.data);
        print(hn.left);
        print(hn.right);

    }

    // This function will sort the strings of the nodes in numeric order
    // This also impliments a bubble sort to do so. This returns the 
    // ordered string

    public String stringSort(String string1,String string2){
        String string = string1 + string2;
        char tempArray[] = string.toCharArray();
        int n = tempArray.length;

        for(int i = 0; i < n -1;i++){
            for(int j = 0; j < n - i -1;j++){
                if(tempArray[j] > tempArray[j+1]){
                    char temp = tempArray[j];
                    tempArray[j] = tempArray[j+1];
                    tempArray[j+1] = temp;
                }
            }
        }
        String sortedString = new String(tempArray);
        return sortedString;


    }

    // A simple getter function to retrieve the built in
    // huffman tree

    public Lab3.hashTable getHashTable(){
        return ht;
    }

}