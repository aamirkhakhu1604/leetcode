package org.example;

public class RotationalCipher {

    public static void main(String[] args) {
        //System.out.println(Character.getNumericValue('5'));
        System.out.println(rotationalCipher("Zebra-493", 3));
        System.out.println(rotationalCipher("I am studying Data Encryption", 4));
    }

    static String rotationalCipher(String input, int rotationFactor) {
        int ordA = 'A';
        int orda = 'a';
        StringBuilder output = new StringBuilder();
        for (char ch: input.toCharArray()) {
            if (Character.isDigit(ch)) {
                output.append((Character.getNumericValue(ch) + rotationFactor) % 10);
            } else if (Character.isAlphabetic(ch)) {
                if (Character.isUpperCase(ch)) {
                    int temp = (ch - ordA + rotationFactor) % 26;
                    output.append((char) (ordA + temp));
                } else {
                    int temp = (ch - orda + rotationFactor) % 26;
                    output.append((char) (orda + temp));
                }
            } else {
                output.append(ch);
            }
        }
        return output.toString();
    }
}
