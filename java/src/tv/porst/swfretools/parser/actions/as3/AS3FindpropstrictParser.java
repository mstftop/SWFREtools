package tv.porst.swfretools.parser.actions.as3;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.EncodedU30;
import tv.porst.swfretools.parser.structures.EncodedU30Parser;

/**
 * Parses ActionScript 3 'findpropstrict' instructions.
 */
public final class AS3FindpropstrictParser {

	public static AS3Findpropstrict parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 opcode = parseUINT8(parser, 0x00006, fieldName + "::opcode");
		final EncodedU30 index = EncodedU30Parser.parse(parser, fieldName + "::index");

		return new AS3Findpropstrict(opcode, index);
	}
}
