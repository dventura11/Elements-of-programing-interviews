class Main {
    static int parseInt(String s) {

        // validate s to be a correct int
        
        int result = 0;
        for (int i = s.length() -1 , m = 1; i >= 0; i--) {
        
            if (s.charAt(i) == '-') {
                result *= -1;
                break;
            }
        
            result += (m * (s.charAt(i) - '0'));
            m *= 10;
        }
        
        return result;
    }

    // no sirve con 0
    static String intToString(int n) {

           char [] result = new char[32 /* ? */];
           int pos = result.length - 1;
            
           boolean neg = false;
           if (n < 0) {
               neg = true;
               n *= -1;
           }
           
           while (n > 0) {
                result [pos] = (char) ((n % 10) + '0');
                pos--;
                n /= 10;
           }
           
           if (neg) result[pos] = '-';
           
           return new String (result);
    }
}
