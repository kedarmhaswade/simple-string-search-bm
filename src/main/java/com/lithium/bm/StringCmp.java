package com.lithium.bm;

import java.util.HashSet;
import java.util.Random;

/**
 * Created by kedar.mhaswade on 8/8/14.
 */
public class StringCmp {
	private static final char[] OBSCURE_SPECIAL_CHARS = { '#', '+', '-', '=', '@', '^', '_', '`', '~', '‘', '’', '¡',
			'¢', '£', '¥', '¦', '§', '©', 'ª', '«', '¬', '®', '°', '±', '²', '³', '´', 'µ', '¶', '·', '¹', 'º', '»',
			'¼', '½', '¾', '¿', 'À', 'Á', 'Â', 'Ã', 'Ä', 'Å', 'Æ', 'Ç', 'È', 'É', 'Ê', 'Ë', 'Ì', 'Í', 'Î', 'Ï', 'Ð',
			'Ñ', 'Ò', 'Ù', 'Ú', 'Û', 'Ü', 'Ý', 'Þ', 'ß', 'à', 'á', 'â', 'ã', 'ä', 'å', 'æ', 'ç', 'è', 'é', 'ê', 'ë',
			'ì', 'í', 'î', 'ï', 'ð', 'ñ', 'ò', 'ó', 'ô', 'õ', 'ö', '÷', 'ø', 'ù', 'ú', 'û', 'ü', 'ý', 'þ', 'ÿ' };
	private static final HashSet<Character> specials = new HashSet<>(OBSCURE_SPECIAL_CHARS.length);
	static {
		for (char c : OBSCURE_SPECIAL_CHARS)
			specials.add(c);
	}
	public static String replaceUsingQuadraticAlgoritm(String s) {
		char[] chars = s.toCharArray();
		for (char c : OBSCURE_SPECIAL_CHARS) {
			for (int i = 0; i < chars.length; i++) {
				if (c == chars[i])
					chars[i] = ' ';  //replaced
			}
		}
		return new String(chars);
	}
	public static String replaceUsingHashSet(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++)
			if (specials.contains(chars[i]))
				chars[i] = ' '; //replace
		return new String(chars);
	}
	static String randomString(int length) {
		//contains some specials, mostly ascii
		char[] chars = new char[length];
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < length; i++)
			chars[i] = (char)('a' + r.nextInt(25));
		for (int i = 0; i < 10; i++)
			chars[r.nextInt(chars.length)] = OBSCURE_SPECIAL_CHARS[r.nextInt(OBSCURE_SPECIAL_CHARS.length)];

		return new String(chars);
	}
	public static void main(String[] args) throws RuntimeException {
		String s = randomString(Integer.valueOf(args[0]));
		long t1 = System.currentTimeMillis();
		String s1 = replaceUsingQuadraticAlgoritm(s);
		System.out.println("Quad: " + (System.currentTimeMillis()-t1) + " ms");
		long t2 = System.currentTimeMillis();
		String s2 = replaceUsingHashSet(s);
		System.out.println("Hash: " + (System.currentTimeMillis()-t2) + " ms");
		assert s1.equals(s2);
	}
}
