public interface Board
{
    public void addX(int positionX, int positionY);
    public void addO(int positionX, int positionY);
    public int getData(int positionX, int positionY);
    public int numberOfEntries();
}
