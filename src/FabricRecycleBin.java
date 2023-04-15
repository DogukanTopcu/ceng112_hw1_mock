public class FabricRecycleBin implements IBag<Garbage> {
    Garbage[] fabricRecycleBin;
    int index = 0;
    int size;
    public FabricRecycleBin(int size){
        this.size = size;
        fabricRecycleBin = new Garbage[size];
    }

    @Override
    public boolean add(Garbage newItem) {
        if (!isFull()) {
            fabricRecycleBin[index] = newItem;
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
        Garbage removedGarbage = fabricRecycleBin[index];
        for (int i = index; i < this.index; i++) {
            fabricRecycleBin[i] = fabricRecycleBin[i+1];
        }
        return removedGarbage;
    }

    @Override
    public Garbage remove() {
        Garbage removedGarbage = fabricRecycleBin[this.index];
        fabricRecycleBin[this.index] = null;
        return removedGarbage;
    }

    @Override
    public Garbage remove(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (fabricRecycleBin[i] == item){
                Garbage removedGarbage = fabricRecycleBin[i];
                for (int j = i; j < this.index; j++) {
                    fabricRecycleBin[j] = fabricRecycleBin[j+1];
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
            if (fabricRecycleBin[i] == item){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (fabricRecycleBin[i] == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayItems() {
        if (this.index > 0) {
            System.out.printf("Fabric Recycle Bin: %d | ", this.size);
            int amount = 1;
            for (int i = 0; i < this.index - 1; i++) {
                if (fabricRecycleBin[i].toString() == fabricRecycleBin[i + 1].toString()) {
                    amount++;
                } else {
                    System.out.printf("%d %s, ", amount, fabricRecycleBin[i].toString());
                    amount = 1;
                }
            }
            System.out.printf("%d %s \n", amount, fabricRecycleBin[this.index - 1].toString());
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