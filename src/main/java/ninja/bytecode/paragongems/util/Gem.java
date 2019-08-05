package ninja.bytecode.paragongems.util;

public class Gem implements IGem
{
	private final String id;
	private final String name;

	public Gem(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	@Override
	public String getID()
	{
		return id;
	}

	@Override
	public String getName()
	{
		return name;
	}
}