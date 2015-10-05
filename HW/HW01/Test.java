import java.io.*;
import java.util.*;

public class Test{
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner(System.in);
		String filename = s.next();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		while(true){
			String line = br.readLine();
			if(line == null) break;
			String[] lines = line.split(" ");
			for(String str : lines){
				System.out.println(str);
			}
		}
		br.close();
	}
}