import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * File: Lab11ONealMorrison.java Class: CSCI 1302 Author: Taylor ONeal,
 * Seraphina Morrison Created on: April 19th, 2024 Last Modified: April 19th,
 * 2024 Description:
 */

public class Lab11Prob01 {
	public static void main(String[] args) {
		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
		) {
			while (true) {
				output.writeInt(input.readInt());
				output.writeUTF(input.readUTF());
				output.writeUTF(input.readUTF());
				output.writeInt(input.readInt());
				output.writeDouble(input.readDouble());
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people-copy.dat"));) {
			while (true) {
//				System.out.println(input.readInt() + " " + input.readUTF() + " " + input.readUTF() + " " + input.readInt() + " " + input.readDouble());
				System.out.printf("%d %s %s %d %.2f%n", input.readInt(), input.readUTF(), input.readUTF(), input.readInt(), input.readDouble());
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}