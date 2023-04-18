public class OrganicRecycleBin implements IBag<Garbage> {
    Garbage[] organicRecycleBin;
    int index = 0;
    int size;
    public OrganicRecycleBin(int size){
        this.size = size;
        organicRecycleBin = new Garbage[size];
    }

    @Override
    public boolean add(Garbage newItem) {
        if (!isFull()) {
            organicRecycleBin[index] = newItem;
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
        Garbage removedGarbage = organicRecycleBin[index];
        for (int i = index; i < this.index; i++) {
            organicRecycleBin[i] = organicRecycleBin[i+1];
        }
        return removedGarbage;
    }

    @Override
    public Garbage remove() {
        Garbage removedGarbage = organicRecycleBin[this.index];
        organicRecycleBin[this.index] = null;
        return removedGarbage;
    }

    @Override
    public Garbage remove(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (organicRecycleBin[i] == item){
                Garbage removedGarbage = organicRecycleBin[i];
                for (int j = i; j < this.index; j++) {
                    organicRecycleBin[j] = organicRecycleBin[j+1];
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
            if (organicRecycleBin[i] == item){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (organicRecycleBin[i] == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayItems() {
        if (getItemCount() > 0) {
            System.out.printf("Organic Recycling Bin: %d | ", this.size);
            int amount = 1;
            for (int i = 0; i < getItemCount() - 1; i++) {
                if (organicRecycleBin[i].toString() == organicRecycleBin[i + 1].toString()) {
                    amount++;
                } else {
                    System.out.printf("%d %s, ", amount, organicRecycleBin[i].toString());
                    amount = 1;
                }
            }
            System.out.printf("%d %s \n", amount, organicRecycleBin[getItemCount() - 1].toString());
        }
        else {
            System.out.println("Organic Recycle Bin: 0");
        }
    }

    @Override
    public void dump() {
        for (int i = 0; i < this.index; i++) {
            organicRecycleBin[i] = null;
        }
    }

    @Override
    public boolean transferTo(IBag<Garbage> targetBag, Garbage item) {
        return false;
    }
}
