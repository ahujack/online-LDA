package vagueobjects.ir.lda.tokens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKTest {
	public static void main(String[] args) throws IOException {
		String rawpath = "D://data//raw_corpus";
		String path = "D://data//corpus/";
		File rawroot = new File(rawpath);
		File[] files = rawroot.listFiles();
		for(File file:files){
		String filename = file.getName();
		File wf = new File(path+filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(wf));
		String text = br.readLine();
		StringReader myreader = new StringReader(text);
		IKSegmenter myseg = new IKSegmenter(myreader,true);
		Lexeme mylex = myseg.next();
		String ws = "";
		while(mylex !=null){
			ws += mylex.getLexemeText()+ " ";
			mylex = myseg.next();
		}
		System.out.println(ws);
		bw.write(ws.trim());
		bw.flush();
		br.close();
		bw.close();
	 }
 }
	
}
