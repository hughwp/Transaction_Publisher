package com.hughcode;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomClassFactory {
    private static final Random random = new Random();

    public static Transaction generateRandomTransaction() {
        int transactionId = random.nextInt(10000) + 1;
        int accountId = random.nextInt(1000) + 1;
        int payeeId = random.nextInt(1000) + 1;
        String payeeFname = NamesRepo.getRandomFirstName();
        String payeeLname = NamesRepo.getRandomLastName();
        int merchantId = random.nextInt(500) + 1;
        String merchantName = MerchantRepo.getRandomMerchant();
        double amount = Math.round((random.nextDouble() * 1000) * 100.0) / 100.0;
        LocalDateTime timestamp = LocalDateTime.now().minusDays(random.nextInt(30));
        Transaction.TransactionStatus status = Transaction.TransactionStatus.values()[random.nextInt(Transaction.TransactionStatus.values().length)];
        return new Transaction(transactionId, accountId, payeeId, payeeFname, payeeLname, merchantId, merchantName, amount, timestamp, status);
    }
}