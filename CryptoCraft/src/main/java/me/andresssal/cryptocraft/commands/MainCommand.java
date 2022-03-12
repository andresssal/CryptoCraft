package me.andresssal.cryptocraft.commands;

import me.andresssal.cryptocraft.trans.Transaccion;
import org.brunocvcunha.opennode.api.OpenNodeService;
import org.brunocvcunha.opennode.api.OpenNodeServiceFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

import java.io.IOException;

public class MainCommand implements CommandExecutor {

    OpenNodeService service = OpenNodeServiceFactory.buildClient("cf2c59ab-d403-4abe-b875-8a4c6225676e");


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            return true;
        Player player = (Player) sender;

        if(args.length == 0) {
            player.sendMessage("usame map /");
            return true;
        }
        MapView view = Bukkit.createMap(player.getWorld());
        view.getRenderers().clear();

        WebRender renderer = new WebRender();
        if(!renderer.load(args[0])) {
            player.sendMessage("Image not found");
            return true;
        }
        view.addRenderer(renderer);

        ItemStack map = new ItemStack(Material.FILLED_MAP);
        MapMeta meta = (MapMeta) map.getItemMeta();
        meta.setMapView(view);
        map.setItemMeta(meta);

        player.getInventory().addItem(map);
        player.sendMessage("Web loaded");


        return false;
    }

}
