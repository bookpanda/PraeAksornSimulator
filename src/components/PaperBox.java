package components;


import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PaperBox extends VBox{
	private int[] textWhite = { 1, 3, 5, 7, 8, 14, 18, 19, 20, 23, 24, 25, 26, 27, 28, 29 };
    private double startDragY;
    private double startDragX;
    private boolean change = false;
	private static Paper paper;
	private static PaperAbove paperAbove;
	public PaperBox() {
		this.setSpacing(1);
		paper = new Paper();
		paperAbove = new PaperAbove();
		this.getChildren().add(paperAbove);
		this.getChildren().add(paper);
		final PaperBox _self = this;
		
		
		this.setOnMousePressed(e ->  {
            startDragY = e.getSceneY();
            startDragX = e.getSceneX();
        });
		
		
		this.setOnMouseReleased(e -> {
			PaperAbove pa = (PaperAbove) _self.getChildren().get(0);
			Paper p = (Paper) _self.getChildren().get(1);
            double Y = e.getSceneY();
            double X = e.getSceneX();
            if (Y-startDragY<=-30 && p.getPage()!=29) {
            	change =true;
            	System.out.println("Current Page = "+ (p.getPage() + 2));
            	p.setPage(p.getPage() + 1);
            	pa.setPage(p.getPage() + 1);
				
            }else if (X-startDragX<=-30 && p.getPage()!=0) {
            	change =true;
            	int minus = (int) Math.ceil(Math.random()*5+10);
            	if (p.getPage()<=minus) {
            		System.out.println("Current Page = 0");
            		p.setPage(0);
            		pa.setPage(0);
            	}else {
	            	System.out.println("Current Page = "+ (p.getPage() -minus+1));
	            	p.setPage(p.getPage() -minus);
	            	pa.setPage(p.getPage() -minus);
            	}
				
				
            }else if (X-startDragX>=30 && p.getPage()!=29) {
            	change =true;
            	int plus = (int) Math.ceil(Math.random()*5+10);
            	if (p.getPage()>=29-plus) {
            		System.out.println("Current Page = 30");
            		p.setPage(29);
            		pa.setPage(29);
            	}else {
	            	System.out.println("Current Page = "+ (p.getPage() +plus+1));
	            	p.setPage(p.getPage() +plus);
	            	pa.setPage(p.getPage() +plus);
            	}
				
            
            }else if (Y-startDragY>=30&& p.getPage()!=0) {
            	change =true;
            	System.out.println("Current Page = "+ (p.getPage()));
            	p.setPage(p.getPage() - 1);
            	pa.setPage(p.getPage() - 1);
				
				
            }
            if (change) {
	            ((Text) p.getChildren().get(0)).setText(Integer.toString(p.getPage() + 1));
	            boolean flag = true;
				for (int a : textWhite) {
					System.out.println(a + " " + p.getPage());
					if (a == p.getPage()) {
						((Text) p.getChildren().get(0)).setFill(Color.WHITE);
						flag = false;
						break;
					}
				}
				if (flag)
					((Text) p.getChildren().get(0)).setFill(Color.BLACK);
				
				
				p.setStyle("-fx-background-color: " + p.getColor() + ";");
				pa.setStyle("-fx-background-color: " + p.getColor() + ";");
            }
			
        });
		}
}
