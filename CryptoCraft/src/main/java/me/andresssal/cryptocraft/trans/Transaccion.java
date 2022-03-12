package me.andresssal.cryptocraft.trans;

import org.brunocvcunha.opennode.api.OpenNodeService;
import org.brunocvcunha.opennode.api.OpenNodeServiceFactory;
import org.brunocvcunha.opennode.api.model.*;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class Transaccion {

    OpenNodeService service = OpenNodeServiceFactory.buildClient("cf2c59ab-d403-4abe-b875-8a4c6225676e");

    private String commandID;

    private String transID;

    private boolean transactionCompleted;


    public Transaccion() throws IOException {
        this.transactionCompleted = false;





    }
    public String getCommandID() {
        return commandID;
    }

    public void setCommandID(String commandID) {
        this.commandID = commandID;
    }

    public boolean isTransactionCompleted() {
        return transactionCompleted;
    }

    public void setTransactionCompleted(boolean transactionCompleted) {
        this.transactionCompleted = transactionCompleted;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }
}
