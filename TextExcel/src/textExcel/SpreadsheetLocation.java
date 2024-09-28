package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	//define field
	private String cellName;
	
	public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	this.cellName = cellName.toUpperCase();
    }
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return Integer.parseInt(cellName.substring(1))-1;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
    	//int col = (int)cellName.charAt(0)-65;
    	int col = Character.toUpperCase(cellName.charAt(0)) - 'A';
        return col;
    }
    @Override
    public String toString() {
    	return cellName;
    }
    

}
