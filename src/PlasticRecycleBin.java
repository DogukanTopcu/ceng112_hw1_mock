public class PlasticRecycleBin implements IBag<Garbage> {

    Garbage[] plasticRecycleBin;
    int index = 0;
    int size;
    public PlasticRecycleBin(int size){
        this.size = size;
        plasticRecycleBin = new Garbage[size];
    }

    @Override
    public boolean add(Garbage newItem) {
        if (!isFull()) {
            plasticRecycleBin[index] = newItem;
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
        Garbage removedGarbage = plasticRecycleBin[index];
        for (int i = index; i < this.index; i++) {
            plasticRecycleBin[i] = plasticRecycleBin[i+1];
        }
        return removedGarbage;
    }

    @Override
    public Garbage remove() {
        Garbage removedGarbage = plasticRecycleBin[this.index];
        plasticRecycleBin[this.index] = null;
        return removedGarbage;
    }

    @Override
    public Garbage remove(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (plasticRecycleBin[i] == item){
                Garbage removedGarbage = plasticRecycleBin[i];
                for (int j = i; j < this.index; j++) {
                    plasticRecycleBin[j] = plasticRecycleBin[j+1];
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
            if (plasticRecycleBin[i] == item){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (plasticRecycleBin[i] == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayItems() {
        if (getItemCount() > 0) {
            System.out.printf("Plastic Recycling Bin: %d | ", this.size);
            int amount = 1;
            for (int i = 0; i < getItemCount() - 1; i++) {
                if (plasticRecycleBin[i].toString() == plasticRecycleBin[i + 1].toString()) {
                    amount++;
                } else {
                    System.out.printf("%d %s, ", amount, plasticRecycleBin[i].toString());
                    amount = 1;
                }
            }
            System.out.printf("%d %s \n", amount, plasticRecycleBin[getItemCount() - 1].toString());
        }
        else {
            System.out.println("Plastic Recycle Bin: 0");
        }
    }

    @Override
    public void dump() {
        for (int i = 0; i < this.index; i++) {
            plasticRecycleBin[i] = null;
        }
    }

    @Override
    public boolean transferTo(IBag<Garbage> targetBag, Garbage item) {
        return false;
    }
}