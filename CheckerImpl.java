public class CheckerImpl implements Checker 
{
    int[] R = {-1, -1, -1};
    int[] C = {-1, -1, -1};
    int[] D = {-1, -1};
    int[][] table = new int[3][3];
    int winner = 0;
    boolean winnerFlag = false;
    
    @Override
    public int check(Board b) 
    {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                table[i][j] = b.getData(i,j);
            }
        }
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if(table[i][j] == 0) {
                    R[i] = 0;
                    C[j] = 0;
                    if (i==j) {
                        if(i == 1) {
                            D[0] = 0;
                            D[1] = 0;
                        }
                        if(i == 0) {
                            D[0] = 0;
                        }
                        else {
                            D[1] = 0;
                        }
                    }
                }
                    
            }
        }
        for(int i=0; i<3; i++) {
            if(R[i] == -1) {
                int entry = table[i][0];
                boolean flag = true;
                for(int j=1; j<3; j++) {
                    if(table[i][j]!= entry) {
                        winner = 0;
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    winner = entry;
                    winnerFlag = true;
                    break;
                }
            }
        }
        if(winnerFlag) {
            return winner;
        }
        for(int i=0; i<3; i++) {
            if(C[i] == -1) {
                int entry = table[0][i];
                boolean flag = true;
                for(int j=1; j<3; j++) {
                    if(table[j][i]!= entry) {
                        winner = 0;
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    winner = entry;
                    winnerFlag = true;
                    break;
                }
            }
        }
        if(winnerFlag) {
            return winner;
        }
        
        
        if(D[0] == -1) {
            int entry = table[0][0];
            boolean flag = true;
            for(int j=1; j<3; j++) {
                if(table[j][j]!= entry) {
                    winner = 0;
                    flag = false;
                    break;
                }
             }
            if(flag) {
                winner = entry;
                winnerFlag = true;
            }
        }
        if(winnerFlag) {
            return winner;
        }
        if(D[1] == -1) {
            int entry = table[0][2];
            boolean flag = true;
            for(int j=1, i=1; j>=0 && i<3; j--, i++) {
                if(table[i][j]!= entry) {
                    winner = 0;
                    flag = false;
                    break;
                }
             }
            if(flag) {
                winner = entry;
                winnerFlag = true;
            }
            
        }
        if(winnerFlag) {
            return winner;
        }
        if(b.numberOfEntries() == 9) {
            return 3;
        }
        return winner;
    }
}
