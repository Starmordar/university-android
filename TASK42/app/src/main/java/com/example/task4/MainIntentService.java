package com.example.task4;

import android.app.IntentService;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainIntentService  extends IntentService {
    public MainIntentService() {
        super("MainIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int number =  intent.getIntExtra("number", 0);

        List<Integer> primeNumbers = getPrimaryNumbers(number);
        int count = primeNumbers.size();

        StringBuilder listString = new StringBuilder();

        for (int s : primeNumbers){
            listString.append(s).append(", ");
        }
        listString.setLength(listString.length() - 2);

        sendPrimeNumbersToUser(count, listString.toString());
}

    private List getPrimaryNumbers(Integer number){
        List<Integer> primeNumbers = new ArrayList<Integer>();

        for (int j = 1; j <= number; j++){
            if (isPrime(j))
                primeNumbers.add(j);
        }

        return primeNumbers;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }

    private void sendPrimeNumbersToUser(int total, String allNumbers){
        Intent intent = new Intent("MainActivity");
        intent.putExtra("prime_numbers", allNumbers);
        intent.putExtra("amount", total);

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
