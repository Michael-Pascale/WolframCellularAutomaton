public class CellFactory{

    /**
     * createCell - creates a cell based on the rule and the parents
     * @param rule
     * @param parents
     * @return
     */
    public static Cell createCell(int rule, int parents){
        Cell cell = new Cell();
        cell.alive = CellFactory.getBit(rule, parents);
        return cell;
    }

    /**
     * getBit - returns the nth bit from num, where n starts at 0
     * @param num
     * @param n
     * @return a boolean representing that bit, true being 1 and zero being false
     */
    public static Boolean getBit(int num, int n){
        return ((num >> (n)) & 1) == 1;
    }
}