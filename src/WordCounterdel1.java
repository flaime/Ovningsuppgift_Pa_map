import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class WordCounterdel1 {
    Map<String, Integer> ord = new HashMap<String, Integer>();
    int totOrd = 0;
    public void processWord(String word, int lineNumber){
    	totOrd++;
    	if( ord.containsKey(word)){
    		int hurMångaGånger = ord.get(word).intValue() + 1;

    		ord.put(word,hurMångaGånger);
    	}else {
    		ord.put(word.toLowerCase(),1);
		}
    }

    public void processFile(String fileName) {
	try {
		System.out.println("texten läses in...");
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
	
	
	//skriv ut allt
	int antalOrd = 0;
	int högstaVärde= 0;
	for (Map.Entry<String, Integer> entry : ord.entrySet()) {
		antalOrd++;
		if(högstaVärde < entry.getValue())
			högstaVärde = entry.getValue();
	    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	}
	
	System.out.println("\n\nHögsta värdet är " + högstaVärde + " atanl ord är = " + antalOrd + " totOrdf = " + totOrd);
    }
    
    Scanner tangentbord = new Scanner(System.in);
    public void loop(){
    	while(true){
    		System.out.println("skriv ett ord");
    		String inmatat = tangentbord.nextLine();
    		
    		if(inmatat.equalsIgnoreCase("exit"))
    			break;
    		else if(ord.containsKey(inmatat.toLowerCase())){
    			System.out.println("ordet fins med " + ord.get(inmatat).toString() + " gånger.");
    		}
    	}
    }

    public static void main(String[] args) {    	
    	
    	String[] argsss = { "C:\\Users\\linus\\Documents\\GitHub\\Ovningsuppgift_Pa_map\\src\\ord.txt"};
        if (argsss.length < 1) {
            System.out.println("Usage: java WordCounter filename");
            System.exit(1);
        }
        
        WordCounterdel1 wc = new WordCounterdel1();       
        wc.processFile(argsss[0]);
        wc.loop();
    }
}
