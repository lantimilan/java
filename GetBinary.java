/**
 * GetBinary
 *
 * A class with main method that prints the binary representation
 * of arg[0].
 */
public class GetBinary {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java GetBinary <decimal integer>");
            System.exit(0);
        } else {
            System.out.println("Received " + args.length + " arguments.");
            System.out.println("The arguments are:");
            for(String arg : args) {
                System.out.println("\t" + arg);
            }
        }

        int number = 0;
        String binary = "";

        try {
            number = Integer.parseInt(args[0]);
        } catch (NumberFormatException ex) {
            System.out.println("Error: argument must be a base-10 integer.");
            System.exit(0);
        }

        do {
            switch (number & 1) {
                // inefficient, use StringBuilder
                case 0: binary = '0' + binary; break;
                case 1: binary = '1' + binary; break;
            }
            //System.out.print(number);
            //System.out.println(" " + binary);
            number >>>= 1;
        } while (number != 0);

        System.out.println("The binary representation of " + args[0] +
            " is " + binary + " length=" + Integer.toString(binary.length()));
    }
};
