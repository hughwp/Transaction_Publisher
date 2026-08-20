package com.hughcode;

import java.time.LocalDateTime;

public class Transaction {
    public int transactionId;
    public int accountId;
    public int payeeId;
    public String payeeFname;
    public String payeeLname;
    public int merchantId;
    public String merchantName;
    public double amount;
    public LocalDateTime timestamp;
    public TransactionStatus status;

    public enum TransactionStatus {
        COMPLETED,
        FLAGGED,
        BLOCKED
    }

    public Transaction(int transactionId, int accountId, int payeeId, String payeeFname,
                       String payeeLname, int merchantId, String merchantName, double amount,
                       LocalDateTime timestamp, TransactionStatus status) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.payeeId = payeeId;
        this.payeeFname = payeeFname;
        this.payeeLname = payeeLname;
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.amount = amount;
        this.timestamp = timestamp;
        this.status = status;
    }
}