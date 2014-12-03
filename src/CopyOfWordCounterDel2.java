import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class WordCounterDel2 {
    
	TreeMap<String, HashSet<Integer>> orden = new TreeMap();
	
	
	
    public void processWord(String word, int lineNumber){
    	if (orden.get(word) != null) {
    		orden.get(word).add((lineNumber/60)); //annar så skulle man kunna räkan ut sidan typ genom lineNumber % 60 eller något likande
		}else {
			 orden.put(word, new HashSet<Integer>() ); //.add((lineNumber/60) )); //annar så skulle man kunna räkan ut sidan typ genom lineNumber % 60 eller något likande
			 orden.get(word).add((lineNumber/60));
		}
    }

    public void processFile(String fileName) {
	try {
	    LineNumberReader lnr = new LineNumberReader(new FileReader(fileName));
	    while (lnr.ready()) {
		String line = lnr.readLine();
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter("[^a-zA-ZÅÄÖåäö]+");
		while (lineScanner.hasNext())
		    processWord(lineScanner.next().toLowerCase(), lnr.getLineNumber());
	    }
	} catch (FileNotFoundException fnfe) {
            System.err.println("Filen finns inte!");
	} catch (IOException ioe) {
            System.err.println("Kan inte öppna filen!");
	}
    }
    
    public void print() {
		for(Map.Entry<String, HashSet<Integer>> listan: orden.entrySet()){
			System.out.println("\"" + listan.getKey() + "\"\t\t\t\t är på sidan/orna: " + listan.getValue().toString());
		}
	}

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java WordCounter filename");
            System.exit(1);
        }
        
        WordCounterDel2 wc = new WordCounterDel2();       
        wc.processFile(args[0]);
        wc.print();
    }
}
