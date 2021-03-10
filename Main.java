package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Function> list = new ArrayList<>();


        try {
            BufferedReader br = new BufferedReader(new FileReader("functions.txt"));

            String line = br.readLine();
            while (line != null) {
                Function ab = new Function();
                ab.a = Integer.parseInt(String.valueOf(line.charAt(4)));
                ab.b = Integer.parseInt(line.substring(9));
                list.add(ab);
                line = br.readLine();
            }

            br.close();
        } catch (Exception e) {
            System.out.println("We're all dead");
        }
        for (Function function : list) {
            System.out.println(function.a + " " + function.b);

        }
        try {
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("count.txt"));
            bw1.write(String.valueOf(list.size()));
            bw1.close();
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("count_distinct.txt"));

            int distinctCount = 0;
            ArrayList<Function> distinct = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                boolean difference = true;
                for (int j = 0; j < distinct.size(); j++) {
                    if (list.get(i).a == distinct.get(j).a && list.get(i).b == distinct.get(j).b) {
                        difference = false;
                    }
                }
                if (difference) distinct.add(list.get(i));
            }
            bw2.write(String.valueOf(distinct.size()));

            bw2.close();
        } catch (Exception e) {
            System.out.println("Why");
        }
    }
}