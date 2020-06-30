package cn.fakejson.fakejson;

import java.util.Date;
import java.util.Random;

import org.joda.time.DateTime;

import cn.fakejson.fakejson.util.RandomName;

public class FakeData {
	public static String fakeName() {
		StringBuffer stringBuffer = new StringBuffer("");

		RandomName name = new RandomName();
		stringBuffer.append(name.getName());
		return stringBuffer.toString();
	}

	public static Date fakeDate() {
		Random random = new Random();
		DateTime dt = DateTime.now().plusMinutes(random.nextInt(10000));
		Date time = dt.toDate();
		return time;
	}
}
