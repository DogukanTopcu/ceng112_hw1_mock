public class MetalRecycleBin implements IBag<Garbage> {

    Garbage[] metalRecycleBin;
    int index = 0;
    int size;
    public MetalRecycleBin(int size){
        this.size = size;
        metalRecycleBin = new Garbage[size];
    }

    @Override
    public boolean add(Garbage newItem) {
        if (!isFull()) {
            metalRecycleBin[index] = newItem;
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
        return index == this.size;
    }

    @Override
    public Garbage removeByIndex(int index) {
        Garbage removedGarbage = metalRecycleBin[index];
        for (int i = index; i < this.index; i++) {
            metalRecycleBin[i] = metalRecycleBin[i+1];
        }
        return removedGarbage;
    }

    @Override
    public Garbage remove() {
        Garbage removedGarbage = metalRecycleBin[this.index];
        metalRecycleBin[this.index] = null;
        return removedGarbage;
    }

    @Override
    public Garbage remove(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (metalRecycleBin[i] == item){
                Garbage removedGarbage = metalRecycleBin[i];
                for (int j = i; j < this.index; j++) {
                    metalRecycleBin[j] = metalRecycleBin[j+1];
                }
                return removedGarbage;
            }
        }
        return null;
    }

    @Override
    public int getIndexOf(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (metalRecycleBin[i] == item){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (metalRecycleBin[i] == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayItems() {
        if (this.index > 0) {
            System.out.printf("Metal Recycling Bin: %d | ", this.size);
            int amount = 1;
            for (int i = 0; i < this.index - 1; i++) {
                if (metalRecycleBin[i].toString() == metalRecycleBin[i + 1].toString()) {
                    amount++;
                } else {
                    System.out.printf("%d %s, ", amount, metalRecycleBin[i].toString());
                    amount = 1;
                }
            }
            System.out.printf("%d %s \n", amount, metalRecycleBin[this.index - 1].toString());
        }
    }

    @Override
    public void dump() {

    }

    @Override
    public boolean transferTo(IBag<Garbage> targetBag, Garbage item) {
        return false;
    }
}