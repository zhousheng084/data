package com.hamob.data.utils;

public class PicURLTransform {

	public static String URL2ID(String URL)
	{
		long ret = 0L;
		long operand = 0L;
		char letter;
		long n = 0L;
		int r;
		@SuppressWarnings("unused")
		String suffix;

		if (URL == null || URL.trim().equals("") || !URL.contains("."))
		{
			return String.valueOf(ret);
		}
		suffix = URL.substring(URL.lastIndexOf("."));
		n = 0x100;
		for (int i = 0; i < URL.length(); i++)
		{
			letter = URL.charAt(i);
			operand = n | letter;
			n += 0X100;
			r = (int) ((operand >> 2) ^ operand) & 0x0f;
			ret = (ret << r) | (ret >> (32 - r));
			ret &= 0xFFFFFFFFL;
			ret ^= operand * operand;
		}
//		return String.valueOf(((ret >> 16) ^ ret)) + suffix;
		return String.valueOf(((ret >> 16) ^ ret));
	}
}