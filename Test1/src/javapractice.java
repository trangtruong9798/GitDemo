import java.util.ArrayList;

public class javapractice {
public static void main(String[] args) {
	int[] lop = new int[3];
	lop[0]=1;
	lop[1]=2;
	lop[2]=3;
	for (int i =0; i<lop.length; i++) {
		i=i++;
		System.out.println(lop[i]);;
}
	System.out.println(lop[2]);
	ArrayList<String> list = new ArrayList<String>();
	list.add("Trang");
	list.add("Xinh");
	list.add("dep");
	System.out.println(list.get(2));
	for (int i=0; i<list.size(); i++) {
		System.out.println(list.get(i));
		System.out.println (list.contains("dep"));
	}
	
}}
