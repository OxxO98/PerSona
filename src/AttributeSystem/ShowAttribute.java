package AttributeSystem;

import Graphic.AttributePane;
import Graphic.MapNode;
import System.MainSystem;

public class ShowAttribute {
	
	public static void show(AttributePane AP, MapNode node) {
		if(node == null) {
			AP.attributeText[0].setText(" ");
			AP.attributeText[1].setText(" ");
			AP.attributeText[2].setText(" ");
			AP.attributeText[3].setText(" ");
			AP.attributeText[4].setText(" ");
			AP.attributeText[5].setText(" ");
		}
		else {
			AP.attributeText[0].setText(node.getData());
			AP.attributeText[1].setText(MainSystem.toString(node.getNodeX()));
			AP.attributeText[2].setText(MainSystem.toString(node.getNodeY()));
			AP.attributeText[3].setText(MainSystem.toString(node.getNodeWidth()));
			AP.attributeText[4].setText(MainSystem.toString(node.getNodeHeight()));
			AP.attributeText[5].setText(MainSystem.toString(node.getNodeColor()));
		}		
	}
	
	public static void Selected(AttributePane AP, MapNode node) {
		if(AP.SelectedNode != null) {
			AP.SelectedNode.setTransformable(false);
			AP.SelectedNode.setRevesreColor();
			AP.SelectedNode.setReverse(false);
			for(int i = 0; i < 8; i++) {
				MainSystem.getFrame().MMP.remove(AP.SelectedNode.transform[i]);
			}
		}
		AP.SelectedNode = node;
		for(int i = 0; i < 8; i++) {
			MainSystem.getFrame().MMP.add(AP.SelectedNode.transform[i]);
		}
		AP.SelectedNode.setRevesreColor();
		AP.SelectedNode.setReverse(true);
		AP.SelectedNode.setTransformable(true);
	}
	public static void Deselected(AttributePane AP) {
		if(AP.SelectedNode != null) {
			AP.SelectedNode.setTransformable(false);
			AP.SelectedNode.setRevesreColor();
			AP.SelectedNode.setReverse(false);
			for(int i = 0; i < 8; i++) {
				MainSystem.getFrame().MMP.remove(AP.SelectedNode.transform[i]);
			}
		}
		AP.SelectedNode = null;
	}
	
	public static void Apply(AttributePane AP, MapNode node) {
		node.setNodeXY(Double.parseDouble(AP.attributeText[1].getText()), Double.parseDouble(AP.attributeText[2].getText()));
		node.setDimension(Double.parseDouble(AP.attributeText[3].getText()), Double.parseDouble(AP.attributeText[4].getText()));
		node.setColor(MainSystem.toColor(AP.attributeText[5].getText()));
		node.expressNode(MainSystem.getFrame().MMP);
		node.getIncluded().refactorLink();
	}
}
