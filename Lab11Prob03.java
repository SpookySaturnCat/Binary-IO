import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * File: Lab11Prob03.java 
 * Class: CSCI 1302 
 * Author: Taylor O'Neal, Seraphina Morrison 
 * Created on: April 19th, 2024 Last Modified: April 19th,
 * 2024 Description:
 */

public class Lab11Prob03 {
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();
		
		// get persons for people
		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));	
			) {
			while (true) {
				people.add(new Person(input.readInt(), input.readUTF(), input.readUTF(), input.readInt(), input.readDouble()));	
			}
		} catch (EOFException e) {
			System.out.println("End of file!");
		} catch (IOException e) {
			System.out.println("IO error!");
		}
		
		// sort people
		Collections.sort(people);
		
		// write toStrings
		try (PrintWriter output = new PrintWriter("people-salary-sorted.dat");
			) {
			for (int i = 0; i < people.size(); i++) {
				output.printf(people.get(i).toString());
//				System.out.println(people.get(i).toString());
			}
		} catch (IOException e) {
			System.out.println("IO error");
		}
		
		// write objects, print to confirm
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("people-salary-sorted-objects.dat"));
			 ObjectInputStream input = new ObjectInputStream(new FileInputStream("people-salary-sorted-objects.dat"));	
			) {
			for (int i = 0; i < people.size(); i++) {
				output.writeObject(people.get(i));
				System.out.println(input.readObject());
			}
		} catch (IOException e) {
			System.out.println("IO error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}