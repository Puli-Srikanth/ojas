package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DDT {
public static void main(String[] args) throws IOException {
	
	FileInputStream fis = new FileInputStream("./src/test/resources/browserchrome.properties");
	Properties sgs = new Properties();
	sgs.load(fis);
	System.out.println(sgs.getProperty("URL"));
}
}
