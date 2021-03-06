package cn.fakejson.fakejson;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class FakeFromEntity {

	public static <E> List<E> fakeEntityList(E fake, int size) throws IllegalAccessException, InstantiationException {
		List<E> list = new ArrayList<E>();

		for (int i = 0; i < size; i++) {
			FakeClass<E> fakeClass = new FakeClass<E>();
			E eFake = fakeClass.createContents(fake.getClass());
			fakeClass.setEntity(eFake);
			fakeClass.setSeq(i);
			list.add(fakeClass.getEntity());
		}

		return list;
	}

	public static <E> JSONArray fakejsons(E fake, int size) throws IllegalAccessException, InstantiationException {
		List<E> list = new ArrayList<E>();

		for (int i = 0; i < size; i++) {
			FakeClass<E> fakeClass = new FakeClass<E>();
			E eFake = fakeClass.createContents(fake.getClass());
			fakeClass.setEntity(eFake);
			fakeClass.setSeq(i);
			list.add(fakeClass.getEntity());
		}
		return JSONArray.parseArray(JSON.toJSONString(list));
	}

	public static <E> E fakeEntity(E fake) throws IllegalAccessException, InstantiationException {
		FakeClass<E> fakeClass = new FakeClass<E>();
		E eFake = fakeClass.createContents(fake.getClass());
		fakeClass.setEntity(eFake);
		fakeClass.setSeq(1);

		return fakeClass.getEntity();
	}
}
