package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void Menu1() throws CloneNotSupportedException {
        int price = 20;
        int animalPrice = 10000;
        int randapCount=0;
        int cowshedUpgrade=100000;
        int animalUpgrade=50000;
        int cropUpgrade=2500;
        int fieldUpgrade=1000;
        int carrot = 0;
        int potato = 0;
        int watermelon = 0;
        int pig = 0;
        int cow = 0;
        int autoWater = 0;
        int autoHarvest = 0;
        int autoMess = 0;
        int autoIllness = 0;
        int autoHunger = 0;
        int autoPlant = 0;
        int autoPlantChoice=0;
        int autoSell=0;
        int autoBuy=0;
        int autoBuyChoice=0;
        Random illness = new Random();
        ArrayList<Crop> CropsList = new ArrayList<>();
        ArrayList<Storage> Goods = new ArrayList<>();
        Goods.add(new Storage("rzeżucha", 0, price, price*2)); //0
        Goods.add(new Storage("ryż", 0, price * 3, price*6)); //1
        Goods.add(new Storage("marchew", 0, price * 5, price*10)); //2
        Goods.add(new Storage("ziemniak", 0, price * 10, price*20));//3
        Goods.add(new Storage("arbuz", 0, price * 25, price*50)); //4
        Goods.add(new Storage("nasiono rzeżuchy", 5, 2, 10)); //5
        Goods.add(new Storage("nasiono ryżu", 0, 6, 30)); //6
        Goods.add(new Storage("nasiono marchwi", 0, 10, 50)); //7
        Goods.add(new Storage("nasiono ziemniaka", 0, 20, 100)); //8
        Goods.add(new Storage("nasiono arbuza", 0, 50, 250)); //9
        Goods.add(new Storage("antybiotyk", 0, 200, 1000)); //10
        Goods.add(new Storage("fosfor", 0, 200, 1000)); //11
        Goods.add(new Storage("randap", 0 ,2000, 10000));//12
        //Goods.add(new Storage(rzeżucha, 0)); //13
        //Goods.add(new Storage(rzeżucha, 0)); //14Sie
        CropsList.add(new Crop("rzeżucha", 0, price, 2, 0, 1));
        CropsList.add(new Crop("ryż", 0, price * 3, 4, 1, 1));
        CropsList.add(new Crop("marchew", 0, price * 5, 6, 2, 1));
        CropsList.add(new Crop("ziemniak", 0, price * 10, 10, 3, 1));
        CropsList.add(new Crop("arbuz", 0, price * 25, 20, 4, 1));
        ArrayList<Animal> AnimalsList = new ArrayList<>();
        AnimalsList.add(new Animal("Pig", 0, 30, animalPrice * 3, false, 1, 5));
        AnimalsList.add(new Animal("Cow", 0, 50, animalPrice * 10, false, 1, 5));
        //Crop cress = new Crop("rzeżucha", 0, price, 2, 0, 1);
        //Crop rise = new Crop("ryż", 0, price * 3, 4, 1, 1);
        //Crop carrot = new Crop("marchew", 0, price * 5, 6, 2, 1);
        //Crop potato = new Crop("ziemniak", 0, price * 10, 10, 3, 1);
        //Crop watermelon = new Crop("arbuz", 0, price * 25, 20, 4, 1);
        Field field = new Field(10, "Poletko");
        Cowshed cowshed = new Cowshed(1, "Chlewik", 5, 100000);
        System.out.println("Podaj swoje imię:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        Human player = new Human(name, 100);
        System.out.println("Witaj!");
        System.out.println("Wcielasz się w rolę wieśniaka, który ma za zadanie rozwijać swoją farmę. Miłej gry.");
        ArrayList<Crop> Crops = new ArrayList<>();
        ArrayList<Animal> Animals = new ArrayList<>();
        //ArrayList<Seed> Seeds = new ArrayList<>();
        //Seeds.add(new Seed("rzeżucha", 5, 10));
        //Seeds.add(new Seed("ryż", 0, 30));
        //Seeds.add(new Seed("marchew", 0, 50));
        //Seeds.add(new Seed("ziemniak", 0, 100));
        //Seeds.add(new Seed("arbuz", 0, 250));
        for (int day = 1; day > 0; day++) {
            int v;
            int ready = 0;
            int w;
            int r;
            r=0;
            v = 0;
            w = 0;
            int deadAnimal;
            deadAnimal =0;
            if(autoSell==1) {
                for (int g = Animals.size() - 1; g >= 0; g--) {
                    if (Animals.get(g).getMatureAge() <= Animals.get(g).getAge()) {
                        player.setCash(player.getCash() + Animals.get(g).getPrice());
                        Animals.remove(g);
                    }
                }
            }
            if (autoBuy==1){
                if (autoBuyChoice==1){
                    if(player.getCash()>=10000*(cowshed.getSize()-Animals.size()))
                        for(int g = cowshed.getSize()-Animals.size(); g>0; g--) {
                            Animals.add((Animal) AnimalsList.get(0).clone());
                            player.setCash(player.getCash() - 10000);
                        }
                } else if (autoBuyChoice==2){
                    if(player.getCash()>=40000*(cowshed.getSize()-Animals.size()))
                        for(int g = cowshed.getSize()-Animals.size(); g>0; g--) {
                            Animals.add((Animal) AnimalsList.get(1).clone());
                            player.setCash(player.getCash() - 40000);
                        }
                }
            }
            for (int g = Animals.size() -1 ; g>=0; g--){
                if(Animals.get(g).getIllness()==true){
                    Animals.remove(g);
                    deadAnimal++;
                }
            }
            if(deadAnimal>0){
                System.out.println("Zdechło "+deadAnimal+"x zwierze");
            }
            if (autoWater ==1){
                if(player.getCash()>=Crops.size()) {
                    for (int g = Crops.size() - 1; g >= 0; g--) {
                        Crops.get(g).setWater(0);
                        player.setCash(player.getCash() - 1);
                    }
                }else{
                    System.out.println("Nie było cię stać na podlanie roślin");
                }
            }
            int crops1;
            crops1=0;
            int seeds1;
            seeds1=0;
            if (autoHarvest ==1){
                for (int g = Crops.size() - 1; g >= 0; g--) {
                    if (Crops.get(g).getAge() >= Crops.get(g).getHarvestAge()) {
                        Goods.get(Crops.get(g).getSeedId()).setQuantity(Goods.get(Crops.get(g).getSeedId()).getQuantity() + 1);
                        Random seedRandom = new Random();
                        crops1++;
                        int u = seedRandom.nextInt(2);
                        if (u == 1) {
                            Goods.get(Crops.get(g).getSeedId() + 5).setQuantity(Goods.get(Crops.get(g).getSeedId() + 5).getQuantity() + 1);
                            seeds1++;
                        }
                        Crops.remove(g);
                    }
                }
                if(crops1>0) {
                    System.out.println("Zebrałeś " + crops1 + "x rośline, oraz " + seeds1 + "x nasiono");
                }
            }
            for (int g = Crops.size() - 1; g >= 0; g--) {
                Crops.get(g).setWater(Crops.get(g).getWater() + 1);
            }
            if(autoPlant == 1)
                if(autoPlant!=0) {
                    for (int g = field.getSize() - Crops.size(); g > 0; g--) {
                        if (Goods.get(autoPlantChoice + 4).getQuantity() > 0) {
                            Crops.add((Crop) CropsList.get(autoPlantChoice - 1).clone());
                            Goods.get(autoPlantChoice + 4).setQuantity(Goods.get(autoPlantChoice + 4).getQuantity() - 1);
                        } else {
                            System.out.println("skończyły się nasiona ");
                            break;
                        }
                    }
                }
            for (int g = Animals.size() -1 ; g>=0; g--){
                Animals.get(g).setHunger(Animals.get(g).getHunger()+1);
                if(Animals.get(g).getHunger() == 3){
                    Animals.remove(g);
                    w++;
                }
            }
            for (int g = Animals.size() -1 ; g>=0; g--){
                int animalIllness = illness.nextInt(100);
                if(animalIllness<Animals.get(g).getMess()){
                    Animals.get(g).setIllness(true);
                    r++;
                }
            }
            if(autoMess==1) {
                if(player.getCash()>=Animals.size()*10) {
                    for (int g = Animals.size() - 1; g >= 0; g--) {
                        Animals.get(g).setMess(5);
                        player.setCash(player.getCash() - 10);
                    }
                }else{
                    System.out.println("Nie było cię stać na sprzątnięcie obory");
                }
            }
            if(r>0){
                System.out.println("Dzisiejsze nocy zachorowało "+r+"x zwierząt");
            }
            if(autoIllness==1){
                for( int g = Animals.size() -1 ; g>=0; g--){
                    if(Animals.get(g).getIllness()==true){
                        if(Goods.get(10).getQuantity()>0){
                            Animals.get(g).setIllness(false);
                            Goods.get(10).setQuantity(Goods.get(10).getQuantity()-1);
                        }else{
                            System.out.println("nie miałeś antybiotyków żeby wyleczyć wszystkie zwierzęta");
                            break;
                        }
                    }
                }
            }
            if(autoHunger==1){
                int cows;
                cows=0;
                int pigs;
                pigs=0;
                for(int g = Animals.size()-1; g>=0; g--) {
                    if (Animals.get(g).getMatureAge() == 30) {
                        pigs++;
                    } else
                        cow++;
                }
                if(Goods.get(3).getQuantity()>=pigs){
                    if(Goods.get(4).getQuantity()>=cows){
                        for (int g = Animals.size()-1; g>=0; g--){
                            Animals.get(g).setHunger(0);
                        }
                        Goods.get(3).setQuantity(Goods.get(3).getQuantity()-pigs);
                        Goods.get(4).setQuantity(Goods.get(4).getQuantity()-cows);
                    }else{
                        System.out.println("Nie miales odpowiedniej ilości arbuzów");
                    }
                }else{
                    System.out.println("Nie miales wystarczającej ilości ziemniaków");
                }
            }
            for (int g = Animals.size() -1 ; g>=0; g--){
                Animals.get(g).setMess(Animals.get(g).getMess()+10);
            }
            for (int g = Crops.size() - 1; g >= 0; g--) {
                Crops.get(g).setAge(Crops.get(g).getAge() + 1);
            }
            System.out.println("Aktualnie jest dzień: " + day);
            if (v > 0) {
                System.out.println("Dzisiejszej nocy uschły " + v + "x rośliny");
            }
            if(w>0){
                System.out.println("Dzisiejszej nocy zdechy " +w + "x zwierzęta");
            }
            for (int g = Crops.size() - 1; g >= 0; g--) {
                if (Crops.get(g).getAge() == Crops.get(g).getHarvestAge()) {
                    ready++;
                }
            }
            for (int i = 1; i > 0; i++) {
                System.out.println("Wielkość pola: " + Crops.size() + "/" + field.getSize());
                System.out.println("Wielkość chlewu: " + Animals.size() + "/" + cowshed.getSize());
                System.out.println("Posiadane monety: " + player.getCash());
                System.out.println("Zarządzanie uprawami - 1");
                System.out.println("Zarządzanie hodowlą - 2");
                System.out.println("Wycieczka do sklepu - 3");
                System.out.println("Odwiedź magazyn - 4");
                System.out.println("Pójście spać - 9");
                Scanner willScan = new Scanner(System.in);
                int will = willScan.nextInt();
                if (will == 1) {
                    for (int c = 0; c >= 0; c++) {
                        System.out.println("Zasadzonych jest aktualnie " + Crops.size() + "/" + field.getSize() + " roślin");
                        System.out.println("Aktualnie " + ready + " roslin jest gotowych do zbioru");
                        System.out.println("Zbieranie wszystkich dojrzałych roślin - 1");
                        System.out.println("Sadzenie roślin - 2");
                        System.out.println("Podlewanie wszystkich roślin - 3");
                        System.out.println("Nawożenie wszystkich roślin - 4");
                        if(autoPlant==1){
                            System.out.println("Ustawienie zasadzacza - 5");
                        }
                        System.out.println("Powrót - 9");
                        Scanner cropScan = new Scanner(System.in);
                        int cropWill = cropScan.nextInt();
                        if (cropWill == 1) {
                            int o = 0;
                            int p = 0;
                            for (int g = Crops.size() - 1; g >= 0; g--) {
                                if (Crops.get(g).getAge() >= Crops.get(g).getHarvestAge()) {
                                    Goods.get(Crops.get(g).getSeedId()).setQuantity(Goods.get(Crops.get(g).getSeedId()).getQuantity() + 1);
                                    Random seedRandom = new Random();
                                    p++;
                                    int u = seedRandom.nextInt(2);
                                    if (u == 1) {
                                        Goods.get(Crops.get(g).getSeedId() + 5).setQuantity(Goods.get(Crops.get(g).getSeedId() + 5).getQuantity() + 1);
                                        o++;
                                    }
                                    Crops.remove(g);
                                }
                            }
                            System.out.println("Zebrałeś " + p + "x rośline, oraz " + o + "x nasiono");
                            ready=0;
                        } else if (cropWill == 2) {
                            int a = field.getSize() - Crops.size();
                            System.out.println("Ilość wolnych miejsc na polu - " + a);
                            System.out.println("Posiadasz aktualnie:");
                            System.out.println(Goods.get(5).getQuantity() + " nasion rzeżuchy - 1");
                            System.out.println(Goods.get(6).getQuantity() + " nasion ryżu - 2");
                            System.out.println(Goods.get(7).getQuantity() + " nasion marchwi - 3");
                            System.out.println(Goods.get(8).getQuantity() + " nasion ziemniaka - 4");
                            System.out.println(Goods.get(9).getQuantity() + " nasion arbuza - 5");
                            System.out.println("Aby się cofnąć - 6");
                            System.out.println("Co chcesz zasadzić?");
                            Scanner plantingScan = new Scanner(System.in);
                            int plantWill = plantingScan.nextInt();
                            System.out.println("Jaką ilość?");
                            Scanner plantingScan1 = new Scanner(System.in);
                            int plantWill1 = plantingScan1.nextInt();
                            if (plantWill == 1) {
                                if (Goods.get(plantWill + 4).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {
                                        Crop cress = (Crop) CropsList.get(0).clone();
                                        Crops.add(cress);
                                        Goods.get(plantWill + 4).setQuantity(Goods.get(plantWill + 4).getQuantity() - 1);
                                    }
                                } else {
                                    System.out.println("Nie masz tylu nasion");
                                }
                            } else if (plantWill == 2) {
                                if (Goods.get(plantWill + 4).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {

                                        Crop rise = (Crop) CropsList.get(1).clone();
                                        Crops.add(rise);
                                        Goods.get(plantWill + 4).setQuantity(Goods.get(plantWill + 4).getQuantity() - 1);
                                    }
                                } else {
                                    System.out.println("Nie masz tylu nasion");
                                }
                            } else if (plantWill == 3) {
                                if (Goods.get(plantWill + 4).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {
                                        Crop carrot1 = (Crop) CropsList.get(2).clone();
                                        Crops.add(carrot1);
                                        Goods.get(plantWill + 4).setQuantity(Goods.get(plantWill + 4).getQuantity() - 1);
                                    }
                                } else {
                                    System.out.println("Nie masz tylu nasion");
                                }
                            } else if (plantWill == 4) {
                                if (Goods.get(plantWill + 4).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {
                                        Crop potato1 = (Crop) CropsList.get(3).clone();
                                        Crops.add(potato1);
                                        Goods.get(plantWill + 4).setQuantity(Goods.get(plantWill + 4).getQuantity() - 1);
                                    }
                                } else {
                                    System.out.println("Nie masz tylu nasion");
                                }
                            } else if (plantWill == 5) {
                                if (Goods.get(plantWill + 4).getQuantity() >= plantWill1) {
                                    for (int k = 0; k < plantWill1; k++) {
                                        Crop watermelon1 = (Crop) CropsList.get(4).clone();
                                        Crops.add(watermelon1);
                                        Goods.get(plantWill + 4).setQuantity(Goods.get(plantWill + 4).getQuantity() - 1);
                                    }
                                } else {
                                    System.out.println("Nie masz tylu nasion");
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
                            System.out.println("Fosfor  - zmniejsza ilosc dni niezbednych do dojrzewania o połowe, posiadana ilosc - , aby uzyc napisz 1");
                            System.out.println("Randap, król wśród nawozów - sprawia, że wszystkie rośliny stają się dojrzałe, posiadana ilość - , aby użyć napisz 2");
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
                        } else if(cropWill==5){
                            if(autoPlant==1){
                                System.out.println("Jaką rośline chcesz sadzić?");
                                System.out.println("rzeżuchę - 1");
                                System.out.println("ryż - 2");
                                System.out.println("marchew - 3");
                                System.out.println("ziemniaka - 4");
                                System.out.println("arbuza - 5");
                                System.out.println("wyłączenie auto sadzenia - 6");
                                System.out.println("powrót - 6");
                                Scanner autoScan = new Scanner(System.in);
                                int plantScan = autoScan.nextInt();
                                if(plantScan>0){
                                    if(plantScan<6){
                                        if(plantScan == 1){
                                            autoPlantChoice=1;
                                            System.out.println("będziesz sadził rzeżuchę");
                                        }else if(plantScan == 2){
                                            autoPlantChoice=2;
                                            System.out.println("będziesz sadził ryż");
                                        }else if(plantScan == 3){
                                            if(carrot==1) {
                                                autoPlantChoice = 3;
                                                System.out.println("będziesz sadził marchew");
                                            }else{
                                                System.out.println("Nie odkryłeś marchwi");
                                            }
                                        }else if(plantScan == 4){
                                            if(potato==1) {
                                                autoPlantChoice = 4;
                                                System.out.println("będziesz sadził ziemniaka");
                                            }else{
                                                System.out.println("nie odkryłeś ziemniaka");
                                            }
                                        }else if(plantScan == 5){
                                            if(watermelon==1) {
                                                autoPlantChoice = 5;
                                                System.out.println("będziesz sadził arbuza");
                                            }else{
                                                System.out.println("nie odkryłeś arbuza");
                                            }
                                        }else if(plantScan == 6){
                                            autoPlantChoice = 0;
                                            System.out.println("auto sadzenie wyłączone");

                                        }
                                    }
                                }
                            }else{
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                } else if (will == 2) {
                    for (int animalLoop = 1; animalLoop > 0; animalLoop++) {
                        int pig1 = 0;
                        int cow1 = 0;
                        for (int count1 = Animals.size() - 1; count1 >= 0; count1--) {
                            if (Animals.get(Animals.size() - 1).getMatureAge() == 30) {
                                pig1++;
                            } else {
                                cow1++;
                            }
                        }
                        int mature = 0;
                        for(int g = Animals.size()-1; g>=0; g--){
                            if(Animals.get(g).getMatureAge()<=Animals.get(g).getAge()){
                                mature++;
                            }
                        }
                        System.out.println("Ilość wolnych miejsc w chlewie: " + Animals.size() + "/" + cowshed.getSize());
                        System.out.println("Posiadasz "+mature+" wyrośniętych zwirząt");
                        System.out.println("Aktualnie posiadasz:");
                        System.out.println(pig1 + " świń");
                        System.out.println(cow1 + " krów");
                        System.out.println("Co chcesz zrobić?");
                        System.out.println("Karmienie - 1");
                        System.out.println("Sprzedaż - 2");
                        System.out.println("Sprzątanie - 3");
                        System.out.println("Leczenie - 4");
                        if(autoBuy==1) {
                            System.out.println("Ustawienie auto-kupca - 5");
                        }
                        System.out.println("Powrót - 9");
                        Scanner animalScan = new Scanner(System.in);
                        int animalChoice = animalScan.nextInt();
                        if (animalChoice == 1) {
                            int cows;
                            cows=0;
                            int pigs;
                            pigs=0;
                            for(int g = Animals.size()-1; g>=0; g--) {
                                if (Animals.get(g).getMatureAge() == 30) {
                                    pigs++;
                                } else
                                    cows++;
                            }
                            if(Goods.get(3).getQuantity()>=pigs){
                                if(Goods.get(4).getQuantity()>=cows){
                                    for (int g = Animals.size()-1; g>=0; g--){
                                        Animals.get(g).setHunger(0);
                                    }
                                    Goods.get(3).setQuantity(Goods.get(3).getQuantity()-pigs);
                                    Goods.get(4).setQuantity(Goods.get(4).getQuantity()-cows);
                                }else{
                                    System.out.println("Nie masz odpowiedniej ilości arbuzów");
                                }
                            }else{
                                System.out.println("Nie masz wystarczającej ilości ziemniaków");
                            }
                        } else if (animalChoice == 2) {
                            int counter;
                            counter = 0;
                            for (int count = Animals.size() - 1; count >= 0; count--) {
                                if (Animals.get(count).getMatureAge() <= Animals.get(count).getAge()) {
                                    player.setCash(player.getCash() + Animals.get(count).getPrice());
                                    Animals.remove(count);
                                    counter++;
                                }
                            }
                            System.out.println("Sprzedałeś " + counter + "x zwierze");
                        } else if (animalChoice == 3) {
                            if (player.getCash() >= cowshed.getSize() * 10) {
                                cowshed.setStatus(5);
                                player.setCash(player.getCash() - (cowshed.getSize() * 10));
                            } else {
                                System.out.println("Nie stać cię na sprzątnięcie obory");
                            }
                        } else if (animalChoice == 4) {
                            int ill;
                            ill=0;
                            for(int g=Animals.size()-1;g>=0;g-- ){
                                if (Animals.get(g).getIllness()==true){
                                    ill++;
                                }
                            }
                            if(ill>0){
                                if(Goods.get(10).getQuantity()>=ill){
                                    for (int g = Animals.size()-1; g>=0;g--){
                                        if(Animals.get(g).getIllness()==true){
                                            Animals.get(g).setIllness(false);
                                            Goods.get(10).setQuantity(Goods.get(10).getQuantity()-1);
                                        }
                                    }
                                }else{
                                    System.out.println("Nie masz wystarczającej ilości leków");
                                }
                            }else{
                                System.out.println("Wszystkie zwierzaki są zdrowe");
                            }
                        }else if(animalChoice==5){
                            if(autoBuy==1){
                                System.out.println("Kupowanie świń - 1");
                                System.out.println("Kupowanie krów - 2");
                                System.out.println("Wyłączenie auto-kupna - 3");
                                Scanner buyScan = new Scanner(System.in);
                                int animalBuy = buyScan.nextInt();
                                if(animalBuy==1){
                                    autoBuyChoice=1;
                                    System.out.println("Będziesz kupował świnie");
                                } else if (animalBuy==2){
                                    autoBuyChoice=2;
                                    System.out.println("Będziesz kupował krowy");
                                } else if (animalBuy==3){
                                    autoBuyChoice=0;
                                    System.out.println("auto kupowanie wyłączone");
                                }
                            }else {
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                } else if (will == 3) {
                    for (int shopLoop = 1; shopLoop > 0; shopLoop++) {
                        System.out.println("Posiadasz aktualnie: " + player.getCash() + " monet");
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
                            System.out.println("Witaj " + player.getName() + "!!! Nazywam się Jakub i jestem sprzedawcą nasion. Jaki interes dzisiaj ubijemy?:");
                            for (int seedShop = 1; seedShop > 0; seedShop++) {
                                int tech = 0;
                                System.out.println("Posiadasz aktualnie: " + player.getCash() + " monet");
                                System.out.println("nasiona rzeżuchy - 10 monet - 1");
                                System.out.println("nasiona ryżu - 30 monet - 2");
                                if (carrot == 1) {
                                    System.out.println("nasiona marchwi - 50 monet - 3");
                                }
                                if (potato == 1) {
                                    System.out.println("nasiona ziemniaków - 100 monet - 4");
                                }
                                if (watermelon == 1) {
                                    System.out.println("nasiona arbuzów - 250 monet - 5");
                                }
                                System.out.println("Odwiedź innego sprzedawcę - 9");
                                Scanner seedScan = new Scanner(System.in);
                                int seedType = seedScan.nextInt();
                                if (seedType > 0) {
                                    if (seedType == 3) {
                                        tech = 1;
                                        if (carrot == 1) {
                                            tech = 0;
                                        }
                                    }
                                    if (seedType == 4) {
                                        tech = 1;
                                        if (potato == 1) {
                                            tech = 0;
                                        }
                                    }
                                    if (seedType == 5) {
                                        tech = 1;
                                        if (watermelon == 1) {
                                            tech = 0;
                                        }
                                    }
                                    if (tech == 0) {
                                        if (seedType < 6) {
                                            System.out.println("Jaką ilość?");
                                            Scanner seedScan1 = new Scanner(System.in);
                                            int seedQuantity = seedScan1.nextInt();
                                            if (player.getCash() > (Goods.get(seedType + 4).getBuyPrice() * seedQuantity)) {
                                                Goods.get(seedType + 4).setQuantity(Goods.get(seedType + 4).getQuantity() + seedQuantity);
                                                player.setCash(player.getCash() - (Goods.get(seedType + 4).getBuyPrice() * seedQuantity));
                                            } else {
                                                System.out.println("Chyba cię na to nie stać kolego");
                                            }

                                        } else {
                                            break;
                                        }
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else if (shopWill == 2) {
                            System.out.println("Siemano " + player.getName() + ", jestem Mati, sprzedawca roślin. Chcesz coś kupić?:");
                            for (int seedShop = 1; seedShop > 0; seedShop++) {
                                System.out.println("Posiadasz aktualnie: " + player.getCash() + " monet");
                                System.out.println("rzeżucha - " + Goods.get(0).getBuyPrice() + " monet - 1");
                                System.out.println("ryż - " + Goods.get(1).getBuyPrice() + " monet - 2");
                                System.out.println("marchew - " + Goods.get(2).getBuyPrice() + " monet - 3");
                                System.out.println("ziemniak - " + Goods.get(3).getBuyPrice() + " monet - 4");
                                System.out.println("arbuz - " + Goods.get(4).getBuyPrice() + " monet - 5");
                                System.out.println("Odwiedź innego sprzedawcę - 9");
                                Scanner plantScan = new Scanner(System.in);
                                int plantType = plantScan.nextInt();
                                if (plantType > 0) {
                                    if (plantType < 6) {
                                        System.out.println("Jaką ilość?");
                                        Scanner plantScan1 = new Scanner(System.in);
                                        int plantQuantity = plantScan1.nextInt();
                                        if (player.getCash() > (CropsList.get(plantType - 1).getPrice() * plantQuantity * 1.5)) {
                                            for (int plantShop = 0; plantShop < plantQuantity; plantShop++) {
                                                Goods.get(plantType - 1).setQuantity(Goods.get(plantType - 1).getQuantity() + 1);
                                                player.setCash(player.getCash() - Goods.get(plantType - 1).getBuyPrice());
                                            }
                                        } else {
                                            System.out.println("Chyba cię na to nie stać kolego");
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else if (shopWill == 3) {
                            System.out.println("Dzień dobry " + player.getName() + " , nie chciałbyś kupić jakiegoś zwierzaka?:");
                            for (int animalShop = 1; animalShop > 0; animalShop++) {
                                System.out.println("Posiadasz aktualnie: " + player.getCash() + " monet");
                                if (pig == 1) {
                                    System.out.println("mała świnia - 10000 - 1");
                                }
                                if (cow == 1) {
                                    System.out.println("mała krowa - 40000 - 2");
                                }
                                System.out.println("odwiedź innego sprzedawcę - 9");
                                Scanner animalScan = new Scanner(System.in);
                                int animalType = animalScan.nextInt();
                                if (animalType == 1) {
                                    if (pig == 1) {
                                        System.out.println("Jaką ilość?");
                                        Scanner animalScan1 = new Scanner(System.in);
                                        int animalQuantity = animalScan1.nextInt();
                                        if (cowshed.getSize() - Animals.size() <= animalQuantity) {
                                            if (player.getCash() >= 10000 * animalQuantity) {
                                                for (int animalCounter = 0; animalCounter < animalQuantity; animalCounter++) {
                                                    Animal pig1 = (Animal) AnimalsList.get(0).clone();
                                                    Animals.add(pig1);
                                                    player.setCash(player.getCash() - 10000);
                                                }
                                            } else {
                                                System.out.println("Chyba cię na to nie stać kolego");
                                            }
                                        } else {
                                            System.out.println("Nie masz tyle miejsca w oborze");
                                        }
                                    }
                                }
                                if (animalType == 2) {
                                    if (cow == 1) {
                                        System.out.println("Jaką ilość?");
                                        Scanner animalScan1 = new Scanner(System.in);
                                        int animalQuantity = animalScan1.nextInt();
                                        if (cowshed.getSize() - Animals.size() <= animalQuantity) {
                                            if (player.getCash() >= 40000 * animalQuantity) {
                                                for (int animalCounter = 0; animalCounter < animalQuantity; animalCounter++) {
                                                    Animal cow1 = (Animal) AnimalsList.get(1).clone();
                                                    Animals.add(cow1);
                                                    player.setCash(player.getCash() - 40000);
                                                }
                                            } else {
                                                System.out.println("Chyba cię na to nie stać kolego");
                                            }
                                        } else {
                                            System.out.println("Nie masz tyle miejsca w oborze");
                                        }
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else if (shopWill == 4) {
                            System.out.println("Dzień dobry " + player.getName() + ". Nazywam się Gienio i sprzedaje nawozy. Chcesz kupić nawóz?:");
                            for (int count = 1; count > 0; count++) {
                                System.out.println("Posiadasz aktualnie: " + player.getCash() + " monet");
                                System.out.println("fosfor - 1000 monet - 1");
                                if (randapCount < 3) {
                                    System.out.println("randap - 10000 monet - pozostało " + (3 - randapCount) + "x sztuki - 2");
                                }
                                System.out.println("Aby odwiedzić innego sklepikarza - 9");
                                Scanner fertilizeScan = new Scanner(System.in);
                                int fertilizeType = fertilizeScan.nextInt();
                                if (fertilizeType == 1) {
                                    System.out.println("Jaką ilość?");
                                    Scanner fertilizeScan1 = new Scanner(System.in);
                                    int fertilizeQuantity = fertilizeScan1.nextInt();
                                    if (fertilizeQuantity * 1000 <= player.getCash()) {
                                        for (int fertilizeCounter = 0; fertilizeCounter < fertilizeQuantity; fertilizeCounter++) {
                                            Goods.get(11).setQuantity(Goods.get(11).getQuantity() + 1);
                                            player.setCash(player.getCash() - 1000);
                                        }
                                    } else {
                                        System.out.println("Chyba cię na to nie stać kolego");
                                    }
                                } else if (fertilizeType == 2) {
                                    if (randapCount < 3) {
                                        System.out.println("Jaką ilość?");
                                        Scanner fertilizeScan1 = new Scanner(System.in);
                                        int fertilizeQuantity = fertilizeScan1.nextInt();
                                        if (fertilizeQuantity <= 3 - randapCount) {
                                            if (fertilizeQuantity * 10000 <= player.getCash()) {
                                                for (int fertilizeCounter = 0; fertilizeCounter < fertilizeQuantity; fertilizeCounter++) {
                                                    Goods.get(12).setQuantity(Goods.get(12).getQuantity() + 1);
                                                    player.setCash(player.getCash() - 10000);
                                                    randapCount++;
                                                }
                                            } else {
                                                System.out.println("Chyba cię na to nie stać kolego");
                                            }
                                        } else {
                                            System.out.println("Nie mamy tyle randapu");
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else if (shopWill == 5) {
                            System.out.println("Posiadasz aktualnie: " + player.getCash() + " monet");
                            System.out.println("Hej " + player.getName() + ". Jestem Robert, chcesz kupić antybiotyki?:");
                            System.out.println("kup antybiotyki - 1");
                            System.out.println("odwiedź innego sprzedawcę - 9");
                            Scanner healScan = new Scanner(System.in);
                            int healType = healScan.nextInt();
                            if (healType == 1) {
                                System.out.println("Jaką ilość?");
                                Scanner healScan1 = new Scanner(System.in);
                                int healQuantity = healScan1.nextInt();
                                if (1000 * healQuantity <= player.getCash()) {
                                    for (int healCounter = 0; healCounter < healQuantity; healCounter++) {
                                        Goods.get(10).setQuantity(Goods.get(10).getQuantity() + 1);
                                        player.setCash(player.getCash() - 1000);
                                    }
                                } else {
                                    System.out.println("Chyba cię na to nie stać kolego");
                                }
                            }
                        } else if (shopWill == 6) {
                            System.out.println("Posiadasz aktualnie: " + player.getCash() + " monet");
                            System.out.println("Witam Pana " + player.getName() + ", jestem Franciszek - architekt, chcesz rozbudować swoją wieś?");
                            System.out.println("dodatkowe 2 miejsca na rośliny - " + fieldUpgrade + " monet - 1");
                            System.out.println("dodatkowe 1 miejsce na zwierzę - " + cowshedUpgrade + " monet - 2");
                            System.out.println("lepsza ziemia - lepsze zbiory - większe zyski z roślin - " + cropUpgrade + " monet - 3");
                            System.out.println("lepsza obora - lepsze mięsko - większe zyski ze zwierząt - " + animalUpgrade + " monet - 4");
                            System.out.println("odwiedź innego sprzedawcę - 9");
                            Scanner upgradeScan = new Scanner(System.in);
                            int upgradeType = upgradeScan.nextInt();
                            if (upgradeType == 1) {
                                if (fieldUpgrade <= player.getCash()) {
                                    field.setSize(field.getSize() + 2);
                                    player.setCash(player.getCash() - fieldUpgrade);
                                    fieldUpgrade = 2 * fieldUpgrade;
                                } else {
                                    System.out.println("Chyba cię na to nie stać kolego");
                                }
                            } else if (upgradeType == 2) {
                                if (cowshedUpgrade <= player.getCash()) {
                                    cowshed.setSize(cowshed.getSize() + 1);
                                    player.setCash(player.getCash() - cowshedUpgrade);
                                    cowshedUpgrade = 2 * cowshedUpgrade;
                                } else {
                                    System.out.println("Chyba cię na to nie stać kolego");
                                }
                            } else if (upgradeType == 3) {
                                if (cropUpgrade <= player.getCash()) {
                                    price = price +5;
                                    player.setCash(player.getCash() - cropUpgrade);
                                    cropUpgrade = cropUpgrade * 2;
                                    Goods.get(0).setSellPrice(price);
                                    Goods.get(1).setSellPrice(price*3);
                                    Goods.get(2).setSellPrice(price*5);
                                    Goods.get(3).setSellPrice(price*10);
                                    Goods.get(4).setSellPrice(price*25);
                                    Goods.get(0).setBuyPrice(price*2);
                                    Goods.get(1).setBuyPrice(price*6);
                                    Goods.get(2).setBuyPrice(price*10);
                                    Goods.get(3).setBuyPrice(price*20);
                                    Goods.get(4).setBuyPrice(price*50);
                                } else {
                                    System.out.println("Chyba cię na to nie stać kolego");
                                }
                            } else if (upgradeType == 4) {
                                if (animalUpgrade <= player.getCash()) {
                                    animalPrice = animalPrice + 5000;
                                    player.setCash(player.getCash() - animalUpgrade);
                                    animalUpgrade = animalUpgrade * 2;
                                    AnimalsList.get(0).setPrice(animalPrice*3);
                                    AnimalsList.get(1).setPrice(animalPrice*10);
                                } else {
                                    System.out.println("Chyba cię na to nie stać kolego");
                                }
                            }
                        } else if (shopWill == 7) {
                            System.out.println("Posiadasz aktualnie: " + player.getCash() + " monet");
                            System.out.println("Toż to sam " + player.getName() + "! Witam, witam, chcesz może coś odkryć?:");
                            if (carrot == 0) {
                                System.out.println("odkryj marchewkę - 100 monet - 1");
                            }
                            if (carrot == 1) {
                                if(potato==0) {
                                    System.out.println("odkryj ziemniaka - 1000 monet - 1");
                                }
                            }
                            if (potato == 1) {
                                if(watermelon==0) {
                                    System.out.println("odkryj arbuza - 10000 monet - 1");
                                }
                            }
                            if (potato == 1) {
                                if(pig==0) {
                                    if (watermelon == 0) {
                                        System.out.println("odkryj świnię - 20000 monet - 2");
                                    } else {
                                        System.out.println("odkryj świnię - 20000 monet - 1");
                                    }
                                }
                            }
                            if (pig == 1) {
                                if (watermelon == 1) {
                                    if (cow == 0) {
                                        System.out.println("odkryj krowę - 100000 monet -1");
                                    }
                                }
                            }
                            Scanner techScan = new Scanner(System.in);
                            int techType = techScan.nextInt();
                            if (techType == 1) {
                                if (carrot == 0) {
                                    if (player.getCash() >= 100) {
                                        carrot = 1;
                                        player.setCash(player.getCash() - 100);
                                    } else {
                                        System.out.println("Chyba cię na to nie stać kolego");
                                    }
                                } else if (potato == 0) {
                                    if (player.getCash() >= 1000) {
                                        potato = 1;
                                        player.setCash(player.getCash() - 1000);
                                    } else {
                                        System.out.println("Chyba cię na to nie stać kolego");
                                    }
                                } else if (watermelon == 0) {
                                    if (player.getCash() >= 10000) {
                                        watermelon = 1;
                                        player.setCash(player.getCash() - 10000);
                                    } else {
                                        System.out.println("Chyba cię na to nie stać kolego");
                                    }
                                } else if (pig == 0) {
                                    if (watermelon == 1) {
                                        if (player.getCash() >= 20000) {
                                            pig = 1;
                                            player.setCash(player.getCash() - 20000);
                                        } else {
                                            System.out.println("Chyba cię na to nie stać kolego");
                                        }
                                    }
                                } else if (cow == 0) {
                                    if (player.getCash() >= 100000) {
                                        cow = 1;
                                        player.setCash(player.getCash() - 100000);
                                    } else {
                                        System.out.println("Chyba cię na to nie stać kolego");
                                    }
                                }

                            } else if (techType == 2) {
                                if (carrot == 1) {
                                    if (potato == 1) {
                                        if (watermelon == 0) {
                                            if (pig == 0) {
                                                pig = 1;
                                                player.setCash(player.getCash() - 20000);
                                            } else {
                                                System.out.println("Chyba cię na to nie stać kolego");
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (shopWill == 8) {
                            System.out.println("Posiadasz aktualnie: " + player.getCash() + " monet");
                            System.out.println("Uszanowanko " + player.getName() + ", nazywam się Klaudia i jestem pośrednikiem pracy. Chcesz kogoś zatrudnić?:");
                            if (autoWater == 0) {
                                System.out.println("podlewacz roślin - 1250 monet - 1");
                            }
                            if (autoHarvest == 0) {
                                System.out.println("zbieracz roślin - 2500 monet - 2");
                            }
                            if (autoPlant == 0) {
                                System.out.println("zasadzacz roślin - 5000 monet - 3");
                            }
                            if (autoHunger == 0) {
                                System.out.println("karmiciel zwierząt - 10000 monet - 4");
                            }
                            if (autoIllness == 0) {
                                System.out.println("weterynarz - 25000 monet - 5");
                            }
                            if (autoMess == 0) {
                                System.out.println("sprzątacz obory - 50000 monet - 6");
                            }
                            if (autoSell==0) {
                                System.out.println("sprzedawca zwierząt - 100000 monet - 7");
                            }
                            if (autoBuy == 0) {
                                System.out.println("kupiec zwierząt - 200000 monet - 8");
                            }

                            System.out.println("odwiedź innego sprzedawcę - 7");
                            Scanner autoScan = new Scanner(System.in);
                            int autoWill = autoScan.nextInt();
                            if (autoWill == 1) {
                                if (autoWater == 0) {
                                    if (player.getCash() >= 1250) {
                                        autoWater = 1;
                                        player.setCash(player.getCash() - 1250);
                                    } else {
                                        System.out.println("Chyba cię na to nie stać kolego");
                                    }
                                }
                            } else if (autoWill == 2) {
                                if (autoHarvest == 0) {
                                    if (player.getCash() >= 2500) {
                                        autoHarvest = 1;
                                        player.setCash(player.getCash() - 2500);
                                    } else {
                                        System.out.println("Chyba cię na to nie stać kolego");
                                    }
                                }
                            } else if (autoWill == 3) {
                                if (autoPlant == 0) {
                                    if (player.getCash() >= 5000) {
                                        autoPlant = 1;
                                        player.setCash(player.getCash() - 5000);
                                    } else {
                                        System.out.println("Chyba cię na to nie stać kolego");
                                    }
                                }
                            } else if (autoWill == 4) {
                                if (autoHunger == 0) {
                                    if (player.getCash() >= 10000) {
                                        autoHunger = 1;
                                        player.setCash(player.getCash() - 10000);
                                    } else {
                                        System.out.println("Chyba cię na to nie stać kolego");
                                    }

                                } else if (autoWill == 5) {
                                    if (autoIllness == 0) {
                                        if (player.getCash() >= 25000) {
                                            autoIllness = 1;
                                            player.setCash(player.getCash() - 25000);
                                        } else {
                                            System.out.println("Chyba cię na to nie stać kolego");
                                        }
                                    }
                                } else if (autoWill == 6) {
                                    if (autoMess == 0) {
                                        if (player.getCash() >= 50000) {
                                            autoMess = 1;
                                            player.setCash(player.getCash() - 50000);
                                        } else {
                                            System.out.println("Chyba cię na to nie stać kolego");
                                        }
                                    }
                                } else if (autoWill == 7) {
                                    if (autoSell == 0){
                                        if(player.getCash() >= 100000){
                                            autoSell=1;
                                            player.setCash(player.getCash()-100000);
                                        }else{
                                            System.out.println("Chyba cię na to nie stać kolego");
                                        }
                                    }
                                } else if (autoWill == 8) {
                                    if (autoBuy == 0){
                                        if(player.getCash() >= 200000){
                                            autoBuy=1;
                                            player.setCash(player.getCash()-200000);
                                        }else{
                                            System.out.println("Chyba cię na to nie stać kolego");
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                } else if(will==4) {
                    System.out.println("Aktualnie posiadasz:");
                    System.out.println(Goods.get(0).getQuantity() +"x rzeżucha");
                    System.out.println(Goods.get(1).getQuantity() +"x ryż");
                    System.out.println(Goods.get(2).getQuantity() +"x marchew");
                    System.out.println(Goods.get(3).getQuantity() +"x ziemniak");
                    System.out.println(Goods.get(4).getQuantity() +"x arbuz");
                    System.out.println(Goods.get(5).getQuantity() +"x nasiono rzeżuchy");
                    System.out.println(Goods.get(6).getQuantity() +"x nasiono ryżu");
                    System.out.println(Goods.get(7).getQuantity() +"x nasiono marchwi");
                    System.out.println(Goods.get(8).getQuantity() +"x nasiono ziemniaka");
                    System.out.println(Goods.get(9).getQuantity() +"x nasiono arbuza");
                    System.out.println(Goods.get(10).getQuantity() +"x antybiotyk");
                    System.out.println(Goods.get(11).getQuantity() +"x fosfor");
                    System.out.println(Goods.get(12).getQuantity() +"x randap");
                    System.out.println("chcesz coś sprzedać? - 1");
                    System.out.println("powrót - 9");
                    Scanner storageScan = new Scanner(System.in);
                    int storageWill = storageScan.nextInt();
                    if(storageWill==1){
                        System.out.println("Co chcesz sprzedać?");
                        System.out.println("rzeżuche - "+Goods.get(0).getSellPrice()+ " monet - 1");
                        System.out.println("ryż - "+Goods.get(1).getSellPrice()+ " monet - 2");
                        System.out.println("marchew - "+Goods.get(2).getSellPrice()+ " monet - 3");
                        System.out.println("ziemniaka - "+Goods.get(3).getSellPrice()+ " monet - 4");
                        System.out.println("arbuza - "+Goods.get(4).getSellPrice()+ " monet - 5");
                        System.out.println("nasiono rzeżuchy - "+Goods.get(5).getSellPrice()+ " monet - 6");
                        System.out.println("nasiono ryżu - "+Goods.get(6).getSellPrice()+ " monet - 7");
                        System.out.println("nasiono marchwi - "+Goods.get(7).getSellPrice()+ " monet - 8");
                        System.out.println("nasiono ziemniaka - "+Goods.get(8).getSellPrice()+ " monet - 9");
                        System.out.println("nasiono arbuza - "+Goods.get(9).getSellPrice()+ " monet - 10");
                        System.out.println("antybiotyk - "+Goods.get(10).getSellPrice()+ " monet - 11");
                        System.out.println("fosfor - "+Goods.get(11).getSellPrice()+ " monet - 12");
                        System.out.println("randap - "+Goods.get(12).getSellPrice()+ " monet - 13");
                        System.out.println("powrót - 14");
                        Scanner sellScan = new Scanner(System.in);
                        int sellWill = sellScan.nextInt();
                        if(sellWill>0) {
                            if (sellWill < 14) {
                                System.out.println("Jaką ilość?");
                                Scanner sellScan1 = new Scanner(System.in);
                                int sellQuantity = sellScan1.nextInt();
                                if (Goods.get(sellWill - 1).getQuantity() >= sellQuantity) {
                                    Goods.get(sellWill - 1).setQuantity(Goods.get(sellWill - 1).getQuantity() - sellQuantity);
                                    player.setCash(player.getCash() + (sellQuantity * Goods.get(sellWill - 1).getSellPrice()));
                                }else{
                                    System.out.println("Nie masz tylu towarów");
                                }
                            }
                        }
                    }
                }else {
                    break;
                }
            }
        }
    }
}



