package controller;

import java.util.Scanner;

public class ValidasiInput {

    // Validasi Input Int
    public static int inputAngka(String pesan) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(pesan);
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus angka bulat!");
            scanner.next();
            System.out.print(pesan);
        }
        return scanner.nextInt();
    }

    // Validasi Input String
    public static String inputTeks(String pesan) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(pesan);
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println("Input tidak boleh kosong!");
            System.out.print(pesan);
            input = scanner.nextLine();
        }
        return input;
    }

    // Validasi Input Id Unik
    public static String inputIdUnik(String pesan, CommisionService service) {
        String id = "";
        boolean sudahAda = false;
        do {
            id = inputTeks(pesan);
            sudahAda = service.isIdExist(id);
            if (sudahAda) {
                System.out.println("ID Sudah Digunakan! Silakan gunakan ID lain.");
            }
        } while (sudahAda);
        return id;
    }
}
