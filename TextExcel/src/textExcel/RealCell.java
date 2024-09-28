package textExcel;

public class RealCell implements Cell
{
	private String s;
	public RealCell(String s)
	{
		this.s = s;
	}
	public String abbreviatedCellText()
	{
		String z = s;
		z = String.format("%-10.10s", z);
		return z;

	}	
	public String fullCellText()
	{
		double x = Double.parseDouble(s);
		return x+"";
	}
	public double getDoubleValue()
	{
		double str1 = Double.parseDouble(s); 
		return str1;
	}
	public String getS()
	{
		return s;
	}
	
}
