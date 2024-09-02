package org.example;

import java.io.*;
import java.util.ArrayList;

public class DataBase implements IDB{
    private static final String fileName = "database.txt";//null
    private static final String fileKeyName= "key.txt";//null
    private static DataBase instance;//null

    private DataBase() {
        // Private constructor to prevent instantiation
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    private static void writeToFile( String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(text+"\n");
            System.out.println("Text has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void saveData(String data) {
        writeToFile(data);
        // Save data to the database
    }
    public ArrayList<String> loadData() {
        StringBuilder content = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return list;
    }
    public void deleteData(String data) {//11111
        // Delete data from the database
        ArrayList<String> list = loadData();
    }
    public void updateData(String what,String to) {
        // Update data in the database
    }

    public String loadKey() {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileKeyName))) {
            String line;
            while ((line = reader.readLine()) != null) {
               return line;
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return null;
    }
//CRUD
    // Other methods and fields for managing the database
}
