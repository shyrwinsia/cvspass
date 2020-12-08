import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CVSPass {
  private static final char[] LOOKUP_TABLE = {
      Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE,
      Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE,
      Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE,
      Character.MIN_VALUE, Character.MIN_VALUE, 'r', 'x', '5', 'O', 'm', 'H', 'l', 'F',
      '@', 'L', 'C', 't', 'J', 'D', 'W',
      'o', '4', 'K',
      'w', '1', '"', 'R', 'Q', '_', 'A', 'p', 'V', 'v',
      'n', 'z',
      'i', ')', '9', 'S', '+', '.', 'f', '(',
      'Y', '&', 'g', '-', '2', '*', '{', '[',
      '#', '}',
      '7', '6', 'B', '|', '~', ';', '/', '\\', 'G', 's',
      'N', 'X', 'k',
      'j', '8', 'y', 'u', 'h', 'e', 'd',
      'E', 'I', 'c', '?', '^', ']', '\'',
      '%', '=', '0',
      ':', 'q', ' ', 'Z', ',', 'b', '<', '3', '!', 'a',
      '>', 'M', 'T',
      'P', 'U' };

  public static String decode(String encodedText) {
    char[] decoded = new char[encodedText.length() + 1];
    decoded[0] = 'A';
    int counter = 1;
    byte b;
    int i;
    char[] arrayOfChar = encodedText.toCharArray();
    for (i = encodedText.toCharArray().length, b = 0; b < i; ) {
      char c = arrayOfChar[b];
      decoded[counter++] = LOOKUP_TABLE[c];
      b++;
    }
    return String.valueOf(decoded).substring(2, decoded.length);
  }

  public static void main(String[] args) throws IOException {
    String homeDir = System.getProperty("user.home");
    String separator = System.getProperty("file.separator");
    if (args.length != 0)
      homeDir = args[0];
    try {
      FileInputStream cvspass = new FileInputStream(String.valueOf(homeDir) + separator +
          ".cvspass");
      BufferedReader buff = new BufferedReader(new InputStreamReader(
            cvspass));
      String password = buff.readLine().split(" ")[2];
      String decoded = decode(password);
      System.out.println("Password: " + decoded);
      System.out.println("Press enter to exit.");
      BufferedReader b = new BufferedReader(new InputStreamReader(
            System.in));
      b.readLine();
    } catch (FileNotFoundException e) {
      System.err.println(".cvspass file not found in " + homeDir + ".");
      System.err
        .println("Usage: cvspass [optional: path to .cvspass]");
    }
  }
}
