package ninja.bytecode.paragongems.util;

import ninja.bytecode.paragongems.base.ItemGem;

/**
 * Represents a gem which can be used to register items and blocks for each gem
 * type
 *
 * @author cyberpwn
 */
public interface IGem
{
	/**
	 * Get the id for this gem. For example "sapphire"
	 *
	 * @return the gem base id
	 */
	public String getID();

	/**
	 * Get the single word name of this gem type such as "Sapphire"
	 *
	 * @return the gem type name
	 */
	public String getName();
	
	public void setGemItem(ItemGem gem);
	
	public ItemGem getGemItem();
}
