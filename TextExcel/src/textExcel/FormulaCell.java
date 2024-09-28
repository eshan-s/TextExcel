package textExcel;

public class FormulaCell extends RealCell
{
	private Spreadsheet sheet;
	public FormulaCell(String s, Spreadsheet sheet) 
	{
		super(s);
		this.sheet = sheet;
		// TODO Auto-generated constructor stub
	}
	public double getDoubleValue()
	{
		double finalval = 0;
		//stores length of string with parentheses
		int strlen = getS().length();
		//str stores string without parentheses
		String str = getS().substring(2,strlen-2);
		//new length of string without parentheses
		String[] arr = str.split(" ",strlen);
				
		if(arr.length == 1)
		{
			finalval = Double.parseDouble(arr[0]);
		}
		if(arr[0].toLowerCase().equals("sum"))
		{
			double sum = 0;
			String cell1 = arr[1].substring(0,arr[1].indexOf("-"));
			String cell2 = arr[1].substring(arr[1].indexOf("-")+1,arr[1].length());
			Location start = new SpreadsheetLocation(cell1);
			Location end = new SpreadsheetLocation(cell2);
			
			for(int i = start.getCol(); i<= end.getCol();i++)
			{
				for(int j = start.getRow(); j<= end.getRow(); j++)
				{
					String Location = (char)(i + 65) + "" + (j + 1);
					sum = sum + getCellValue(Location);
				}
			}
			return sum;
		}
		else if(arr[0].toLowerCase().equals("avg"))
		{
			double sum = 0;
			int count = 0;
			String cell1 = arr[1].substring(0,arr[1].indexOf("-"));
			String cell2 = arr[1].substring(arr[1].indexOf("-")+1,arr[1].length());
			Location start = new SpreadsheetLocation(cell1);
			Location end = new SpreadsheetLocation(cell2);
			
			for(int i = start.getCol(); i<= end.getCol();i++)
			{
				for(int j = start.getRow(); j<= end.getRow(); j++)
				{
					String Location = (char)(i + 65) + "" + (j + 1);
					sum = sum + getCellValue(Location);
					count++;
				}
			}
			sum = sum/count;
			return sum;
		}
		else
			for(int i = 0;i<arr.length;i++)
			{
				if(isCellAddress(arr[i]) || i == 0) {					
					finalval = getCellValue(arr[i]);
				}
				else {
					if(arr[i].equals("+")) {				
						finalval = add(finalval, getCellValue(arr[i+1]));
					}
					else if(arr[i].equals("-")) {
						finalval = sub(finalval, getCellValue(arr[i+1]));
					}
					else if(arr[i].equals("*")) {
						finalval = mult(finalval, getCellValue(arr[i+1]));
					}
					else if(arr[i].equals("/")) {
						finalval = div(finalval, getCellValue(arr[i+1]));
					}
					i++;
				}
			}
			return finalval;
		}
	public double add(double val1, double val2)
	{
		double addsum = val1 + val2;
		return addsum;
	}
	public double sub(double val1, double val2)
	{
		double subsum = val1 - val2;
		return subsum;
	}
	public double mult(double val1, double val2)
	{
		double multsum = val1 * val2;
		return multsum;
	}
	public double div(double val1, double val2)
	{
		double divsum = val1 / val2;
		return divsum;
	}
	public double getCellValue(String str)
	{
		if(isCellAddress(str)) {
			Location c1 = new SpreadsheetLocation(str);
			RealCell value = (RealCell) (sheet.getCell(c1));
			double val1 = value.getDoubleValue();
			return val1;
		}
		else
			return Double.parseDouble(str);
	}
	public boolean isCellAddress(String s)
	{
		return (Character.isLetter(s.charAt(0)) && !s.equals("avg") && !s.equals("sum"));
	};
	public String fullCellText()
	{
		return getS();
	}
	public String abbreviatedCellText()
	{
		String z = getDoubleValue()+ "" ;
		z = String.format("%-10.10s", z);
		return z;

	}	

}
