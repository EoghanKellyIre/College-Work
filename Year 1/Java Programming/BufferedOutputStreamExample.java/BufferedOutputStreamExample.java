// BufferedOutputputStream: write bytes

// We are writing the textual information in the
// BufferedOutputStream object which is connected
// to the FileOutputStream object

import java.io.*;
 
public class BufferedOutputStreamExample
{    
    public static void main(String args[]) throws Exception
    {    
        FileOutputStream fout = new FileOutputStream("out.txt");    
        BufferedOutputStream bout = new BufferedOutputStream(fout);
   
        String s = "Welcome to Java";    
        byte b[] = s.getBytes();
  
        bout.write(b);    
        bout.flush();    
        bout.close();    
        fout.close();
    
        System.out.println("success");    
    }    
} 