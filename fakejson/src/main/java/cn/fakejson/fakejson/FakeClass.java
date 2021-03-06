package cn.fakejson.fakejson;

import java.lang.reflect.Field;
import java.util.Date;

import org.joda.time.DateTime;

import cn.fakejson.fakejson.util.RandomName;

public class FakeClass<E> implements Cloneable {

	private E entity;

	private int size;

	private int seq;

	public E getEntity() throws IllegalAccessException {
		Field[] fields = entity.getClass().getDeclaredFields();

		for (Field field : fields) {

			field.setAccessible(true);

			switch (field.getGenericType().getTypeName()) {
			case "java.util.Date":
				DateTime dt = DateTime.now().plusMinutes(seq);
				Date time = dt.toDate();

				field.set(entity, time);

				break;

			case "java.lang.String":
				StringBuffer stringBuffer = new StringBuffer("");

				if (field.getName().toLowerCase().contains("code")) {
					stringBuffer.append(field.getName() + seq);

				} else if (field.getName().toLowerCase().contains("name")) {
					RandomName name = new RandomName();
					stringBuffer.append(name.getName());

				} else if (field.getName().toLowerCase().contains("memo")) {
					stringBuffer.append("备注");

				}

				field.set(entity, stringBuffer.toString());

				break;
			default:
				break;
			}
			// // 获取字段的名字
			// System.out.printf("字段：%-4s|", field.getName());
			// // 获取字段的类型的Class类，然后获取规范化的名字
			// System.out.printf("类型：%-18s|", field.getGenericType().getTypeName());
			// // 使用Field.getModifiers()，可获取字段的修饰符编码，
			// // 然后再使用Modifier.toString(int code)，来解码成字字符串
			// System.out.printf("修饰符：%s", Modifier.toString(field.getModifiers()));
			// System.out.println();
		}
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String upperCase(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	public E createContents(Class<? extends Object> class1) throws InstantiationException, IllegalAccessException {
		return (E) class1.newInstance();
	}

	@Override
	protected FakeClass<E> clone() throws CloneNotSupportedException {
		return (FakeClass<E>) super.clone();
	}
}
