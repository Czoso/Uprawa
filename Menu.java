package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void Menu() {
        Field field = new Field(10, "Poletko");
        Cowshed cowshed = new Cowshed(2, "Chlewik");
        System.out.println("Podaj swoje imię:");
        Scanner scan = new Scanner(System.in);
        Human player = new Human(scan, 100);
        System.out.println("Witaj!");
        System.out.println("Wcielasz się w rolę wieśniaka, który ma za zadanie rozwijać swoją farmę. Miłej gry.");
        ArrayList<Crop> Crops = new ArrayList<>();
        ArrayList<Seed> Seeds = new ArrayList<>();
        Seeds.add(new Seed("rzeżucha", 5));
        Seeds.add(new Seed("ryż", 0));
        Seeds.add(new Seed("marchew", 0));
        Seeds.add(new Seed("ziemniak", 0));
        Seeds.add(new Seed("arbuz", 0));
        ArrayList<Animal> Animals = new ArrayList<>();

        for (int i = 0; i == 1; i--) {
            System.out.println("Wielkość pola: " + Crops.size() + "/" + field.getSize());
            System.out.println("Wielkość chlewu: " + Animals.size() + "/" + cowshed.getSize());
            System.out.println("Posiadane monety: " + player.getCash());
            System.out.println("Aby zarządzać uprawami napisz 1");
            System.out.println("Aby zarządzać hodowlą napisz 2");
            System.out.println("Aby pójść do sklepu napisz 3");
            System.out.println("Aby iść spać napisz 4");
            Scanner willScan = new Scanner(System.in);
            int will = willScan.nextInt();
            if (will == 1) {
                System.out.println("Zasadzonych jest aktualnie " + Crops.size() + " roślin");
                System.out.println("Aktualnie "+ "ilosc" + " roslin jest gotowych do zbioru");
                System.out.println("Aby zebrać wszystkie dojrzałe rośliny napisz 1");
                System.out.println("Aby zasadzić rośliny napisz 2");
                System.out.println("Aby podlać wszystkie rośliny napisz 3");
                System.out.println("Aby nawieźć wszystkie rośliny napisz 4");
                Scanner cropScan = new Scanner(System.in);
                int cropWill = cropScan.nextInt();
                if (cropWill == 1){
                    int o = 0;
                    int p = 0;
                    for (int g=Crops.size(); p >=0 ; p--){
                        if (Crops.get(g).getAge() >= Crops.get(g).getHarvestAge()){
                            player.setCash(player.getCash()+Crops.get(g).getPrice());
                            Random seedRandom = new Random();
                            p++;
                            int u = seedRandom.nextInt(1);
                            if (u == 1){
                                Seeds.get(Crops.get(g).getId()).setQuantity(Seeds.get(Crops.get(g).getId()).getQuantity()+1);
                                o++;
                            }
                            Crops.remove(g);
                        }
                    }
                    System.out.println("Zebrałeś "+ p + " roślin, oraz " + o + " nasion");
                }else if(cropWill == 2){
                    int a = field.getSize() - Crops.size();
                    System.out.println("Ilość wolnych miejsc na polu - " + a);
                    System.out.println("Posiadasz aktualnie:");
                    System.out.println(Seeds.get(0).getQuantity() + " nasion rzeżuchy - 1");
                    System.out.println(Seeds.get(1).getQuantity() + " nasion ryżu - 2");
                    System.out.println(Seeds.get(2).getQuantity() + " nasion marchwi - 3");
                    System.out.println(Seeds.get(3).getQuantity() + " nasion ziemniaka - 4");
                    System.out.println(Seeds.get(4).getQuantity() + " nasion arbuza - 5");
                    System.out.println("Co chcesz zasadzić?");
                    Scanner plantingScan = new Scanner(System.in);
                    int plantWill = plantingScan.nextInt();
                    System.out.println("Jaką ilość?");
                    Scanner plantingScan1 = new Scanner(System.in);
                    int plantWill1 = plantingScan1.nextInt();
                    if(plantWill == 1) {
                        if(Seeds.get(plantWill-1).getQuantity() >= plantWill1) {
                            for (int k = 0; k < plantWill1; k++) {
                                Crops.add(new Crop("rzeżucha", 0, 20, 2, 0));
                                Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                            }
                        }
                    }else if(plantWill == 2) {
                        if(Seeds.get(plantWill-1).getQuantity() >= plantWill1) {
                            for (int k = 0; k < plantWill1; k++) {
                            Crops.add(new Crop("ryż", 0, 50, 3, 1));
                            Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                        }
                    }
                    }else if(plantWill == 3) {
                        if(Seeds.get(plantWill-1).getQuantity() >= plantWill1) {
                            for (int k = 0; k < plantWill1; k++) {
                                Crops.add(new Crop("marchew", 0, 100, 5, 2));
                                Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                            }
                        }
                    }else if(plantWill == 4) {
                        if(Seeds.get(plantWill-1).getQuantity() >= plantWill1) {
                            for (int k = 0; k < plantWill1; k++) {
                                Crops.add(new Crop("ziemniak", 0, 300, 10, 3));
                                Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                            }
                        }
                    }else if(plantWill == 5) {
                        if(Seeds.get(plantWill-1).getQuantity() >= plantWill1) {
                            for (int k = 0; k < plantWill1; k++) {
                                Crops.add(new Crop("arbuz", 0, 1000, 20, 4));
                                Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                            }
                        }
                    }else {
                        break;
                    }
                }
            } else if (will == 2) {

            } else if (will == 3) {

            } else if (will == 4) {

            }



        }
    }




}
