import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * File: Lab11ONealMorrison.java Class: CSCI 1302 Author: Taylor ONeal,
 * Seraphina Morrison Created on: April 19th, 2024 Last Modified: April 19th,
 * 2024 Description:
 */

public class Lab11Prob02 {
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		
		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
		) {
			while (true) {
				Person person = new Person(input.readInt(), input.readUTF(), input.readUTF(), input.readInt(), input.readDouble());
				people.add(person);
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		java.util.Collections.sort(people);
		
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/people-salary-sorted.dat"))) {
			for (int i = 0; i < people.size(); i++) {
				output.writeObject(people.get(i));
				System.out.println(people.get(i));
			
			}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
		