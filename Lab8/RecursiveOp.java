public class RecursiveOp {
    public static int recursive_multiplication(int mulitplicand, int multiplier){
        if (mulitplicand == 1 || multiplier == 1)
        {
            return mulitplicand * multiplier;
        }
        else if (mulitplicand == 0 || multiplier == 0)
        {
            return 0;
        }
        else
        {
            return mulitplicand + recursive_multiplication(mulitplicand, multiplier - 1);
        }
    }
    public static int recursinve_division(int dividend, int divisor){
        int count = 0;
        if (dividend == divisor || divisor == dividend)
        {
            return 1;
        }
        else if (dividend == 0 || divisor == 0)
        {
            return -1;
        }
        else if (divisor > dividend)
        {
            return 0;
        }
        else
        {
            count++;
            return count + recursinve_division(dividend - divisor, divisor);
        }
    }
    public static int recursive_modulation(int information, int RF){
        if (information == 0 || RF == 0)
        {
            return -1;
        }
        else if (information < RF)
        {
            return information;
        }
        else
        {
            return recursive_modulation(information - RF, RF);
        }
    }
    public static String repeatNTimes(int num, String sentence){
        if (num == 0)
        {
            return " ";
        }
        else
        {

            return sentence +  repeatNTimes(num - 1, sentence);
        }
    }
    public static String removeAt(String sentence){
        return sentence.substring(1, sentence.length()-1);
    }
    public static boolean isReverse(String A, String B){
        if (A.length() != B.length())
        {
            return false;
        }
        else if (A == "" && B == "")
        {
            return true;
        }
        else if (A.length() == 1 && B.length() == 1)
        {
            return A.substring(0,0) == B.substring(0,0);
        }
        else
        {
            if (A.substring(0,0) == B.substring(B.length() - 1))
            {
                A = A.substring(1);
                B = B.substring(0, B.length() - 1);
                return isReverse(A, B);
            }
            else
            {
                return false;
            }
        }
    }

}
