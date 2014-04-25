package org.hyperion.hypercon.spec;

import org.mufassa.model.AbstractModel;
import org.mufassa.model.ParameterInt;
import org.mufassa.model.ParameterObject;
import org.mufassa.model.json.JsonComment;

/**
 * The device specific configuration
 */
@JsonComment(
		"Device configuration contains the following fields: \n" +
		" * 'name'       : The user friendly name of the device (only used for display purposes)\n" +
		" * 'type'       : The type of the device or leds (known types for now are 'ws2801', 'ldp8806',\n" +
		"                  'lpd6803', 'sedu', 'adalight', 'lightpack', 'test' and 'none')\n" +
		" * 'output'     : The output specification depends on selected device. This can for example be the\n" +
		"                  device specifier, device serial number, or the output file name\n" +
		" * 'rate'       : The baudrate of the output to the device\n" +
		" * 'colorOrder' : The order of the color bytes ('rgb', 'rbg', 'bgr', etc.).")
public class DeviceConfigModel extends AbstractModel {
	
	public DeviceConfigModel() {
		super();
		initialize();
	}
	
	/** The name of the device */
	public final ParameterObject<String> mName = new ParameterObject<String>("name", "MyPi");
	
	/** The type specification of the device */
	public final ParameterObject<DeviceType> mType = new ParameterObject<DeviceType>("type", DeviceType.ws2801);
	
	/** The device 'file' name */
	public final ParameterObject<String> mOutput   = new ParameterObject<String>("output", "/dev/spidev0.0");
	
	/** The baudrate of the device */
	public final ParameterInt mBaudrate = new ParameterInt("baudrate", 250000, 48000, 2000000);
	
	/** The order of the color bytes */
	public final ParameterObject<ColorByteOrder> mColorByteOrder = new ParameterObject<ColorByteOrder>("colorByteOrder", ColorByteOrder.RGB);	
}