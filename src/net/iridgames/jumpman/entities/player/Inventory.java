package net.iridgames.jumpman.entities.player;

import net.iridgames.jumpman.items.Item;

public class Inventory {

	private Item[] items = new Item[3];

	private int coins = 0;

	/** @return the items */
	public Item[] getItems() {
		return items;
	}

	/** @param item
	 *            the item to add to the inventory
	 * @return if it has been able to add item */

	public boolean addItem(Item item) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				return true;
			}
		}
		return false;
	}

	/** @return the coins */
	public int getCoins() {
		return coins;
	}

	/** @param coins
	 *            the coins to set */
	public void setCoins(int coins) {
		this.coins = coins;
	}

	/** @param coins
	 *            the coins to set */
	public void addCoins(int amount) {
		this.coins += amount;
	}

}
