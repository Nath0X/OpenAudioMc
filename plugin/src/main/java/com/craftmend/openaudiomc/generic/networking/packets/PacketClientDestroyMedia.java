package com.craftmend.openaudiomc.generic.networking.packets;

import com.craftmend.openaudiomc.generic.networking.abstracts.AbstractPacket;
import com.craftmend.openaudiomc.generic.networking.enums.PacketChannel;
import com.craftmend.openaudiomc.generic.networking.payloads.ClientDestroyMediaPayload;

public class PacketClientDestroyMedia extends AbstractPacket {

    public PacketClientDestroyMedia(String soundId) {
        super(new ClientDestroyMediaPayload(soundId), PacketChannel.CLIENT_OUT_DESTROY_MEDIA, null);
    }

}
