//<<<<<<< HEAD
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ArrayListDemo {
//	public static void main(String[] args) throws Exception {
//		System.out.println(Math.log(Integer.MAX_VALUE) / Math.log(2));
//	}
//
//	private static void getArrayListCapacity() throws NoSuchFieldException, IllegalAccessException {
//		List<Integer> list = new ArrayList<>(22);
//		list.add(1);
//		// 下面通过反射获取capacity 即elementData.length
//		Field f = ArrayList.class.getDeclaredField("elementData");
//		f.setAccessible(true);
//		Object[] elementData = (Object[])f.get(list);
//		System.out.println(elementData.length);
//	}
//}
//=======
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ArrayListDemo {
//	public static void main(String[] args) throws Exception {
//		System.out.println(Math.log(Integer.MAX_VALUE) / Math.log(2));
//	}
//
//	private static void getArrayListCapacity() throws NoSuchFieldException, IllegalAccessException {
//		List<Integer> list = new ArrayList<>(22);
//		list.add(1);
//		// 下面通过反射获取capacity 即elementData.length
//		Field f = ArrayList.class.getDeclaredField("elementData");
//		f.setAccessible(true);
//		Object[] elementData = (Object[])f.get(list);
//		System.out.println(elementData.length);
//	}
//}
//>>>>>>> 60c04ceb61109a267521c8ff38071a8061e1ad8a
