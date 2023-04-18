public class GlassRecycleBin implements IBag<Garbage> {

    Garbage[] glassRecycleBin;
    int index = 0;
    int size;
    public GlassRecycleBin(int size){
        this.size = size;
        glassRecycleBin = new Garbage[size];
    }

    @Override
    public boolean add(Garbage newItem) {
        if (!isFull()) {
            glassRecycleBin[index] = newItem;
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
        Garbage removedGarbage = glassRecycleBin[index];
        for (int i = index; i < this.index; i++) {
            glassRecycleBin[i] = glassRecycleBin[i+1];
        }
        return removedGarbage;
    }

    @Override
    public Garbage remove() {
        Garbage removedGarbage = glassRecycleBin[this.index];
        glassRecycleBin[this.index] = null;
        return removedGarbage;
    }

    @Override
    public Garbage remove(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (glassRecycleBin[i] == item){
                Garbage removedGarbage = glassRecycleBin[i];
                for (int j = i; j < this.index; j++) {
                    glassRecycleBin[j] = glassRecycleBin[j+1];
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
            if (glassRecycleBin[i] == item){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Garbage item) {
        for (int i = 0; i < this.index; i++) {
            if (glassRecycleBin[i] == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayItems() {
        if (getItemCount() > 0) {
            System.out.printf("Glass Recycle Bin: %d | ", this.size);
            int amount = 1;
            for (int i = 0; i < getItemCount() - 1; i++) {
                if (glassRecycleBin[i].toString() == glassRecycleBin[i + 1].toString()) {
                    amount++;
                } else {
                    System.out.printf("%d %s, ", amount, glassRecycleBin[i].toString());
                    amount = 1;
                }
            }
            System.out.printf("%d %s \n", amount, glassRecycleBin[getItemCount() - 1].toString());
        }
        else {
            System.out.println("Glass Recycle Bin: 0");
        }
    }

    @Override
    public void dump() {
        for (int i = 0; i < this.index; i++) {
            glassRecycleBin[i] = null;
        }
    }

    @Override
    public boolean transferTo(IBag<Garbage> targetBag, Garbage item) {
        return false;
    }
}