import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
 
public class ListOfNumbers {
	
    private ArrayList<RDFTriple<Integer, Integer, Integer>> rdfTripleList;
    private String fileName;
 
    public ListOfNumbers () {
        // create an ArrayList of Pairs of Integers
        this.rdfTripleList = new ArrayList<>();
    }
    
    public ArrayList<RDFTriple<Integer, Integer, Integer>> getRdfTripleList() {
    	return this.rdfTripleList;
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		// fill the existing list with RDFTriple objects
    		// of three numbers.
            rdfTripleList.add(new RDFTriple<Integer, Integer, Integer>(number1, number2, number3));
        }
    }
    

    public ListOfNumbers (String fileName) {
    	this();
    	this.fileName = fileName;
    }
    
    public void readList() {
        rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
        try{
            File myObj = new File("./numberfile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);

                String[] intList = line.split(" ");
                RDFTriple<Integer, Integer, Integer> newItem;
                int num1 = 0, num2 = 0, num3 =0;

                for (int i = 0; i < intList.length; i++) {
                    switch (i) {
                        case 0:
                            num1 = Integer.parseInt(intList[i]);
                        case 1:
                            num2 = Integer.parseInt(intList[i]);
                        case 2:
                            num3 = Integer.parseInt(intList[i]);
                        default:
                            break;
                    }
                }
                newItem = new RDFTriple<Integer, Integer, Integer>(num1, num2, num3);
                rdfTripleList.add(newItem);
                System.out.println("Added new triple:" + newItem.toString());
            }
            System.out.println("------ Added " + rdfTripleList.size() + " triples to List ------");
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter(this.fileName));
            for (int i = 0; i < rdfTripleList.size(); i++)
                out.println(rdfTripleList.get(i).getSubj() + " " + rdfTripleList.get(i).getPred() + " " + rdfTripleList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("outFile.txt");
//    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
    	listOfNumbers.writeList();
    }

}
