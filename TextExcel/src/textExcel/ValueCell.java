package textExcel;

public class ValueCell extends RealCell
{

	public ValueCell(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	public double getDoubleValue()
	{
		return super.getDoubleValue();
	}
	public String fullCellText()
	{
		return getS();
	}
	public String abbreviatedCellText()
	{
		String z = getS();
		double x = Double.parseDouble(z);
		z = x+"";
		z = String.format("%-10.10s", z);
		return z;

	}	

}
