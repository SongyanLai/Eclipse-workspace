package ProtocolBufferTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import ProtocolBufferTest.CountryProto.Country;

public class Main {
    public static void main(String[] args) {
        writeData();
        readData();
    }

    private static void writeData() {
        CountryProto.Country.Builder countryBuilder = CountryProto.Country.newBuilder();
        countryBuilder.setName("United States of America")
                     .setCapital("Washington, D.C.")
                     .setHdi(CountryProto.Country.HDI.VERY_HIGH)
                     .setPopulation(309349689)
                     .addCity("Houston")
                     .addCity("Los Angeles")
                     .addCity("Tucson");

        Country usa = countryBuilder.build();

        try (FileOutputStream output = new FileOutputStream("C:\\Temp\\usa.data")) {
            usa.writeTo(output);
            System.out.println("Data written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readData() {
        try (FileInputStream input = new FileInputStream("C:\\Temp\\usa.data")) {
            Country usa = CountryProto.Country.parseFrom(input);
            
            System.out.println("\n--- Decoded Country Data ---");
            System.out.println("Name: " + usa.getName());
            System.out.println("Capital: " + usa.getCapital());
            System.out.println("Population: " + usa.getPopulation());
            System.out.println("HDI: " + usa.getHdi().name());
            System.out.println("Cities:");
            usa.getCityList().forEach(city -> System.out.println("> " + city));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}