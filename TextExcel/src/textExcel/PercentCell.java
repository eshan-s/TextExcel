package textExcel;

public class PercentCell extends RealCell
{

	public PercentCell(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	public double getDoubleValue()
	{
		return super.getDoubleValue();
	}
	public String fullCellText()
	{
		String z = getS().substring(0,getS().length()-1);
		Double x = Double.parseDouble(z); 
		x = x/100;
		String y = x+"";
		return y;

	}
	public String abbreviatedCellText()
	{
		int index = getS().indexOf(".");
		String z = getS().substring(0,index);
		z = z+"%";
		z = String.format("%-10.10s", z);
		return z;
	}
}
