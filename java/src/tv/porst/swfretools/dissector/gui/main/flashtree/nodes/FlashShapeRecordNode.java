package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import tv.porst.swfretools.parser.structures.CurvedEdgeRecord;
import tv.porst.swfretools.parser.structures.EndShapeRecord;
import tv.porst.swfretools.parser.structures.ShapeRecord;
import tv.porst.swfretools.parser.structures.StraightEdgeRecord;
import tv.porst.swfretools.parser.structures.StyleChangeRecord;

/**
 * Node that represents a ShapeRecord object in the Flash tree.
 */
public final class FlashShapeRecordNode extends FlashTreeNode<ShapeRecord> {

	/**
	 * Returns the exact shape name for a given shape record.
	 * 
	 * @param shapeRecord The shape record.
	 * 
	 * @return The shape name of the shape record.
	 */
	private static String getShapeName(final ShapeRecord shapeRecord) {

		if (shapeRecord instanceof CurvedEdgeRecord) {
			return "CurvedEdgeRecord";
		}
		else if (shapeRecord instanceof StraightEdgeRecord) {
			return "StraightEdgeRecord";
		}
		else if (shapeRecord instanceof StyleChangeRecord) {
			return "StyleChangeRecord";
		}
		else if (shapeRecord instanceof EndShapeRecord) {
			return "EndShapeRecord";
		}
		else {
			throw new IllegalStateException("Unknown shape record");
		}
	}

	/**
	 * Creates a new node object
	 * 
	 * @param name Name of the node.
	 * @param value Flash structure represented by the node.
	 */
	public FlashShapeRecordNode(final String name, final ShapeRecord value) {
		super(name, value);

		createChildren();
	}

	/**
	 * Creates the child nodes of the node.
	 */
	private void createChildren() {
		final ShapeRecord shapeRecord = getUserObject();

		if (shapeRecord instanceof CurvedEdgeRecord) {
			final CurvedEdgeRecord crecord = (CurvedEdgeRecord) shapeRecord;
			addNode("TypeFlag", crecord.getTypeFlag());
			addNode("StraightFlag", crecord.getStraightFlag());
			addNode("NumBits", crecord.getNumBits());
			addNode("ControlDeltaX", crecord.getControlDeltaX());
			addNode("ControlDeltaY", crecord.getControlDeltaY());
			addNode("AnchorDeltaX", crecord.getAnchorDeltaX());
			addNode("AnchorDeltaY", crecord.getAnchorDeltaY());
		}
		else if (shapeRecord instanceof StraightEdgeRecord) {
			final StraightEdgeRecord crecord = (StraightEdgeRecord) shapeRecord;
			addNode("TypeFlag", crecord.getTypeFlag());
			addNode("StraightFlag", crecord.getStraightFlag());
			addNode("NumBits", crecord.getNumBits());
			addNode("GeneralLineFlag", crecord.getGeneralLineFlag());
			addNode("VertLineFlag", crecord.getVertLineFlag());
			addNode("DeltaX", crecord.getDeltaX());
			addNode("DeltaY", crecord.getDeltaY());
		}
		else if (shapeRecord instanceof StyleChangeRecord) {
			final StyleChangeRecord crecord = (StyleChangeRecord) shapeRecord;
			addNode("TypeFlag", crecord.getTypeFlag());
			addNode("StateNewStyles", crecord.getStateNewStyles());
			addNode("StateLineStyle", crecord.getStateLineStyle());
			addNode("FillStyle1", crecord.getFillStyle1());
			addNode("FillStyle0", crecord.getFillStyle0());
			addNode("StateMoveTo", crecord.getStateMoveTo());
			addNode("MoveBits", crecord.getMoveBits());
			addNode("MoveDeltaX", crecord.getMoveDeltaX());
			addNode("MoveDeltaY", crecord.getMoveDeltaY());
			addNode("FillStyle0", crecord.getFillStyle0());
			addNode("FillStyle1", crecord.getFillStyle1());
			addNode("LineStyle", crecord.getLineStyle());
			addNode("FillStyles", crecord.getFillStyles());
			addNode("LineStyles", crecord.getLineStyles());
			addNode("TypeFlag", crecord.getNumFillBits());
			addNode("TypeFlag", crecord.getNumLineBits());
		}
		else if (shapeRecord instanceof EndShapeRecord) {
			final EndShapeRecord crecord = (EndShapeRecord) shapeRecord;
			addNode("TypeFlag", crecord.getTypeFlag());
			addNode("EndOfShape", crecord.getEndOfShape());
		}
		else {
			throw new IllegalStateException("Unknown shape record");
		}
	}

	@Override
	public String toString() {
		return String.format("%s : %s", getName(), getShapeName(getUserObject()));
	}
}