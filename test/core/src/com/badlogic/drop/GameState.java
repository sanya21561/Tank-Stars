package com.badlogic.drop;

import java.io.Serializable;

import java.io.*;
public class GameState implements Serializable {
    public static SaveHealth player1 = new SaveHealth(100);

    private float tankx;
    private float tanky;
    private SaveHealth player2 = new SaveHealth(100);

    public void save(float tankx, float tanky){
        this.tankx = tankx;
        this.tanky = tanky;
        try {
            FileOutputStream fos = new FileOutputStream("state.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject( new GameState() );
            oos.close();
            FileInputStream fis = new FileInputStream("state.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println( ois.readObject() );
            ois.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }
    public void load(float tankx, float tanky){
        this.tankx = tankx;
        this.tanky = tanky;
        try {
//            FileOutputStream fos = new FileOutputStream("state.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject( new GameState() );
//            oos.close();
//            FileInputStream fis = new FileInputStream("health.txt");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            System.out.println( ois.readObject() );
//            ois.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }
    public static void main (String[] args) {

    }
    public String toString() {
        return "GameState[ " + player1.toString() + ", "+ player2.toString()+ " ]";
    }
}
class SaveHealth implements Serializable {
    public static short getHealthLeft() {
        return healthLeft;
    }

    //    private short healthLeft1 = 100;
//    private short healthLeft2 = 100;
    private static short healthLeft;
    /*package*/ SaveHealth(int health) {
        healthLeft = (short) health;
    }
    private void writeObject(ObjectOutputStream s) throws IOException
    {
        System.out.println("Encrypting health left...");
        s.writeByte(- healthLeft);
    }
    private void readObject(ObjectInputStream s) throws IOException {
        System.out.println("Decrypting health left...");
        healthLeft = (short) - s.readByte();
    }
    public String toString() {
        return "Player[" + healthLeft + "]";
    }
}