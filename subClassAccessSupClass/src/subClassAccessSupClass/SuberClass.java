package subClassAccessSupClass;

public class SuberClass extends SuperClass {
	
	public SuberClass() {
		
		super("");
		
	}
	
	public static void main(String[] args) {
		//super类似于JavaScript里的prototype的_proto_指针，指向一个父对象
		SuberClass.newInstance();
		
	}

}
