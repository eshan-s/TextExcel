package textExcel;

//checkpoint two
public class TextCell implements Cell
{
	private String s;
	public TextCell(String s)
	{
		this.s = s;
	}
	public String abbreviatedCellText()
	{
		String z = this.s.substring(1,s.length()-1);
		z = String.format("%-10.10s", z);
		return z;

	}	
	public String fullCellText()
	{
		return this.s;
	}
	
}
