public class PaperRecycleBin implements IBag<Garbage> {

    Garbage[] paperRecycleBin;
    int index = 0;
    int size;
    public PaperRecycleBin(int size){
        this.size = size;
        paperRecycleBin = new Garbage[size];
    }

    @Override
    public boolean add(Garbage newItem) {
        if (!isFull()) {
            paperRecycleBin[index] = newItem;
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
        Garbage removedGarbage = paperRecycleBin[index];
        for (int i = index; i < this.index; i++) {
            paperRecycleBin[i] = paperRecycleBin[i+1];
        }
        return removedGarbage;
    }

    @Override
    public Garbage remove() {
        Garbage removedGarbage = paperRecycleBin[this.index];
        paperRecycleBin[this.index] = null;
        return removedGarbage;
    }

    @Override
    public Garbage remove(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (paperRecycleBin[i] == item){
                Garbage removedGarbage = paperRecycleBin[i];
                for (int j = i; j < this.index; j++) {
                    paperRecycleBin[j] = paperRecycleBin[j+1];
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
            if (paperRecycleBin[i] == item){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (paperRecycleBin[i] == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayItems() {
        if (getItemCount() > 0) {
            System.out.printf("Paper Recycle Bin: %d | ", this.size);
            int amount = 1;
            for (int i = 0; i < getItemCount() - 1; i++) {
                if (paperRecycleBin[i].toString() == paperRecycleBin[i + 1].toString()) {
                    amount++;
                } else {
                    System.out.printf("%d %s, ", amount, paperRecycleBin[i].toString());
                    amount = 1;
                }
            }
            System.out.printf("%d %s \n", amount, paperRecycleBin[getItemCount() - 1].toString());
        }
        else {
            System.out.println("Paper Recycle Bin: 0");
        }
    }

    @Override
    public void dump() {
        for (int i = 0; i < this.index; i++) {
            paperRecycleBin[i] = null;
        }
    }

    @Override
    public boolean transferTo(IBag<Garbage> targetBag, Garbage item) {
        return false;
    }
}