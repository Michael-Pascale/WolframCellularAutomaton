
public class GenerationFactory {
    public static Cell[] generateChildren(Cell[] parents, int rule){
        Cell[] children = new Cell[parents.length];
        //first child cannot be calculated, because the three parents do not exist
        children[0] = new Cell();
        children[0].alive = false;

        int i;
        //calculate the children based on the remainder
        for(i = 1; i < children.length -1; i++){
            int parentsNum = Integer.parseInt(parents[i-1].toString() +
                parents[i].toString() + 
                parents[i+1].toString(), 2);
            Cell cell = CellFactory.createCell(rule, parentsNum);
            children[i] = cell;
        }
        //last child in the generation cannot be calculated, because there is no right parent
        children[children.length-1] = new Cell();
        children[children.length-1].alive = false;

        return children;
    }

    public static Cell[][] createGenerations(int rule, int generations, int width){
        Cell[][] cells = new Cell[generations][width];
        //generate initial state
        for(int i = 0; i < cells[0].length; i++){
            //initial state has one solitary cell in the middle.
            //Rule 255 is all alive, so we use this for the middle one
            //rule 0 is all not alive, so we use this for the others
            if(i == cells[0].length / 2){
                cells[0][i] = CellFactory.createCell(255, 0);
            }else{
                cells[0][i] = CellFactory.createCell(0, 0);
            }
        }
        
        //generate the rest of the states
        for(int i = 1; i < cells.length; i++){
            cells[i] = generateChildren(cells[i-1], rule);
        }
        return cells;
    }
}