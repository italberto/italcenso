/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.domain;

/**
 *
 * @author italberto
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	private static final String[] CARACTERES_ESPECIAIS = {"3⁄4", "¶", "Þ", " ́", " ́ ", "·", "`", "╔", "├", "¥", "×", "\\.", ",", "-", ":", "\\(", "\\)", "ª", "\\|", "\\\\", "°", "", "'", "[?]", ";", "\\+", "#", "/", "ÿ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

	private static final String[] CARACTERES_SEM_ACENTO = { "a", "e", "i", "o", "u", "c" };

	private static final Pattern[] PATTERNS;

	private static final String IDENTIFICADOR_STR_INVALIDA = "#ERROR#";

	static {		
		PATTERNS = new Pattern[CARACTERES_SEM_ACENTO.length];
		PATTERNS[0] = Pattern.compile("[áàãâäÃÁÀÂÒß]", Pattern.CASE_INSENSITIVE); //Ò = Ã
		PATTERNS[1] = Pattern.compile("[éèêëÉÊËÛ]", Pattern.CASE_INSENSITIVE);
		PATTERNS[2] = Pattern.compile("[íìïîÍÝ]", Pattern.CASE_INSENSITIVE);
		PATTERNS[3] = Pattern.compile("[óòöõô0ÓÔÕ]", Pattern.CASE_INSENSITIVE);
		PATTERNS[4] = Pattern.compile("[úùüûÚÜ]", Pattern.CASE_INSENSITIVE);
		PATTERNS[5] = Pattern.compile("[çÇ]", Pattern.CASE_INSENSITIVE);
	}

	public static String retiraCaracterEspecial(String str) {
		if (str == null) return str;
		if (str.trim().equals("")) return null;
		str = str.trim();
		/** Troca os caracteres acentuados pelo respectivo sem acento **/
		for (int i = 0; i < PATTERNS.length; i++) {
			Matcher matcher = PATTERNS[i].matcher(str);
			str = matcher.replaceAll(CARACTERES_SEM_ACENTO[i]);
		}

		/** Troca os caracteres especiais da string por "" **/
		for (int i = 0; i < CARACTERES_ESPECIAIS.length; i++) {  
			str = str.replaceAll(CARACTERES_ESPECIAIS[i], "");  
		}
		
		/** Troca os espaços no início por "" **/  
		str = str.replaceAll("^\\s+", "");  
		/** Troca os espaços no início por "" **/  
		str = str.replaceAll("\\s+$", "");  
		/** Troca os espaços duplicados, tabulações e etc por  " " **/  
		str = str.replaceAll("\\s+", " ");
		
		/** Troca os _ (UNDERSCORE) por  " " **/  
		str = str.replaceAll("_", " ");
		
		if (!str.matches("^[\\w\\s&&[^\\d]]+$")) str = str + IDENTIFICADOR_STR_INVALIDA;
		
		return str.toUpperCase();
	}
	
	public static String lpad(String valueToPad, String filler, int size) {  
		StringBuilder builder = new StringBuilder();  
		
		while (builder.length() + valueToPad.length() < size) {  
			builder.append(filler);  
		}  
		builder.append(valueToPad);  
		return builder.toString();  
	}  
}
