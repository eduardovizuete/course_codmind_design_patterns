package design.patterns.behavioral.templatemethod.impl;

import design.patterns.behavioral.templatemethod.util.OnMemoryDataBase;
import java.io.File;

public abstract class AbstractFileProcessTemplate {
    
    protected File file;
    protected String logPath;
    protected String movePath;

    public AbstractFileProcessTemplate(File file, String logPath, String movePath) {
        this.file = file;
        this.logPath = logPath;
        this.movePath = movePath;
    }

    public final void execute() throws Exception {
        validateName();
        validateProcess();
        processFile();
        createLog();
        moveDocument();
        markAsProcessFile();
    }

    protected abstract void validateName() throws Exception;

    protected void validateProcess() throws Exception {
        String fileStatus = OnMemoryDataBase.getFileStatus(file.getName());
        if (fileStatus != null && fileStatus.equals("Processed")) {
            throw new Exception("The file '" + file.getName() + "' has already been processed");
        }
    }

    protected abstract void processFile() throws Exception;

    protected abstract void createLog() throws Exception;

    private void moveDocument() throws Exception {
        String newPath = movePath+"/"+file.getName();
        boolean change = file.renameTo(new File(newPath));
    }
    
    protected void markAsProcessFile() throws Exception{
        OnMemoryDataBase.setProcessFile(file.getName());
    }
    
}
