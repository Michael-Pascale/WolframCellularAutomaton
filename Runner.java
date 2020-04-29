public class Runner{
    public static void main(String[] args){
        System.out.println("Implementation of Wolfram Cell Automata.");
        Runner.testCellCreation();
        System.out.println("Generating all possible cell combos by rule.");
        Runner.generateCellsByRule(220);
        Runner.testFamilyTree(90, 60, 150);
    }

    /**
     * Tests to see if cells are generated properly.
     * rule zero should be all zeros
     */
    public static void testCellCreation(){
        //example rule 0
        System.out.println("Rule 0: Expected 0,0,0,0,0,0,0,0");
        System.out.print("Gotten: ");
        for(int i = 7; i >= 0; i--){
            Cell cell = CellFactory.createCell(0, i);
            System.out.print(cell + ", ");
        }
        System.out.println();
    }
    
    /**
     * generateCellsByRule - given a rule, generates the possible cells
     * @param rule
     */
    public static void generateCellsByRule(int rule){
        System.out.print("Rule " + rule + ": ");
        for(int i = 7; i >= 0; i--){
            Cell cell = CellFactory.createCell(rule, i);
            System.out.print(cell + ", ");
        }
        System.out.println();
    }

    /**
     * generates cells for all 256 rules
     */
    public static void generateCellsByAllRules(){
        for(int rule = 0; rule < 256; rule++){
            System.out.print("Rule " + rule + ": ");
            for(int i = 7; i >= 0; i--){
                Cell cell = CellFactory.createCell(rule, i);
                System.out.print(cell + ", ");
            }
            System.out.println();
        }
    }

    /**
     * testGeneration - tests if the generation function in the factory works properly
     * @param rule
     * @param size
     */
    public static void testGeneration(int rule, int size){
        System.out.println("This will test rule " + rule + " over 20 generations. Below \nare the results of this.");
        //generate the initial state
        Cell[] parents = new Cell[size];
        for(int i = 0; i < parents.length; i++){
            //initial state has one solitary cell in the middle.
            //Rule 255 is all alive, so we use this for the middle one
            //rule 0 is all not alive, so we use this for the others
            if(i == parents.length / 2){
                parents[i] = CellFactory.createCell(255, 0);
            }else{
                parents[i] = CellFactory.createCell(0, 0);
            }
        }

        //run through 5 generations
        for(int i = 0; i < 20; i++){
            //print out previous generation
            for(int j = 0; j < parents.length; j++){
                System.out.print(parents[j]);
            }
            System.out.println();
            //calculate next generation
            parents = GenerationFactory.generateChildren(parents, rule);
        }
    }

    /**
     * testFamilyTree - shows in the command line a visual representation of Wolframs cells based on given parameters
     * @param rule
     * @param generations
     * @param width
     */
    public static void testFamilyTree(int rule,int generations, int width){
        Cell[][] cells = GenerationFactory.createGenerations(rule, generations, width);
        System.out.println("This tests the automatic generation. The rule is " + rule + ".");

        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
    }
}