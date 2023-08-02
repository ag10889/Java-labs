public class Assignment5 {
    public static String reverse(String og) {
        char[] sentence = og.toCharArray();
        if (sentence.length == 0) {
            String x = new String(sentence);
            return x;
        } else {
            return reverse(og.substring(og.length() - 1, 0));
        }
    }

    public static String helper(String v) {
        for (int i = 0; i < v.length(); i++) {
            if (v.charAt(i) == 'v') {
                v = v.replace('v', '^');
            } else {
                v = v.replace('^', 'v');
            }
        }
        return v;
    }

    public static String paperFold(int n) {
        if (n <= 0) {
            return "";
        }
        if (n == 1) {
            return "v";
        } else {
            String previousPattern = paperFold(n - 1);
            return previousPattern + " " + helper(reverse(previousPattern));
        }
    }

    public static void Main(String[] args) {
        for (int i = 1; i < 10; i++) {
            String fold_string = paperFold(i);
            System.out.println("For " + i + " folds we get: " + fold_string + "\n");
        }
    }
}
