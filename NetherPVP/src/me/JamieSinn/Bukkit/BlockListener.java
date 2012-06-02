package me.JamieSinn.Bukkit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener
{

	public void generateSlowCube(Location point, int length){  
		World world = point.getWorld();
		int x_start = point.getBlockX();    
		int y_start = point.getBlockY();     
		int z_start = point.getBlockZ();
	 
		int x_length = x_start + length;    
		int y_length = y_start + length;
		int z_length = z_start + length;
	 
		for(int x_operate = x_start; x_operate <= x_length; x_operate++)
		{ 
			for(int y_operate = y_start; y_operate <= y_length; y_operate++)
			{
				for(int z_operate = z_start; z_operate <= z_length; z_operate++)
				{
	 
					Block blockToChange = world.getBlockAt(x_operate,y_operate,z_operate); 
					blockToChange.setTypeId(30);    
				}
			}
		}
	}
	public void generateLavaCube(Location point, int length){  
		World world = point.getWorld();
		int x_start = point.getBlockX();    
		int y_start = point.getBlockY();     
		int z_start = point.getBlockZ();
	 
		int x_length = x_start + length;    
		int y_length = y_start + length;
		int z_length = z_start + length;
	 
		for(int x_operate = x_start; x_operate <= x_length; x_operate++)
		{ 
			for(int y_operate = y_start; y_operate <= y_length; y_operate++)
			{
				for(int z_operate = z_start; z_operate <= z_length; z_operate++)
				{
	 
					Block blockToChange = world.getBlockAt(x_operate,y_operate,z_operate); 
					blockToChange.setTypeId(10);    
				}
			}
		}
	}
	public static NetherPVP plugin;
	
	public static Material[] slowblock = {Material.WEB};
	public static Material[] lavablock = {Material.REDSTONE_WIRE};
	
	@EventHandler
	public void onSlowBlockPlace(BlockPlaceEvent event)
	{
		int slowlength = 5;
		int lavalength = 5;
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		Block targetBlock = player.getTargetBlock(null, 50);
		Location point = targetBlock.getLocation();
		if(player.hasPermission("NetherPVP.slow"))
		{
			for (Material slow : slowblock) 
			{
				if (slow == block) 
				{
					targetBlock.getLocation();
				this.generateSlowCube(point, slowlength);
				}
			}
		}
		if(player.hasPermission("NetherPVP.lava"))
		{
			for (Material lava : lavablock) 
			{
				if (lava == block) 
				{
					targetBlock.getLocation();
					this.generateLavaCube(point, lavalength);
				}
			}
		}
	}
}


		
	

