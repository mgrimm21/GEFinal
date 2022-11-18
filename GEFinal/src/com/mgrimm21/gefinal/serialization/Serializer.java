package com.mgrimm21.gefinal.serialization;

public class Serializer {
	
	public static final byte[] HEADER = "GS".getBytes();
	public static final short VERSION = 0x0100;
	
	public static void printBytes(byte[] data) {
		for(int i = 0; i < data.length; i++) {
			System.out.printf("0x%x ", data[i]);
		}
	}
	
	public static int write(byte[] data, int pointer, byte[] src) {
		for (int i = 0; i < src.length; i++) {
			data[pointer++] = src[i];
		}
		return pointer;
	}
	
	public static int write(byte[] data, int pointer, byte value) {
		data[pointer++] = value;
		return pointer;
	}
	
	public static int write(byte[] data, int pointer, short value) {
		data[pointer++] = (byte) ((value >> 8 ) & 0xff);
		data[pointer++] = (byte) ((value >> 0 ) & 0xff);
		return pointer;
	}
	
	public static int write(byte[] data, int pointer, String value) {
		pointer = write(data, pointer, (short)value.length());
		return write(data, pointer, value.getBytes());
		
	}
	
	public static int write(byte[] data, int pointer, char value) {
		data[pointer++] = (byte) ((value >> 8 ) & 0xff);
		data[pointer++] = (byte) ((value >> 0 ) & 0xff);
		return pointer;
	}
	
	public static int write(byte[] data, int pointer, int value) {
		data[pointer++] = (byte) ((value >> 24 ) & 0xff);
		data[pointer++] = (byte) ((value >> 16 ) & 0xff);
		data[pointer++] = (byte) ((value >> 8 ) & 0xff);
		data[pointer++] = (byte) ((value >> 0 ) & 0xff);
		return pointer;
	}
	
	public static int write(byte[] data, int pointer, long value) {
		data[pointer++] = (byte) ((value >> 56 ) & 0xff);
		data[pointer++] = (byte) ((value >> 48 ) & 0xff);
		data[pointer++] = (byte) ((value >> 40 ) & 0xff);
		data[pointer++] = (byte) ((value >> 32 ) & 0xff);
		data[pointer++] = (byte) ((value >> 24 ) & 0xff);
		data[pointer++] = (byte) ((value >> 16 ) & 0xff);
		data[pointer++] = (byte) ((value >> 8 ) & 0xff);
		data[pointer++] = (byte) ((value >> 0 ) & 0xff);
		return pointer;
	}
	
	public static int write(byte[] data, int pointer, float value) {
		int d = Float.floatToIntBits(value);
		return write(data, pointer, d);
	}
	
	public static int write(byte[] data, int pointer, double value) {
		long d = Double.doubleToLongBits(value);
		return write(data, pointer, d);
	}
	
	public static int write(byte[] data, int pointer, boolean value) {
		data[pointer++] = (byte)(value ? 1:0);
		return pointer;
	}
	
	public static int readInt(byte[] src, int pointer) {
		return (int)((src[pointer] << 56) | (src[pointer+1] << 48) | (src[pointer+2]) << 40 | (src[pointer+3] << 32) | 
				(src[pointer+4] << 24) | (src[pointer+5] << 16) | (src[pointer+6]) << 8 | src[pointer + 7]);
	}
	
	public static short readShort(byte[] src, int pointer) {
		return (short)(src[pointer] << 8 | src[pointer + 1]);
	}
	
	public static char readChar(byte[] src, int pointer) {
		return (char)(src[pointer] << 8 | src[pointer + 1]);
	}
	
	public static long readLong(byte[] src, int pointer) {
		return (long)((src[pointer] << 24) | (src[pointer+1] << 16) | (src[pointer+2]) << 8 | src[pointer + 3]);
	}
	
	public static float readFloat(byte[] src, int pointer) {
		return Float.intBitsToFloat(readInt(src, pointer));
	}
	
	public static double readDouble(byte[] src, int pointer) {
		return Double.longBitsToDouble(readLong(src, pointer));
	}
	
	public static boolean readBoolean(byte[] src, int pointer) {
		return src[pointer] !=0;
	}
	
	public static String readString(byte[] src, int pointer) {
		short length = readShort(src, pointer);
		pointer +=2;
		String s = "";
		for(int i = 0; i < length; i++) {
			char c = readChar(src, pointer);
			s += c;
			System.out.println(c);
			pointer++;
		}
		return s;
	}

}
