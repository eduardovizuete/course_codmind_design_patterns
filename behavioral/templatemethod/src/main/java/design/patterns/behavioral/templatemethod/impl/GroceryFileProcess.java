package design.patterns.behavioral.templatemethod.impl;

import design.patterns.behavioral.templatemethod.util.OnMemoryDataBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GroceryFileProcess extends AbstractFileProcessTemplate {

    private String log = "";

    public GroceryFileProcess(File file, String logPath, String movePath) {
        super(file, logPath, movePath);
    }

    @Override
    protected void validateName() throws Exception {
        String fileName = file.getName();
        if (!fileName.endsWith(".gry")) {
            throw new Exception("Invalid file name"
                    + ", must end with .gry");
        }

        if (fileName.length() != 7) {
            throw new Exception("Invalid document format");
        }
    }

    @Override
    protected void processFile() throws Exception {
        FileInputStream input = new FileInputStream(file);
        try {
            byte[] fileContect = new byte[input.available()];
            input.read(fileContect);
            String message = new String(fileContect);
            String[] lines = message.split("\n");
            for (String line : lines) {
                String[] parts = line.split(",");
                String id = parts[0];
                String customer = parts[1];
                double amount = Double.parseDouble(parts[2]);
                String date = parts[3];
                boolean exist = OnMemoryDataBase.customerExist(
                        Integer.parseInt(customer));
                if (!exist) {
                    log += id + " E" + customer + "\t\t" + date
                            + " Customer not exist\n";
                } else if (amount > 200) {
                    log += id + " E" + customer + "\t\t" + date
                            + " The amount exceeds the maximum\n";
                } else {

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
