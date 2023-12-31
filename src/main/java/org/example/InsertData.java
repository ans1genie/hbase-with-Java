package org.example;

import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

public class InsertData{

   public static void main(String[] args) throws IOException {
      // get data from user
      Scanner scanner = new Scanner(System.in);
      int input=0;
      do {
         System.out.println(
                 "Hello in OrdersManagementApp,please choose an option:\n" +
                 "1- list data\n" +
                 "2- add data\n" +
                 "3- delete data\n" +
                 "4- exit"
         );
         input = scanner.nextInt();
         switch (input){
            case 1:
               break;
            case 2:
               insertData();
               break;
            case 3:
               break;
            default:
               if(input!=4) System.out.println("please choose a valid option!!");
               break;
         }
      } while(input!=4);
      System.out.println("See you soon!!");

   }

   private static void insertData() throws IOException {
      //row1,col1,,,,,

      // Instantiating Configuration class
      Configuration config = HBaseConfiguration.create();

      //
      Connection connection = ConnectionFactory.createConnection(config);
      System.out.println("connected");

      Table hTable = connection.getTable(TableName.valueOf("commande"));

      // Instantiating HTable class
      //HTable hTable = new HTable(config, "emp");

      // Instantiating Put class
      // accepts a row name.
      Put p = new Put(Bytes.toBytes("row3"));

      // adding values using add() method
      // accepts column family name, qualifier/row name ,value
      p.addColumn(
              Bytes.toBytes("clients"),
              Bytes.toBytes("First_Name"),
              Bytes.toBytes("Sabado")
      );

      p.addColumn(
              Bytes.toBytes("clients"),
              Bytes.toBytes("Second_Name"),
              Bytes.toBytes("GREAT")
      );


      p.addColumn(
              Bytes.toBytes("produits"),
              Bytes.toBytes("Fileire"),
              Bytes.toBytes("GLAASRI")
      );

      p.addColumn(
              Bytes.toBytes("produits"),
              Bytes.toBytes("Annee_Bac"),
              Bytes.toBytes("2014")
      );


      // Saving the put Instance to the HTable.
      hTable.put(p);
      System.out.println("data inserted");

      // closing HTable
      hTable.close();
      connection.close();
   }
}