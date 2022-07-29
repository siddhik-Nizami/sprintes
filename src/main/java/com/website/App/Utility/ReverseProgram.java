/**
 * 
 */
package com.website.App.Utility;

import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

/**
 * @author 10698333
 *
 */
public class ReverseProgram {
public static void main(String[] args) throws Exception {
String sdk1	=new String("تعطي يونيكود رقما فريدا لكل حرف".getBytes(), "UTF-8");
String text=
new String("تعطي يونيكود رقما فريدا لكل حرف".getBytes(), "UTF-8");

// Defining the file name of the file
Path fileName = Path.of("D:\\Assment/demo.txt");

// Writing into the file
Files.writeString(fileName, text);

// Reading the content of the file
String file_content = Files.readString(fileName);

// Printing the content inside the file
System.out.println(file_content);
}


/*String sdk = "sdkkkhan";
	StringBuilder input1 = new StringBuilder();
    input1.append(sdk);
    input1.reverse();
    String title2 = input1.toString();
    System.out.println("reverse>>>>>>>>>>"+title2);
    
}*/
}
