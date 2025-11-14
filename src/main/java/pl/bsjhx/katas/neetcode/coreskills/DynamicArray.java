package pl.bsjhx.katas.neetcode.coreskills;

class DynamicArray {

    private int lastElementIndex;

    private int[] arr;

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.lastElementIndex = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (arr.length == lastElementIndex) {
            resize();
        }
        arr[lastElementIndex] = n;
        lastElementIndex++;
    }

    public int popback() {
        if (lastElementIndex < 0) {
            throw new RuntimeException("Array is empty");
        }
        lastElementIndex--;
        return arr[lastElementIndex];
    }

    private void resize() {
        int[] temp = new int[arr.length * 2];
        if (lastElementIndex >= 0) {
            System.arraycopy(arr, 0, temp, 0, lastElementIndex);
        }

        arr = temp;
    }

    public int getSize() {
        return lastElementIndex;
    }

    public int getCapacity() {
        return arr.length;
    }
}
