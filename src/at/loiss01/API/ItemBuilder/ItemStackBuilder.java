/*
 * Copyright (c) 2017, Alois Stöckl, All Rights Reserved
 */

package at.loiss01.API.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder{

    ItemStack itm;
    ItemMeta itemMeta;

    public ItemStackBuilder(Material mat) {
        itm = new ItemStack(mat);
        itemMeta = itm.getItemMeta();
    }

    public ItemStackBuilder setName(String Name){
        itemMeta.setDisplayName(Name);
        return this;
    }

    public ItemStackBuilder setAmount(int amount){
        itm.setAmount(amount);
        return this;
    }

    public ItemStackBuilder setLore(String... lore){
        for (String s : lore) {
            setLore(s);
        }
        return this;
    }

    public ItemStackBuilder setLore(String lore){
        List<String> itmlore = itemMeta.getLore();
        if (itmlore == null) {
            itmlore = new ArrayList<>();
        }
        itmlore.add(lore);
        itemMeta.setLore(itmlore);
        return this;
    }

    public ItemStackBuilder setData(int data){

        return this;
    }

    public ItemStackBuilder setEnchantment(Enchantment e, int level){
        itm.addUnsafeEnchantment(e, level);
        return this;
    }

    public ItemStackBuilder setEnchantment(Enchantment e){
        itm.addUnsafeEnchantment(e, 1);
        return this;
    }

    public ItemStack build(){
        itm.setItemMeta(itemMeta);
        return itm;
    }


}
