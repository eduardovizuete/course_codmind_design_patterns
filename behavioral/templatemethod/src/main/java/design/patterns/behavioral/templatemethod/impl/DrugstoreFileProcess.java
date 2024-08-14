package design.patterns.behavioral.templatemethod.impl;

import design.patterns.behavioral.templatemethod.util.OnMemoryDataBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DrugstoreFileProcess extends AbstractFileProcessTemplete {

    private String log = "";

    public DrugstoreFileProcess(File file, String logPath, String movePath) {
        super(file, logPath, movePath);
    }

    @Override
    protected void validateName() throws Exception {
        String fileName = file.getName();
        if (!fileName.endsWith(".drug")) {
            throw new Exception("Invalid file name format"
                    + ", must end with .drug");
        }

        if (fileName.length() != 16) {
            throw new Exception("Invalid document format");
        }
    }

    @Override
    protected void processFile() throws Exception {
        FileInputStream input = new FileInputStream(file);
        try {
            byte[] fileContent = new byte[input.available()];
            input.read(fileContent);
            String message = new String(fileContent);
            String[] lines = message.split("\n");
            for (String line : lines) {
                String id = line.substring(0, 3);
                String customer = line.substring(3, 5);
                double amount = Double.parseDouble(line.substring(5, 8));
                String date = line.substring(8, 16);
                boolean exist = OnMemoryDataBase.customerExist(
                        Integer.parseInt(customer));

                if (!exist) {
                    log += id + " E" + customer + "\t\t" + date
                            + " Customer not exist\n";
                } else if (amount > 200) {
                    log += id + " E" + customer + "\t\t" + date
                            + " The amount exceeds the maximum\n";
                } else {
                    //TODO Aplicar el pago en algún lugar.
                    log += id + " E" + customer + "\t\t" + date
                            + " Successfully applied\n";
                }
            }
        } finally {
            try {
                input.close();
            } catch (IOException e) {
            }
        }
    }

    @Override
    protected void createLog() throws Exception {
        FileOutputStream out = null;
        try {
            File outFile = new File(logPath + "/" + file.getName());
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            out = new FileOutputStream(outFile, false);
            out.write(log.getBytes());
            out.flush();
        } finally {
            out.close();
        }
    }
    
}
