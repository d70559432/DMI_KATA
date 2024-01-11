import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(info());
    }
    static String info() throws Exception{
        System.out.println("Укажите данные:");
        Scanner scn = new Scanner(System.in);
        String sc = scn.nextLine().trim(); // удаление пробелов
        return calc(sc);
    }
    public static String calc(String input) throws Exception {
        int oneN; // первое число
        int twoN; // второе число
        String action; // действие
        String result; // результат
        boolean isRom; // логическое выражение на  римские числа
        String[] value = input.split("[+\\-*/]"); //регулярное выражение с экранированием, не понял, но сдул с youtube
        if (value.length != 2) throw new Exception("Error!");
        action = findAction(input);
        if (action == null) throw new Exception("Error!");
        if (Converter.isRom(value[0]) && Converter.isRom(value[1])) {
            oneN = Converter.convertToArab(value[0]);
            twoN = Converter.convertToArab(value[1]);
            isRom = true;
        } else if (!Converter.isRom(value[0]) && !Converter.isRom(value[1])) {
            oneN = Integer.parseInt(value[0]);
            twoN = Integer.parseInt(value[1]);
            isRom = false;
        } else {
            throw new Exception("Error!");
        }
        if (oneN > 10 || twoN > 10) {
            throw new Exception("Error!");
        }
        int arabian = calc(oneN, twoN, action);
        if (isRom) {
            if (arabian <= 0) {
                throw new Exception("Error!");
            }
            result = Converter.convertToRom(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }
    static String findAction(String inputV) {
        if (inputV.contains("+")) {
            return "+";
        } else if (inputV.contains("-")) {
            return "-";
        } else if (inputV.contains("*")) {
            return "*";
        } else if (inputV.contains("/")) {
            return "/";
        } else {
            return null;
        }
    }
    static int calc(int oneV, int twoV, String action) {
        if (action.equals("+")) {
            return oneV + twoV;
        } else if (action.equals("-")) {
            return oneV - twoV;
        } else if (action.equals("*")) {
            return oneV * twoV;
        } else if (action.equals("/")) {
            return oneV / twoV;
        } else {
            return oneV / twoV;
        }
    }
}