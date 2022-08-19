public class Main {

    static int factorial(int n) {

        int res = 1;

        for(int i = 1; i <= n; ++i) {
            res = res * i;
        }

        return res;
    }

    static boolean is_prime(int num) {

        boolean is_p = true;

        for(int i = 2; i < num; ++i) {
            if(num % i == 0) {
                is_p = false;
                break;
            }
        }

        return is_p;
    }

    static int pow(int a, int b) {
        if (b == 0)
            return 1;

        if (b == 1)
            return a;

        if (b % 2 == 0)
            return pow ( a * a, b / 2);
        else
            return a * pow ( a * a, b / 2);
    }

    static int[] compute_pp(int num) {

        int[] exp_arr = new int[num + 1];

        for(int i = 0; i < num + 1; ++i) {
            exp_arr[i] = 0;
        }

        for(int i = 2; i <= num; ++i) {
            if(is_prime(i)) {
                int val = pow(i, 0);
                int exp = 0;
                while(val <= num) {
                    val = pow(i, exp);
                    if(num % val == 0) {
                        exp_arr[i] = exp;
                    }
                    exp++;
                }
            }
        }

        return exp_arr;
    }

    static void print_pp(int[] exp_arr, int num) {

        for(int i = 2; i < num; ++i) {
            if(exp_arr[i] != 0) {
                System.out.println(i + ", " + exp_arr[i]);
            }
        }

        int res = 1;
        for(int i = 2; i < num; ++i) {
            if(exp_arr[i] != 0) {
                res = res * pow(i, exp_arr[i]);
            }
        }

        System.out.println("prime product verification: " + res);
    }



    public static void main(String[] args) {

        // Number to factorize
        int num = factorial(6);

        // Compute prime factor
        int[] exp_arr = compute_pp(num);

        // Print prime factor
        print_pp(exp_arr, num);

    }
}
