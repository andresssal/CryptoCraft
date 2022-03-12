package me.andresssal.cryptocraft;

import me.andresssal.cryptocraft.commands.MainCommand;
import org.brunocvcunha.opennode.api.OpenNodeService;
import org.brunocvcunha.opennode.api.OpenNodeServiceFactory;
import org.brunocvcunha.opennode.api.model.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.List;

public final class CryptoCraft extends JavaPlugin {

    OpenNodeService service = OpenNodeServiceFactory.buildClient("e40d4ca4-2fa7-4262-93af-0d1059ede616");

    @Override
    public void onEnable() {

        System.out.println("Hola");
        registrarComandos();
        try {
            loadTransaction();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registrarComandos() {
        getCommand("cc").setExecutor(new MainCommand());


    }


    public void loadTransaction() throws IOException {

        OpenNodeCharge charge1 = service.getCharge("18b17f0d-f444-4552-871a-6fb5776d0efa").execute().body().getData();
        System.out.println(charge1.getDescription() + " - " + charge1.getAmount() + " - " + charge1.getStatus());

        OpenNodeResponse<List<OpenNodeCharge>> charges = service.listCharges().execute().body();
        assert charges != null;
        for (OpenNodeCharge charge : charges.getData()) {
            System.out.println(charge.getDescription() + " - " + charge.getAmount() + " - " + charge.getStatus());
        }



    }


}
