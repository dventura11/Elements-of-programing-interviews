static int itos(String t){
    int tmp = 0;
    boolean neg = t.charAt(0) == '-';
    t = t.substring(1);
    boolean b = false;
    for(char c: t.toCharArray()){
        tmp = b ? (tmp * 10 + (c - '0')) : (c - '0');
        b = true;
    }
    return (neg) ? tmp*-1 : tmp;
}

static String stoi(int t){
    String tmp = "";
    boolean neg = t < 0;
    byte n;
    do{
        n = (byte) (t%10);
        t/=10;
        tmp = n + tmp;
    }while (t != 0);
    return tmp.equals("") ? "" : (neg) ? "-" + tmp : tmp;
}