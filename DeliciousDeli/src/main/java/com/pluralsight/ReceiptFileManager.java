package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    private String currentDateTime;
    private Order order;

    public ReceiptFileManager(Order order){
        this.currentDateTime=getDateTime();
        this.order=order;
    }

    private String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(formatter);
    }

    public void saveReceipt() {

    }
}
