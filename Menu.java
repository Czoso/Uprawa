package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void Menu1() {
        int price = 20;
        ArrayList<Crop> CropsList = new ArrayList<>();
        CropsList.add(new Crop("rzeżucha", 0, price, 2, 0, 1));
        CropsList.add(new Crop("ryż", 0, price * 3, 4, 1, 1));
        CropsList.add(new Crop("marchew", 0, price * 5, 6, 2, 1));
        CropsList.add(new Crop("ziemniak", 0, price * 10, 10, 3, 1));
        CropsList.add(new Crop("arbuz", 0, price * 25, 20, 4, 1));
        ArrayList<Animal> AnimalsList = new ArrayList<>();
        AnimalsList.add(new Animal("Pig", 0, 30,  30000, false, 1));
        AnimalsList.add(new Animal("Cow", 0, 50,  100000, false, 1));
        //Crop cress = new Crop("rzeżucha", 0, price, 2, 0, 1);
        //Crop rise = new Crop("ryż", 0, price * 3, 4, 1, 1);
        //Crop carrot = new Crop("marchew", 0, price * 5, 6, 2, 1);
        //Crop potato = new Crop("ziemniak", 0, price * 10, 10, 3, 1);
        //Crop watermelon = new Crop("arbuz", 0, price * 25, 20, 4, 1);
        Field field = new Field(10, "Poletko");
        Cowshed cowshed = new Cowshed(0, "Chlewik");
        System.out.println("Podaj swoje imię:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        Human player = new Human(name, 100);
        System.out.println("Witaj!");
        System.out.println("Wcielasz się w rolę wieśniaka, który ma za zadanie rozwijać swoją farmę. Miłej gry.");
        ArrayList<Crop> Crops = new ArrayList<>();
        ArrayList<Animal> Animals = new ArrayList<>();
        ArrayList<Seed> Seeds = new ArrayList<>();
        Seeds.add(new Seed("rzeżucha", 5, 10));
        Seeds.add(new Seed("ryż", 0, 30));
        Seeds.add(new Seed("marchew", 0, 50));
        Seeds.add(new Seed("ziemniak", 0, 100));
        Seeds.add(new Seed("arbuz", 0, 250));
        System.out.println("1");
        int v = 0;
        for (int day = 1; day > 0; day++) {
            int ready=0;
            for (int g = Crops.size() - 1; g >= 0; g--) {
                Crops.get(g).setWater(Crops.get(g).getWater() + 1);
                if (Crops.get(g).getWater() == 3) {
                    Crops.remove(g);
                    v++;
                }
            }
            for (int g = Crops.size() - 1; g >= 0; g--){
                Crops.get(g).setAge(Crops.get(g).getAge()+1);
            }
            System.out.println("Aktualnie jest dzień: " + day);
            if (v > 0) {
                System.out.println("Dzisiejszej nocy uschły " + v + "x rośliny");
            }
            for (int g = Crops.size() - 1; g >= 0; g--){
                if(Crops.get(g).getAge()==Crops.get(g).getHarvestAge()){
                    ready++;
                }
            }
            for (int i = 1; i > 0; i++) {
                System.out.println("2");
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
                    for (int c = 0; c >= 0; c++) {
                        System.out.println("Zasadzonych jest aktualnie " + Crops.size() + " roślin");
                        System.out.println("Aktualnie " + ready + " roslin jest gotowych do zbioru");
                        System.out.println("Aby zebrać wszystkie dojrzałe rośliny napisz 1");
                        System.out.println("Aby zasadzić rośliny napisz 2");
                        System.out.println("Aby podlać wszystkie rośliny napisz 3");
                        System.out.println("Aby nawieźć wszystkie rośliny napisz 4");
                        System.out.println("Aby się cofnąć napisz 5");
                        Scanner cropScan = new Scanner(System.in);
                        int cropWill = cropScan.nextInt();
                        if (cropWill == 1) {
                            int o = 0;
                            int p = 0;
                            for (int g = Crops.size()-1; g >= 0; g--) {
                                if (Crops.get(g).getAge() >= Crops.get(g).getHarvestAge()) {
                                    player.setCash(player.getCash() + Crops.get(g).getPrice());
                                    Random seedRandom = new Random();
                                    p++;
                                    int u = seedRandom.nextInt(2);
                                    if (u == 1) {
                                        Seeds.get(Crops.get(g).getSeedId()).setQuantity(Seeds.get(Crops.get(g).getSeedId()).getQuantity() + 1);
                                        o++;
                                    }
                                    Crops.remove(g);
                                }
                            }
                            System.out.println("Zebrałeś " + p + "x rośline, oraz " + o + "x nasiono");
                        } else if (cropWill == 2) {
                            int a = field.getSize() - Crops.size();
                            System.out.println("Ilość wolnych miejsc na polu - " + a);
                            System.out.println("Posiadasz aktualnie:");
                            System.out.println(Seeds.get(0).getQuantity() + " nasion rzeżuchy - 1");
                            System.out.println(Seeds.get(1).getQuantity() + " nasion ryżu - 2");
                            System.out.println(Seeds.get(2).getQuantity() + " nasion marchwi - 3");
                            System.out.println(Seeds.get(3).getQuantity() + " nasion ziemniaka - 4");
                            System.out.println(Seeds.get(4).getQuantity() + " nasion arbuza - 5");
                            System.out.println("Aby się cofnąć - 6");
                            System.out.println("Co chcesz zasadzić?");
                            Scanner plantingScan = new Scanner(System.in);
                            int plantWill = plantingScan.nextInt();
                            System.out.println("Jaką ilość?");
                            Scanner plantingScan1 = new Scanner(System.in);
                            int plantWill1 = plantingScan1.nextInt();
                            if (plantWill == 1) {
                                if (Seeds.get(plantWill - 1).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {
                                        Crops.add(CropsList.get(0));
                                        Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                                    }
                                }
                            } else if (plantWill == 2) {
                                if (Seeds.get(plantWill - 1).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {
                                        Crops.add(CropsList.get(1));
                                        Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                                    }
                                }
                            } else if (plantWill == 3) {
                                if (Seeds.get(plantWill - 1).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {
                                        Crops.add(CropsList.get(2));
                                        Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                                    }
                                }
                            } else if (plantWill == 4) {
                                if (Seeds.get(plantWill - 1).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {
                                        Crops.add(CropsList.get(3));
                                        Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                                    }
                                }
                            } else if (plantWill == 5) {
                                if (Seeds.get(plantWill - 1).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {
                                        Crops.add(CropsList.get(4));
                                        Seeds.get(plantWill - 1).setQuantity(Seeds.get(plantWill - 1).getQuantity() - 1);
                                    }
                                }
                            } else {
                                break;
                            }
                        } else if (cropWill == 3) {
                            if (Crops.size() <= player.getCash()) {
                                for (int g = Crops.size() - 1; g >= 0; g--) {
                                    Crops.get(g).setWater(0);
                                    player.setCash(player.getCash() - 1);
                                }
                            } else {
                                System.out.println("Nie masz pieniędzy na podlanie roślin");
                            }

                        } else if (cropWill == 4) {
                            System.out.println("Jaki nawóz chcesz zastosować?:");
                            System.out.println("Fosfor (1000 monet) - zmniejsza ilosc dni niezbednych do dojrzewania o połowe, posiadana ilosc - , aby uzyc napisz 1");
                            System.out.println("Randap (4000 monet), król wśród nawozów - sprawia, że wszystkie rośliny stają się dojrzałe, posiadana ilość - , aby użyć napisz 2");
                            Scanner fertilizeScan = new Scanner(System.in);
                            int fertilizeWill = fertilizeScan.nextInt();
                            if (fertilizeWill == 1) {
                                if (player.getCash() >= 1000) {
                                    for (int g = Crops.size() - 1; g >= 0; g--) {
                                        Crops.get(g).setAge((Crops.get(g).getHarvestAge() / 2) + Crops.get(g).getAge());

                                    }
                                    player.setCash(player.getCash() - 1000);
                                }
                            } else if (fertilizeWill == 2) {
                                if (player.getCash() >= 4000) {
                                    for (int g = Crops.size() - 1; g >= 0; g--) {
                                        Crops.get(g).setAge(Crops.get(g).getHarvestAge());

                                    }
                                    player.setCash(player.getCash() - 4000);
                                }
                            }
                        } else {
                            break;
                        }
                    }

                } else if (will == 2) {
                    System.out.println("Ilość wolnych miejsc w chlewie: ");


                } else if (will == 3) {
                    for(int shopLoop=1; shopLoop>0; shopLoop++) {
                        System.out.println("Kogo chcesz odwiedzić?");
                        System.out.println("sprzedawcę nasion - 1");
                        System.out.println("sprzedawcę roślin - 2");
                        System.out.println("sprzedawcę zwierząt - 3");
                        System.out.println("sprzedawcę nawozów - 4");
                        System.out.println("sprzedawcę leków - 5");
                        System.out.println("sprzedawcę architektury - 6");
                        System.out.println("sprzedawcę technologii - 7");
                        System.out.println("pośrednika pracy - 8");
                        System.out.println("wróć na wieś - 9");
                        Scanner shopScan = new Scanner(System.in);
                        int shopWill = shopScan.nextInt();
                        if (shopWill == 1) {
                            for(int seedShop=1; seedShop>0; seedShop++) {
                                System.out.println("Witaj " + player.getName() + "!!! Nazywam się Jakub i jestem sprzedawcą nasion. Jaki interes dzisiaj ubijemy?:");
                                System.out.println("nasiona rzeżuchy - 10 monet - 1");
                                System.out.println("nasiona ryżu - 30 monet - 2");
                                System.out.println("nasiona marchwi - 50 monet - 3");
                                System.out.println("nasiona ziemniaków - 100 monet - 4");
                                System.out.println("nasiona arbuzów - 250 monet - 5");
                                System.out.println("Odwiedź innego sprzedawcę - 6");
                                Scanner seedScan = new Scanner(System.in);
                                int seedType = seedScan.nextInt();
                                System.out.println("Jaką ilość?");
                                Scanner seedScan1 = new Scanner(System.in);
                                int seedQuantity = seedScan1.nextInt();
                                if (seedType > 0) {
                                    if (seedType < 6) {
                                        if (player.getCash() > (Seeds.get(seedType - 1).getPrice() * seedQuantity)) {
                                            Seeds.get(seedType - 1).setQuantity(Seeds.get(seedType - 1).getQuantity() + seedQuantity);
                                            player.setCash(player.getCash() - (Seeds.get(seedType - 1).getPrice() * seedQuantity));
                                        } else {
                                            System.out.println("Chyba cię na to nie stać kolego");
                                        }

                                    }else{
                                        break;
                                    }
                                }else{
                                    break;
                                }
                            }
                        } else if (shopWill == 2) {
                            for (int seedShop=1; seedShop>0; seedShop++){
                            System.out.println("Siemano " +player.getName()+", jestem Mati, sprzedawca roślin. Chcesz coś kupić?:");
                            System.out.println("rzeżucha - 30 monet - 1");
                            System.out.println("ryż - 90 monet - 2");
                            System.out.println("marchew - 150 monet - 3");
                            System.out.println("ziemniak - 300 monet - 4");
                            System.out.println("arbuz - 750 monet - 5");
                            System.out.println("Odwiedź innego sprzedawcę - 6");
                                Scanner plantScan = new Scanner(System.in);
                                int plantType = plantScan.nextInt();
                                System.out.println("Jaką ilość?");
                                Scanner plantScan1 = new Scanner(System.in);
                                int plantQuantity = plantScan1.nextInt();
                                if (plantType > 0) {
                                    if (plantType < 6) {
                                        if (player.getCash() > (CropsList.get(plantType - 1).getPrice() * plantQuantity*1.5)) {
                                            for(int plantShop = 0; plantShop<plantQuantity; plantShop++)
                                            Crops.add(CropsList.get(plantType-1));
                                        } else {
                                            System.out.println("Chyba cię na to nie stać kolego");
                                        }
                                    }else{
                                        break;
                                    }
                                }else{
                                    break;
                                }
                            }
                        } else if (shopWill == 3) {
                            for (int animalShop=1; animalShop>0;animalShop++){
                                System.out.println("Dzień dobry "+ player.getName()+" , nie chciałbyś kupić jakiegoś zwierzaka?:");
                                System.out.println("mała świnia - 10000 - 1");
                                System.out.println("mała krowa - 40000 - 2");
                                System.out.println("odwiedź innego sprzedawcę - 3");
                                Scanner animalScan = new Scanner(System.in);
                                int animalType = animalScan.nextInt();
                                System.out.println("Jaką ilość?");
                                Scanner animalScan1 = new Scanner(System.in);
                                int animalQuantity = animalScan1.nextInt();
                                if (animalType == 1) {
                                    //tutaj kupowanie zwierząt


                                }else{
                                    break;
                                }


                            }

                        } else if (shopWill == 4) {

                        } else if (shopWill == 5) {

                        } else if (shopWill == 6) {

                        } else if (shopWill == 7) {

                        } else if (shopWill == 8) {

                        } else {
                            break;
                        }
                    }


                } else {
                    break;
                }
            }
        }

    }
}
