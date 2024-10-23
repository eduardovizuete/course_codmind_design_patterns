package design.patterns.behavioral.interpreter.sql;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Context {

    // Formato de fecha que se utilizará para leer las fechas delExcel
    private SimpleDateFormat dateFormat;
    // Clase que representa al archivo de Excel y es parte del API de Apache POI
    private HSSFWorkbook workboook;
    // Representa una hoja del Excel y la clase también es parte del APIde Apache POI
    private HSSFSheet sheet;
    // Arreglo de strings con los nombres de las columnas colocados en orden
    private String[] columns;
    // URL donde se encuentra el archivo de Excel
    private final String dbPath;
    // Iterador utilizado para iterar sobre las filas del Excel
    private Iterator<Row> tableIterator;
    // Lista con todas las filas que pasarán las reglas de filtrado
    private final List<Row> resultRows = new ArrayList<>();
    // Fila que se está procesando
    private Row currentRow;
    // Lista con todos los registros a devolver como resultado de la interpretación de la
    // expresión, esta lista sólo contiene las columna solicitadas
    private List<Object[]> result;
    // Indica el número de columnas que se espera como respuesta
    private int resultColumnCount;

    public Context(String dbPath) {
        this.dbPath = dbPath;
        initiateFileRead();
    }

    public void createResultArray(int columns) {
        this.resultColumnCount = columns;
        result = new ArrayList<>();
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public List<Object[]> getResultArray() {
        return result;
    }

    public Object[] createRow() {
        Object[] row = new Object[resultColumnCount];
        result.add(row);
        return row;
    }

    public List<Row> getResultRow() {
        return resultRows;
    }


    private void initiateFileRead() {
        try {
            workboook = new HSSFWorkbook(Objects.requireNonNull(Context.class.getClassLoader()
                    .getResourceAsStream(dbPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createRowIterator() {
        tableIterator = sheet.iterator();
        tableIterator.next();
    }

    public Row getCurrentRow() {
        return currentRow;
    }

    public boolean nextRow() {
        if (tableIterator.hasNext()) {
            currentRow = tableIterator.next();
            return true;
        }
        return false;
    }

    public Iterator<Row> getRowIterator() {
        return tableIterator;
    }

    public void addCurrentRowToResults() {
        resultRows.add(currentRow);
    }

    public void destroy() {
        try {
            workboook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean tableExist(String table) {
        return loadTable(table);
    }

    private boolean loadTable(String table) {
        if (columns != null) {
            return true;
        }

        sheet = workboook.getSheet(table);
        if (sheet == null) {
            return false;
        }
        for (Row row : sheet) {
            int lastCol = row.getLastCellNum();
            columns = new String[lastCol];
            int index = 0;
            for (Cell cell : row) {
                columns[index++] = cell.getStringCellValue();
            }
            System.out.println("Table > '" + table + "' Columns > '"
                    + Arrays.toString(columns) + "'");
            break;
        }
        return true;
    }

    public boolean tableColumn(String column) {
        for (String col : columns) {
            if (col.equalsIgnoreCase(column)) {
                return true;
            }
        }
        return false;
    }

    public int columnIndex(String column) {
        for (int c = 0; c < columns.length; c++) {
            if (columns[c].equalsIgnoreCase(column)) {
                return c;
            }
        }
        throw new RuntimeException("Column '" + column + "' not exist");
    }
}