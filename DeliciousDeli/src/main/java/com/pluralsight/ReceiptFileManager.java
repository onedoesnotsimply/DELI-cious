package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    //private String currentDateTime;
    private Order order;

    public ReceiptFileManager(Order order){
        //this.currentDateTime=getDateTime();
        this.order=order;
    }

    private String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(formatter);
    }

    public void saveReceipt() {
        try {
            String filename = getDateTime()+".txt";
            String filepath = "Receipts";

            File file = new File(filepath, filename);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(order.toString());

            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
