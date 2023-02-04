import java.util.LinkedList;

public class DumbPasswords {

    public static void printDumbPasswords(int m, int n){
        if (m < 0 || m > 9) {
            System.out.println("m must be 0 - 9, input:" + m);
            return;
        } else if (n < 1 || n > 26) {
            System.out.println("n must be 1 - 26, input:" + n);
            return;
        }
        LinkedList<String> list = generate(m, n);
        for (String str: list) {
            System.out.print(str + " ");
        }
    }

    public static LinkedList<String> generate(int m, int n){
        LinkedList<String> res = new LinkedList<>();
        for(int i = 1; i <= m; i++){
            StringBuilder dummy = new StringBuilder(Integer.toString(i));
            for(int j = 1; j <= m+1; j++){
                if (dummy.length() == 2){
                    dummy.deleteCharAt(1);
                }
                if(j == m+1){
                    break;
                }else{
                    dummy.append(j);
                }

                for (int k = 1; k <= n+1; k++) {
                    if (dummy.length() == 3){
                        dummy.deleteCharAt(2);
                    }
                    if(k == n+1){
                        break;
                    }else{
                        dummy.append((char) (96 + k));
                    }

                    for (int p = 1; p <= n+1; p++) {
                        if (dummy.length() == 4) {
                            dummy.deleteCharAt(3);
                        }
                        if(p == n+1){
                            break;
                        }else {
                            dummy.append(String.valueOf((char) (96 + p)));
                        }

                        for (int o = 1; o <= m; o++){
                            dummy.append(String.valueOf(o));
                            if (o > i && o > j) {
                                res.add(dummy.toString());
                            }
                            dummy.deleteCharAt(4);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        printDumbPasswords(3,1);
    }
}
