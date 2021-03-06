package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

/**
 * Represents a GradRecord structure.
 * 
 * @author sp
 *
 */
public final class GradRecord implements IFileElement {

	/**
	 * Ratio value.
	 */
	private final UINT8 ratio;

	/**
	 * Color of gradient.
	 */
	private final RGB color;

	/**
	 * Creates a new GradRecord object.
	 * 
	 * @param ratio Ratio value.
	 * @param color Color of gradient.
	 */
	public GradRecord(final UINT8 ratio, final RGB color) {

		this.ratio = ratio;
		this.color = color;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(ratio, color);
	}

	@Override
	public int getBitPosition() {
		return ratio.getBitPosition();
	}

	/**
	 * Returns the color of gradient.
	 *
	 * @return The color of gradient.
	 */
	public RGB getColor() {
		return color;
	}

	/**
	 * Returns the ratio value.
	 *
	 * @return The ratio value.
	 */
	public UINT8 getRatio() {
		return ratio;
	}
}