public class MyArrayDataException extends NumberFormatException {
    int arrRow;
    int arrRange;
    public MyArrayDataException (int arrRow, int arrRange){
        this.arrRow = arrRow;
        this.arrRange = arrRange;
        System.out.println("Значение невозможно преобразовать в число!" +(arrRow +1) + (arrRange + 1));
    }
}
