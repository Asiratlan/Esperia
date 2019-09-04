package net.esperia.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityStoneSignEsperia extends TileEntitySign {
	
	public final ITextComponent[] signText = new ITextComponent[] {new TextComponentString(""), new TextComponentString(""), new TextComponentString(""), new TextComponentString("")};
    /**
     * The index of the line currently being edited. Only used on client side, but defined on both. Note this is only
     * really used when the > < are going to be visible.
     */
	private SignColor color = SignColor.BLACK;
	private boolean flag = true;
	private String colorCode = "";
	
    public int lineBeingEdited = -1;
    private boolean isEditable = true;
    private EntityPlayer player;
    private final CommandResultStats stats = new CommandResultStats();
    
    private int blockMetadata = -1;

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        for (int i = 0; i < 4; ++i)
        {
            String s = ITextComponent.Serializer.componentToJson(this.signText[i]);
            compound.setString("Text" + (i + 1), s);
        }
        compound.setString("color", this.color.name());

        this.stats.writeStatsToNBT(compound);
        return compound;
    }
    
    /*public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            //player.openGui(Esperia.instance(), GuiHandler.GUI_HRP_SIGN, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }*/
    
    @Override
    public int getBlockMetadata()
    {
        if (this.blockMetadata == -1)
        {
            IBlockState iblockstate = this.world.getBlockState(this.pos);
            this.blockMetadata = iblockstate.getBlock().getMetaFromState(iblockstate);
        }

        return this.blockMetadata;
    }
    
    public void setBlockMetadata(int metaData)
    {
    	this.blockMetadata = metaData;
    }

    protected void setWorldCreate(World worldIn)
    {
        this.setWorld(worldIn);
    }
    public void readFromNBT(NBTTagCompound compound)
    {
        this.isEditable = false;
        super.readFromNBT(compound);
        ICommandSender icommandsender = new ICommandSender()
        {
            /**
             * Get the name of this object. For players this returns their username
             */
            public String getName()
            {
                return "Sign";
            }
            /**
             * Get the formatted ChatComponent that will be used for the sender's username in chat
             */
            public ITextComponent getDisplayName()
            {
                return new TextComponentString(this.getName());
            }
            /**
             * Send a chat message to the CommandSender
             */
            public void addChatMessage(ITextComponent component)
            {
            }
            /**
             * Returns {@code true} if the CommandSender is allowed to execute the command, {@code false} if not
             */
            public boolean canUseCommand(int permLevel, String commandName)
            {
                return permLevel <= 2; //Forge: Fixes  MC-75630 - Exploit with signs and command blocks
            }
            /**
             * Get the position in the world. <b>{@code null} is not allowed!</b> If you are not an entity in the world,
             * return the coordinates 0, 0, 0
             */
            public BlockPos getPosition()
            {
                return TileEntityStoneSignEsperia.this.pos;
            }
            /**
             * Get the position vector. <b>{@code null} is not allowed!</b> If you are not an entity in the world,
             * return 0.0D, 0.0D, 0.0D
             */
            public Vec3d getPositionVector()
            {
                return new Vec3d((double)TileEntityStoneSignEsperia.this.pos.getX() + 0.5D, (double)TileEntityStoneSignEsperia.this.pos.getY() + 0.5D, (double)TileEntityStoneSignEsperia.this.pos.getZ() + 0.5D);
            }
            /**
             * Get the world, if available. <b>{@code null} is not allowed!</b> If you are not an entity in the world,
             * return the overworld
             */
            public World getEntityWorld()
            {
                return TileEntityStoneSignEsperia.this.world;
            }
            /**
             * Returns the entity associated with the command sender. MAY BE NULL!
             */
            public Entity getCommandSenderEntity()
            {
                return null;
            }
            /**
             * Returns true if the command sender should be sent feedback about executed commands
             */
            public boolean sendCommandFeedback()
            {
                return false;
            }
            public void setCommandStat(CommandResultStats.Type type, int amount)
            {
            }
            /**
             * Get the Minecraft server instance
             */
            public MinecraftServer getServer()
            {
                return TileEntityStoneSignEsperia.this.world.getMinecraftServer();
            }
        };

        for (int i = 0; i < 4; ++i)
        {
            String s = compound.getString("Text" + (i + 1));
            ITextComponent itextcomponent = ITextComponent.Serializer.jsonToComponent(s);

            try
            {
                this.signText[i] = TextComponentUtils.processComponent(icommandsender, itextcomponent, (Entity)null);
            }
            catch (CommandException var7)
            {
                this.signText[i] = itextcomponent;
            }
        }
        this.color = SignColor.valueOf(compound.getString("color"));

        this.stats.readStatsFromNBT(compound);
    }

    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.pos, 9, this.getUpdateTag());
    }

    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }

    public boolean onlyOpsCanSetNbt()
    {
        return true;
    }

    public boolean getIsEditable()
    {
        return this.isEditable;
    }

    /**
     * Sets the sign's isEditable flag to the specified parameter.
     */
    @SideOnly(Side.CLIENT)
    public void setEditable(boolean isEditableIn)
    {
        this.isEditable = isEditableIn;

        if (!isEditableIn)
        {
            this.player = null;
        }
    }

    public void setPlayer(EntityPlayer playerIn)
    {
        this.player = playerIn;
    }

    public EntityPlayer getPlayer()
    {
        return this.player;
    }

    public boolean executeCommand(final EntityPlayer playerIn)
    {
        ICommandSender icommandsender = new ICommandSender()
        {
            /**
             * Get the name of this object. For players this returns their username
             */
            public String getName()
            {
                return playerIn.getName();
            }
            /**
             * Get the formatted ChatComponent that will be used for the sender's username in chat
             */
            public ITextComponent getDisplayName()
            {
                return playerIn.getDisplayName();
            }
            /**
             * Send a chat message to the CommandSender
             */
            public void addChatMessage(ITextComponent component)
            {
            }
            /**
             * Returns {@code true} if the CommandSender is allowed to execute the command, {@code false} if not
             */
            public boolean canUseCommand(int permLevel, String commandName)
            {
                return permLevel <= 2;
            }
            /**
             * Get the position in the world. <b>{@code null} is not allowed!</b> If you are not an entity in the world,
             * return the coordinates 0, 0, 0
             */
            public BlockPos getPosition()
            {
                return TileEntityStoneSignEsperia.this.pos;
            }
            /**
             * Get the position vector. <b>{@code null} is not allowed!</b> If you are not an entity in the world,
             * return 0.0D, 0.0D, 0.0D
             */
            public Vec3d getPositionVector()
            {
                return new Vec3d((double)TileEntityStoneSignEsperia.this.pos.getX() + 0.5D, (double)TileEntityStoneSignEsperia.this.pos.getY() + 0.5D, (double)TileEntityStoneSignEsperia.this.pos.getZ() + 0.5D);
            }
            /**
             * Get the world, if available. <b>{@code null} is not allowed!</b> If you are not an entity in the world,
             * return the overworld
             */
            public World getEntityWorld()
            {
                return playerIn.getEntityWorld();
            }
            /**
             * Returns the entity associated with the command sender. MAY BE NULL!
             */
            public Entity getCommandSenderEntity()
            {
                return playerIn;
            }
            /**
             * Returns true if the command sender should be sent feedback about executed commands
             */
            public boolean sendCommandFeedback()
            {
                return false;
            }
            public void setCommandStat(CommandResultStats.Type type, int amount)
            {
                if (TileEntityStoneSignEsperia.this.world != null && !TileEntityStoneSignEsperia.this.world.isRemote)
                {
                	TileEntityStoneSignEsperia.this.stats.setCommandStatForSender(TileEntityStoneSignEsperia.this.world.getMinecraftServer(), this, type, amount);
                }
            }
            /**
             * Get the Minecraft server instance
             */
            public MinecraftServer getServer()
            {
                return playerIn.getServer();
            }
        };

        for (ITextComponent itextcomponent : this.signText)
        {
            Style style = itextcomponent == null ? null : itextcomponent.getStyle();

            if (style != null && style.getClickEvent() != null)
            {
                ClickEvent clickevent = style.getClickEvent();

                if (clickevent.getAction() == ClickEvent.Action.RUN_COMMAND)
                {
                    playerIn.getServer().getCommandManager().executeCommand(icommandsender, clickevent.getValue());
                }
            }
        }

        return true;
    }

    public CommandResultStats getStats()
    {
        return this.stats;
    }
    
    public boolean getFlag(){
    	return this.flag;
    }
    
    public void setFlag(boolean flag){
    	this.flag = flag;
    }
    
    public String getColorCode(){
    	return this.colorCode;
    }
    
    public void setColorCode(String colorCode){
    	this.colorCode = colorCode;
    }
    
    public SignColor getColor(){
    	return this.color;
    }
    
    public void setColor(SignColor color){
    	this.color = color;
    	this.markDirty();
    }
    
    public enum SignColor {
    	BLACK("000000"),
    	DARK_BLUE("0000BF"),
    	DARK_GREEN("00BF00"),
    	DARK_CYAN("00BFBF"),
    	DARK_RED("BF0000"),
    	PURPLE("BF00BF"),
    	GOLD("BFBF00"),
    	GREY("BFBFBF"),
    	DARK_GREY("404040"),
    	BLUE("4040FF"),
    	LIGHT_GREEN("49FF40"),
    	CYAN("40FFFF"),
    	RED("FF4040"),
    	PINK("FF40FF"),
    	YELLOW("FFFF40"),
    	WHITE("FFFFFF");
    	
    	private String hexacode = ""; 
    	
    	SignColor (String hexacode){
    		this.hexacode = hexacode;
    	}
    	
    	public String getHexacode(){
    		return this.hexacode;
    	}
    }

}
