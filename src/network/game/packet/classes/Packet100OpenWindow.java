package network.game.packet.classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet100OpenWindow extends Packet
{
    public int windowId;
    public int inventoryType;
    public String windowTitle;
    public int slotsCount;
    public boolean field_94500_e;

    public Packet100OpenWindow() {}

    public Packet100OpenWindow(int par1, int par2, String par3Str, int par4, boolean par5)
    {
        this.windowId = par1;
        this.inventoryType = par2;
        this.windowTitle = par3Str;
        this.slotsCount = par4;
        this.field_94500_e = par5;
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket()
    {
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.windowId = par1DataInputStream.readByte() & 255;
        this.inventoryType = par1DataInputStream.readByte() & 255;
        this.windowTitle = readString(par1DataInputStream, 32);
        this.slotsCount = par1DataInputStream.readByte() & 255;
        this.field_94500_e = par1DataInputStream.readBoolean();
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeByte(this.windowId & 255);
        par1DataOutputStream.writeByte(this.inventoryType & 255);
        writeString(this.windowTitle, par1DataOutputStream);
        par1DataOutputStream.writeByte(this.slotsCount & 255);
        par1DataOutputStream.writeBoolean(this.field_94500_e);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 4 + this.windowTitle.length();
    }
}