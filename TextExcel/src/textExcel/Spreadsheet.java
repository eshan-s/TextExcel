package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell [][] spreadsheet;

	public Spreadsheet()
	{
		spreadsheet = new Cell [20][12];
		for (int i = 0;i<spreadsheet.length;i++)
		{
			for(int j = 0;j<spreadsheet[0].length;j++)
			{
			spreadsheet[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command)
	{
		String output="";
		String[] arr = command.split(" ",3);

		if(command.equals(""))
		{
			return "";
		}
		else if(command.toLowerCase().equals("clear"))
		{
			spreadsheet = new Cell [20][12];
			for (int i = 0;i<spreadsheet.length;i++)
			{
				for(int j = 0;j<spreadsheet[0].length;j++)
				{
				spreadsheet[i][j] = new EmptyCell();
				}
			}
			output = getGridText();
		}
		else if(arr.length==2)
		{
			//clear A1
			SpreadsheetLocation x = new SpreadsheetLocation(arr[1]);
			int r = x.getRow();
			int c = x.getCol();
			spreadsheet[r][c] = new EmptyCell();
			output = getGridText();

		}
		else if(arr.length==3)
		{
			//A1 = "red"
			SpreadsheetLocation x = new SpreadsheetLocation(arr[0]);
			int r = x.getRow();
			int c = x.getCol();
			if(arr[2].substring(arr[2].length()-1).equals("%"))
			{
				spreadsheet[r][c] = new PercentCell(arr[2]);
			}
			else if((arr[2].startsWith("\"")) && (arr[2].endsWith("\"")))
			{
				spreadsheet[r][c] = new TextCell(arr[2]);
			}
			else if((arr[2].startsWith("(")) && (arr[2].endsWith(")")))
			{
				spreadsheet[r][c] = new FormulaCell(arr[2], this);
			}
			else
				spreadsheet[r][c] = new ValueCell(arr[2]);
			output = getGridText();

		}
		
		else if(arr.length==1)
		{
			//A1
			SpreadsheetLocation y = new SpreadsheetLocation(arr[0]);
			int r = y.getRow();
			int c = y.getCol();
			output = spreadsheet[r][c].fullCellText();
			
		}
		return output;
		
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return spreadsheet[loc.getRow()][loc.getCol()];	
	}
	@Override
	public String getGridText()
	{
		String g = "   ";
		for(char i = 'A';i<'M';i++)
		{
			g+=String.format("|%-10s", i);
		}
			g+="|\n";
		for(int j = 1;j<21;j++)
		{
			g+=String.format("%-3s", j);
			for(int x = 1;x<=12;x++)
			{
				String c = spreadsheet[j-1][x-1].abbreviatedCellText();
				g+=String.format("|%-10s", c);
			}
			g+="|\n";
		}
		return g;
	}

}
