import java.util.Random;

public class TrashCan implements IBag<Garbage> {

    public Garbage[] trashCan = new Garbage[450];
    public int index = 0;

    Random rand = new Random();
    int[] sizes = {5, 10, 15};


    // sizes[rand.nextInt(3)] : Select the one of the three option.
    PlasticRecycleBin plasticRecycleBin = new PlasticRecycleBin(sizes[rand.nextInt(3)]);
    PaperRecycleBin paperRecycleBin = new PaperRecycleBin(sizes[rand.nextInt(3)]);
    GlassRecycleBin glassRecycleBin = new GlassRecycleBin(sizes[rand.nextInt(3)]);
    FabricRecycleBin fabricRecycleBin = new FabricRecycleBin(sizes[rand.nextInt(3)]);
    MetalRecycleBin metalRecycleBin = new MetalRecycleBin(sizes[rand.nextInt(3)]);
    OrganicRecycleBin organicRecycleBin = new OrganicRecycleBin(sizes[rand.nextInt(3)]);


    public boolean separate(Garbage item){
        switch (item.garbageType){
            case "plastic":
                if (!plasticRecycleBin.isFull()) {
                    transferTo(plasticRecycleBin, item);
                    return true;
                }
                break;
            case "paper":
                if (!paperRecycleBin.isFull()) {
                    transferTo(paperRecycleBin, item);
                    return true;
                }
                break;
            case "glass":
                if (!glassRecycleBin.isFull()) {
                    transferTo(glassRecycleBin, item);
                    return true;
                }
                break;
            case "fabric":
                if (!fabricRecycleBin.isFull()) {
                    transferTo(fabricRecycleBin, item);
                    return true;
                }
                break;
            case "metal":
                if (!metalRecycleBin.isFull()) {
                    transferTo(metalRecycleBin, item);
                    return true;
                }
                break;
            case "organic":
                if (!organicRecycleBin.isFull()) {
                    transferTo(organicRecycleBin, item);
                    return true;
                }
                break;
            default:
                return false;
        }

        return false;
    }

    @Override
    public boolean add(Garbage newItem) {
        if (!isFull()) {
            trashCan[index] = newItem;
            index++;

            return true;
        }
        else {return false;}
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public boolean isFull() {
        return index == 450;
    }

    @Override
    public Garbage removeByIndex(int index) {
        Garbage removedGarbage = trashCan[index];
        for (int i = index; i < this.index; i++) {
            trashCan[i] = trashCan[i+1];
        }
        return removedGarbage;
    }

    @Override
    public Garbage remove() {
        Garbage removedGarbage = trashCan[this.index];
        trashCan[this.index] = null;
        return removedGarbage;
    }

    @Override
    public Garbage remove(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (trashCan[i] == item){
                Garbage removedGarbage = trashCan[i];
                for (int j = i; j < this.index - 1; j++) {
                    trashCan[j] = trashCan[j+1];
                }
                return removedGarbage;
            }
        }
        return null;
    }

    public int getItemCount(){
        return this.index;
    }

    @Override
    public int getIndexOf(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (trashCan[i] == item){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (trashCan[i] == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayItems() {
        if (this.index > 0) {
            System.out.printf("The Trash Can: %d | ", this.index);
            int amount = 1;
            for (int i = 0; i < this.index - 1; i++) {
                if (trashCan[i].toString() == trashCan[i+1].toString()){
                    amount++;
                }
                else {
                    System.out.printf("%d %s, ", amount, trashCan[i].toString());
                    amount = 1;
                }
            }
            System.out.printf("%d %s \n", amount, trashCan[this.index - 1].toString());
        }
    }

    @Override
    public void dump() {
        int i = 0;
        while (i < index) {
            if (separate(trashCan[i])){
                i = 0;
            }
            else {
                i++;
            }
        }

        plasticRecycleBin.displayItems();
        organicRecycleBin.displayItems();
        fabricRecycleBin.displayItems();
        paperRecycleBin.displayItems();
        metalRecycleBin.displayItems();
        glassRecycleBin.displayItems();

        displayItems();
    }

    @Override
    public boolean transferTo(IBag<Garbage> targetBag, Garbage item) {
        targetBag.add(item);
        remove(item);
        index--;

        return false;
    }
}

