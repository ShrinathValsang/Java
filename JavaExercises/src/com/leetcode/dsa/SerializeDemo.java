package com.leetcode.dsa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Singleton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5925923922570921082L;
	public static Singleton INSTANCE = new Singleton();
	
	private Singleton() {}

	private int value;

	public void setValue(int i) {
		this.value = i;
	}

	public int getValue() {
		return value;
	}
}

public class SerializeDemo implements Serializable {

    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.setValue(1);

        // Serialize
        try {
            FileOutputStream fileOut = new FileOutputStream("D://out.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(singleton);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        singleton.setValue(2);

        // Deserialize
        Singleton singleton2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("D://out.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            singleton2 = (Singleton) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("singletons.SingletonEnum class not found");
            c.printStackTrace();
        }

        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

        System.out.println(singleton.getValue() + " " + singleton.hashCode());
        System.out.println(singleton2.getValue() + " " + singleton2.hashCode());
        
        Math.sqrt(0);

    }

}
