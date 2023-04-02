
public class Visualizations {
// import the Jfreechart library 
	private HousingDatabase database;
	
	public ArrayList<JFreeChart> loadVisualizations(User name, JFreeChart timeseries) {
		ArrayList<JFreeChart> list = new ArrayList<JFreeChart>();
		int length = name.selectedVisualizations.length; 
		for (int i = 0; i < length; i++) { 
			if (name.selectedVisualizations[i] == "piechart") { 
				JFreeChart piechart = createPieChart(timeseries) 	
				list.add(piechart);
			} 
			else if (name.selectedVisualizations[i] == "scatterplot") { 
				JFreeChart scatterplot = createScatterPlot(timeseries) 
				list.add(scatterplot);
			} 
			else if (name.selectedVisualizations[i] == "bargraph") { 
				JFreeChart bargraph = createBarGraph(timeseries) 
				list.add(bargraph);
			}
			else if (name.selectedVisualizations[i] == "linechart") { 
				JFreeChart linechart = createLineChart(timeseries) 
				list.add(linechart);
			}	
		}
		return list;		
	}
	
	public JFrame CreateFrame(User name) { 
		JFrame frame = new JFrame("Visualizations"); // Create a frame and set its size.
		frame.setSize(800, 600); // This can change, this is just placeholder values.
		
		int frameWidth = frame.getWidth(); // Store the height and width of the frame in variables.
		int frameHeight = frame.getHeight(); 
		
		ArrayList<JFreeChart> visuals = loadVisualizations(name); // Get the visualizations the user wants 
		int length = visuals.length; 
		
		Container container = getContentPane(); // Create the container and set the grid layout so there is a column for each visualization.
		container.setLayout(new GridLayout(1, length));
		
		for (int i = 0; i < length; i++) { 
			visuals[i].getPlot().setPreferredSize(new Dimension(frameWidth/length, frameHeight)); // Set the size of each visualization to an equal portion of the frame.
			container.add(visuals[i]);
		}
		frame.setVisible(true) // Show the frame. 
		return frame;
	}
	
	public boolean tallySelections() { // Need to figure out a threshhold value
		int length = name.selectedVisualizations.length; 
		if (length > 3) { 
			return false;
		}
		else { 
			return true;
		}
	}
	
	public void ClearVisuals(JFrame frame) { // clear all visualizations
		frame.setVisible(false);
	}
}
