public class BoardImpl implements Board
{
    private int[][] table;
    private int entry;
    public BoardImpl() 
    {
        table = new int[3][3];
        for (int i = 0; i < 3; i++) 
            for(int j = 0; j < 3; j++)
                table[i][j] = 0;
        entry = 0;
    }

    @Override
    public void addX(int positionX, int positionY) 
    {
        table[positionX][positionY] = 1;
        entry++;
    }

    @Override
    public void addO(int positionX, int positionY) 
    {
        table[positionX][positionY] = 2;
        entry++;
    }
    
    @Override
    public int getData(int positionX, int positionY) 
    {
        return table[positionX][positionY];
    }

    @Override
    public int numberOfEntries() 
    {
        return entry;
    }
}
