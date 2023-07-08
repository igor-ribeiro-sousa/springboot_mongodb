package com.springbootmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
<<<<<<< HEAD
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
=======
>>>>>>> 269d0757ec584c1b9672a2038d05f816ee926369

public class URL {

	public static String decodePara(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

<<<<<<< HEAD
	public static Date convertDate(String textDate, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(textDate);
			
		} catch (ParseException e) {
			return defaultValue;
			
		}
	}

=======
>>>>>>> 269d0757ec584c1b9672a2038d05f816ee926369
}
