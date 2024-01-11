import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(info());
    }
    static String info() throws Exception{
        System.out.println("Введите значение для расчета:");
        Scanner scn = new Scanner(System.in);
        String sc = scn.nextLine().trim(); // удаление не нужных пробелов в начале и в конце строки
        return calc(sc);
    }
    public static String calc(String input) throws Exception {
        int numberOne;
        int numberTwo;
        String arithmeticExpression;
        String result;
        boolean isRoman;
        String[] aValues = input.split("[+\\-*/]");
        if (aValues.length != 2) throw new Exception("Должно быть два операнда");
        arithmeticExpression = detectOperation(input);
        if (arithmeticExpression == null) throw new Exception("Неподдерживаемая математическая операция");
        if (Converter.isRom(aValues[0]) && Converter.isRom(aValues[1])) {
            numberOne = Converter.convertToArab(aValues[0]);
            numberTwo = Converter.convertToArab(aValues[1]);
            isRoman = true;
        } else if (!Converter.isRom(aValues[0]) && !Converter.isRom(aValues[1])) {
            numberOne = Integer.parseInt(aValues[0]);
            numberTwo = Integer.parseInt(aValues[1]);
            isRoman = false;
        } else {
            throw new Exception("Числа должны быть в одном формате");
        }

        if (numberOne > 10 || numberTwo > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        int arabian = calc(numberOne, numberTwo, arithmeticExpression);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = Converter.convertToRom(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }

    static String detectOperation(String inputValue) {
        if (inputValue.contains("+")) {
            return "+";
        } else if (inputValue.contains("-")) {
            return "-";
        } else if (inputValue.contains("*")) {
            return "*";
        } else if (inputValue.contains("/")) {
            return "/";
        } else {
            return null;
        }
    }

    static int calc(int valueOne, int valueTwo, String arithmeticExpression) {

        if (arithmeticExpression.equals("+")) {
            return valueOne + valueTwo;
        } else if (arithmeticExpression.equals("-")) {
            return valueOne - valueTwo;
        } else if (arithmeticExpression.equals("*")) {
            return valueOne * valueTwo;
        } else {
            return valueOne / valueTwo;
        }
    }

}




