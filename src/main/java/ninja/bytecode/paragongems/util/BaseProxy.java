package ninja.bytecode.paragongems.util;

import org.apache.logging.log4j.Logger;

import ninja.bytecode.paragongems.ParagonGems;

public class BaseProxy
{
	public void i(String info)
	{
		getLogger().info(info);
	}

	public void v(String verbose)
	{
		getLogger().debug(verbose);
	}

	public void w(String warn)
	{
		getLogger().warn(warn);
	}

	public void f(String fatal)
	{
		getLogger().fatal(fatal);
	}

	public Logger getLogger()
	{
		return ParagonGems.logger;
	}
}
