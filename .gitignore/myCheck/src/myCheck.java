//package myCheck;

public class myCheck {

    static void FIND(int[] NUMBERS, int[] INDEX) {
        int POS, VALUE, VALUE_MIN;
        VALUE = 5000;
        VALUE_MIN = -5000;
        for (int i = 0; i < 5; i++) {
            for (POS = 0; POS < 5; POS++) {
                if ( (NUMBERS[POS] < VALUE) && (NUMBERS[POS]>VALUE_MIN) ) {
                    VALUE = NUMBERS[POS];
                    INDEX[i] = POS;
                }
            }
            VALUE_MIN = NUMBERS[INDEX[i]];
            VALUE = 5000;
        }
    }

    static void REPEATED(int[] ORDERED) {
        int temp, counter=0;
        temp=ORDERED[0];
        for (int i=0; i<ORDERED.length; i++) {
            if (temp==ORDERED[i]) {
                counter++;
            } else {
                IOQ.output(temp + " repeated " + counter + " times");
                counter=1;
                temp=ORDERED[i];
            }
        }
        IOQ.output(temp + " repeated " + counter + " times");
    }

    public static void main(String[] args) {
        int[] NUMBERS = { 27, 216, 15, 2, 56 };
        int[] INDEX = new int[5];
        int[] SORTED = new int[5];
        int[] ORDERED = {2, 3, 4, 4, 4, 4, 5, 5, 5, 6, 7, 8, 9, 9};
        REPEATED(ORDERED);
        FIND(NUMBERS, INDEX);
        for (int i = 0; i < 5; i++) {
            SORTED[i]=NUMBERS[INDEX[i]];
            IOQ.output(SORTED[i]);
        }
    }
}
