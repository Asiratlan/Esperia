package net.esperia.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.esperia.Esperia;
import net.esperia.network.SkinMessage;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SkinCommand implements ICommand {

	private final List aliases;
	
	public SkinCommand() {
		aliases = new ArrayList();
		aliases.add("skin");
	}

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "skin";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return this.aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		World world = sender.getEntityWorld();
		
		if (world.isRemote) {
		} else {
			if (args.length == 1 && world.getPlayerEntityByName(args[0]) instanceof EntityPlayer) {
				EntityPlayer player = world.getPlayerEntityByName(args[0]);
				UUID uuid = player.getUniqueID();
				Esperia.network.sendToAll(new SkinMessage(uuid.toString()));
			}
		}

	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}
}
