import java.sql.SQLOutput;

public class main{
    public static void main(String[] args) {
        String[][] arr = {
                {"11", "14", "32", "21"},
                {"31", "54", "54", "34"},
                {"74", "46", "84", "24"},
                {"10", "52", "56", "28"},
        };
        System.out.println(arr.length);

        try { System.out.println(isSquad(arr));
            System.out.println(sumStringArray(arr));
        } catch (MyArraySizeException e) {
            System.out.println("Передан не квадратный массив");
        } catch (MyArrayDataException e) {

        }

    }

    public static boolean isNumeric(String str) {
        try {
            int variable = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isSquad(String[][] arr) throws MyArraySizeException {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != arr[i].length) {
                throw new MyArraySizeException();
            }
        }
        return true;
    }


    static int sumStringArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int arraySum = 0;
        if (!isSquad(arr)){
            throw new MyArraySizeException();
        }
        for (int arrRow = 0; arrRow < arr.length; arrRow++) {

            for (int arrRange = 0; arrRange < arr[arrRow].length; arrRange++) {
                if (!isNumeric(arr[arrRow][arrRange]))
                    throw new MyArrayDataException(arrRow, arrRange);

                arraySum += Integer.parseInt(arr[arrRow][arrRange]);
            }
        }
        return arraySum;
    }

}
