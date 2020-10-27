import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Object array[][] = {{1, '2', 3, '4'}, {10, 12, 13, 'e'}, {21, 22, 23, 'f'}, {31, 32, 33, 'p'}};
        Object array2[][] = {{1, 2, '4'}, {41, 42, 43, "44"}, {51, 52, "53", "54"}, {61, 62, 63, "pip"}};

        try {
            System.out.println("Consider the sum of the numeric values of two arrays");
            System.out.println("First array:");
            System.out.println("\t the summ of digital values is "+ seeArray(array));
            System.out.println("Second array:");
            System.out.println("\t the summ of digital values isа "+ seeArray(array2));

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException  e) {
            e.printStackTrace();
        }

    }

    public static int seeArray(Object[][] array) throws MyArraySizeException, MyArrayDataException {
        try {
            if (array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4) {
                throw new MyArraySizeException();
            }
        }
        catch (MyArraySizeException e){
            System.out.println("\n\n\nThis is not array 4x4!\n");
        }

        int summ =0 , s=0;

        for ( int i=0; i<array.length; i++) {
            for (int w=0; w<array[i].length; w++) {
                try {
                    if (array[i][w] instanceof java.lang.Character) {
                        System.out.println(" it's CHAR !");
                        s = (Character) array[i][w] - '0';
                        if (s > 9) {throw new MyArrayDataException();}
                    }
                    else if (array[i][w] instanceof java.lang.String) {
                        System.out.println(" it's STRING !");
                        try {
                            s = Integer.valueOf((String) array[i][w]);
                        }
                        catch (NumberFormatException e){
                            throw new MyArrayDataException("it's char not digit", e);
                        }
                    }
                    else if (array[i][w] instanceof java.lang.Integer) {
                        s= (int) array[i][w];
                    }
                    else if (!isNumeric((String) array[i][w])){
                        throw new MyArrayDataException();
                    }
                    else {s= (int) array[i][w];}

                }
                catch (MyArrayDataException ex){
                    s = 0;
                    System.out.print("\t\t\ta value " + array[i][w] + " at array["+i+"]["+w+"] is not digit !\n");
                }

                System.out.println("   s = " + s);
                summ += s;
                System.out.println(" summm = " + summ);

            }

            }
        return summ;
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}