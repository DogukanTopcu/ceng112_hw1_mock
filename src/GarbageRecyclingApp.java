public class GarbageRecyclingApp {
    public static void main(String[] args) {

        TrashCan trashCan;

        // File operations, enter the path of garbage.txt file as a parameter.
        FileIO file = new FileIO("C:\\Users\\doguk\\Desktop\\Iztech\\2022-2023 Spring Term\\Ceng112\\Homeworks\\Homework 1\\hw1_mock\\src\\garbage.txt");
        trashCan = (TrashCan) file.readTrashCan();


        // Display Trash Can before separation.
        trashCan.displayItems();

        // Separate operations
        int i = 0;
        while (i < trashCan.getItemCount()) {
            if (trashCan.separate(trashCan.trashCan[i]) && trashCan.getIndexOf(trashCan.trashCan[i]) != -1){
                // If the separate is done and returns true, the value of i will be equal to the index of the separated item in the trashCan.
                i = trashCan.getIndexOf(trashCan.trashCan[i]);
            }
            else {
                // If the separate returns false, the value of i will be increase.
                i++;
            }
        }


        // Outputs
        trashCan.plasticRecycleBin.displayItems();
        trashCan.organicRecycleBin.displayItems();
        trashCan.fabricRecycleBin.displayItems();
        trashCan.paperRecycleBin.displayItems();
        trashCan.metalRecycleBin.displayItems();
        trashCan.glassRecycleBin.displayItems();
        trashCan.displayItems();


        // Update file operations
        file.updateTrashCan();
    }
}