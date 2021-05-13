package com.loohp.interactivechat.api.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.loohp.interactivechat.objectholders.ICPlayer;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;

/**
 * This event is called whenever the item placeholder is used. Only the itemStack
 * can be changed in this event, nothing else. Changing the BaseComponent or
 * Canceling the event will cause UnsupportedOperationException to be thrown.
 * @author LOOHP
 *
 */
public class ItemPlaceholderEvent extends PlaceholderEvent {

	private ItemStack itemStack;

	public ItemPlaceholderEvent(ICPlayer sender, Player receiver, BaseComponent baseComponent, long timeSent, ItemStack itemStack) {
		super(sender, receiver, baseComponent, timeSent);
		this.itemStack = itemStack;
	}

	public ItemStack getItemStack() {
		return itemStack;
	}

	public void setItemStack(ItemStack itemStack) {
		if (itemStack == null) {
			itemStack = new ItemStack(Material.AIR);
		}
		this.itemStack = itemStack;
	}

	@Override
	public BaseComponent getBaseComponent() {
		return ComponentSerializer.parse(ComponentSerializer.toString(baseComponent))[0];
	}

	@Override
	@Deprecated
	public void setBaseComponent(BaseComponent baseComponent) {
		throw new UnsupportedOperationException("Changing the BaseComponent in this event is not allowed");
	}

	@Override
	@Deprecated
	public void setCancelled(boolean cancel) {
		throw new UnsupportedOperationException("Cancelling this event is not allowed");
	}

}