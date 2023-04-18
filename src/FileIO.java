import java.io.*;
import java.util.Scanner;

public class FileIO {

    File garbageFile;

    // Constructor. Takes the file path as a parameter.
    public FileIO(String pathName) {
        garbageFile = new File(pathName);
    }


    TrashCan trashCan = new TrashCan();

    // Read File Function. Returns "trashCan" object.
    public IBag<Garbage> readTrashCan() {
        try {
            Scanner garbage = new Scanner(garbageFile);
            while (garbage.hasNextLine()) {
                String line = garbage.nextLine();
                String[] splitLine = line.split(",");

                for (int i = 0; i < Integer.parseInt(splitLine[2].split(" ")[0]); i++) {
                    Garbage newGarbage = new Garbage(splitLine[0], splitLine[1]);
                    if (!trashCan.isFull()) {
                        trashCan.add(newGarbage);
                    }
                }

            }

            garbage.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return trashCan;
    }

    // Update the garbage.txt file.
    public boolean updateTrashCan() {
        try {
            FileWriter garbage = new FileWriter(garbageFile);
            BufferedWriter writer = new BufferedWriter(garbage);

            int amount = 1;
            boolean isFirstLine = true;
            for (int i = 0; i < trashCan.index; i++) {

                String write = "";
                write += trashCan.trashCan[i].toString() + "," + trashCan.trashCan[i].garbageType + ",";
                if (trashCan.trashCan[i].toString() == trashCan.trashCan[i+1].toString()) {
                    amount++;

                    // For the last line
                    if (trashCan.index - 1 == i){
                        writer.newLine();
                        write += amount - 1;
                        writer.write(write);
                    }
                }
                else {
                    if (!isFirstLine) writer.newLine();
                    isFirstLine = false;
                    write += amount;
                    writer.write(write);
                    amount = 1;
                }
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
