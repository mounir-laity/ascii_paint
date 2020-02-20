package g53649.AsciiPaint.model;

/**
 *
 * @author g53649
 */
public  class AddCommand implements Command{

    private Drawing paint;
    private Shape shape;

    public AddCommand(Drawing paint, Shape shape) {
        this.paint = paint;
        this.shape = shape;
    }
    
    
    @Override
    public void execute() {
        paint.addShape(shape);
    }

   @Override
   public void undo() {
//        paint.remove(shape);
    }
    
}
