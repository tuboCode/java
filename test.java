package com.cs.cn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {

	public static void main(String[] args) {
		
		try {
			
		File infile = new File("/D:test.txt");
		
		File outfile = new File("file2.txt");
		
		
			FileInputStream fis = new FileInputStream(infile);
			FileOutputStream fos = new FileOutputStream(outfile);
			
			int c;
			while((c=fis.read())!=-1){
				fos.write(c);
			}
			fis.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("FileStreamsTest"+e);
		}catch(IOException e){
			System.out.println("FileStreamTest" + e);
		}
	}
}
