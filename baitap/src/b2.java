
    import java.util.Scanner;

    public class b2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            StringBuilder letters = new StringBuilder();
            StringBuilder digits = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    digits.append(c);
                    if (i + 1 < s.length() && s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z') {
                        digits.append(' ');
                    }
                }
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    letters.append(c);
                    if (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                        letters.append(' ');
                    }
                }
            }

            System.out.println(letters);
            System.out.println(digits);
        }
    }

}
