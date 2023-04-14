public class GarbageRecyclingApp {
    public static void main(String[] args) {

        IBag<Garbage> trashCan;

        FileIO garbage = new FileIO("C:\\Users\\doguk\\Desktop\\Iztech\\2022-2023 Spring Term\\Ceng112\\Homeworks\\Homework 1\\hw1_mock\\src\\garbage.txt");
        trashCan = garbage.readTrashCan();

        trashCan.displayItems();
        trashCan.dump();
        garbage.updateTrashCan();
    }
}