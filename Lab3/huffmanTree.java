package Lab3;

public class huffmanTree {
    int MaxSize;
    String fileName;
    private Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(MaxSize);
    private Lab3.huffmanNode hn1 = new Lab3.huffmanNode();
    private Lab3.huffmanNode hn2= new Lab3.huffmanNode();
    private Lab3.huffmanNode hn = new Lab3.huffmanNode();
    


    public huffmanTree(genericStack<Lab3.huffmanNode> gshn, int size,String file){
        gs = gshn;
        MaxSize = size;
        fileName = file;
    }

    public void buildHuffmanTree(){
        Lab3.fileManipulation files = new Lab3.fileManipulation(fileName,gs);
        
        while(gs.size() > 1){
            Lab3.huffmanNode newhn = new Lab3.huffmanNode();

            hn1 = (Lab3.huffmanNode)gs.pop();
            hn2 = (Lab3.huffmanNode)gs.pop();
            newhn.data = hn1.data+hn2.data;
            String sortedString = stringSort(hn1.s, hn2.s);
            newhn.s = sortedString;
            newhn.left = hn1;
            newhn.right = hn2;
            gs.push(newhn);
            files.setHuffmanStack(gs);
            gs = files.sortData();
    

        }


        files.preorderPrint();


    }

    public void print(){
        while(gs.size() >= 0){
            hn = (Lab3.huffmanNode)gs.pop();
            System.out.println("Out of the generic: " + hn.s);
            System.out.println("Out of the generic: " + hn.data);
        }

    }

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

}