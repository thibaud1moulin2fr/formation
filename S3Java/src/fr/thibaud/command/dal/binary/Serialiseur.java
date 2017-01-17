package fr.thibaud.command.dal.binary;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Serialiseur {
	public static <obj extends Serializable> void serialiser (Object obj, OutputStream os) {
		ObjectOutputStream oos = null;
		if (obj != null) {
			try {
				oos = new ObjectOutputStream(os);
				oos.writeObject(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static <obj extends Serializable> Object deserialiser (InputStream is) {
		Object obj = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			obj = ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
