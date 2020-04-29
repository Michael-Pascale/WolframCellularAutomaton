import java.awt.*;
import javax.swing.JFrame;

public class GraphicsRunner extends Canvas{
    private int rule, width;
    private Cell[][] cells;

    /**
     * paint - draws the cells in a grid pattern
     */
    public void paint(Graphics g){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                if(cells[i][j].alive){
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j*width, i*width, width, width);
            }
        }
    }

    /**
     * GraphicsRunner - constructor responsible for initializing the cells drawn in paint
     * @param rule
     * @param width
     * @param generations
     * @param size
     */
    public GraphicsRunner(int rule, int width, int generations, int size){
        this.rule = rule;
        this.width = width;
        this.cells = GenerationFactory.createGenerations(this.rule, generations, size);
    }

    public static void main(String[] args){
        //initialize to base values, in case there is no exception for whatever reason, program wont crash
        int rule = 0;
        int width = 10;
        int generations = 10;
        try{
            rule = Integer.parseInt(args[0]);
            width = Integer.parseInt(args[1]);
            generations = Integer.parseInt(args[2]);
        } catch(Exception e){
            System.out.println("Improper arguments, cancelling. Please provide rule, width, and generations in positive non zero ints(rule can be zero).");
            return;
        }
        GraphicsRunner g = new GraphicsRunner(rule, width, generations, generations*2);
        JFrame f = new JFrame();
        f.add(g);

        //size is set such that all the cells will be visible in the window
        f.setSize(generations*2*width + width *3,generations*width + 40);
        f.setVisible(true);
    }

}